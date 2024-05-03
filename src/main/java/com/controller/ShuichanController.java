
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 水产
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shuichan")
public class ShuichanController {
    private static final Logger logger = LoggerFactory.getLogger(ShuichanController.class);

    private static final String TABLE_NAME = "shuichan";

    @Autowired
    private ShuichanService shuichanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private NewsService newsService;//水产资讯
    @Autowired
    private ShuichanCollectionService shuichanCollectionService;//水产收藏
    @Autowired
    private ShuizhiService shuizhiService;//水质
    @Autowired
    private SiliaoService siliaoService;//饲料
    @Autowired
    private SiliaoShiyongService siliaoShiyongService;//饲料使用
    @Autowired
    private YangzhiquyuService yangzhiquyuService;//养殖区域
    @Autowired
    private YangzhiquyuCollectionService yangzhiquyuCollectionService;//养殖区域收藏
    @Autowired
    private YangzhiquyuLiuyanService yangzhiquyuLiuyanService;//养殖区域留言
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = shuichanService.queryPage(params);

        //字典表数据转换
        List<ShuichanView> list =(List<ShuichanView>)page.getList();
        for(ShuichanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShuichanEntity shuichan = shuichanService.selectById(id);
        if(shuichan !=null){
            //entity转view
            ShuichanView view = new ShuichanView();
            BeanUtils.copyProperties( shuichan , view );//把实体数据重构到view中
            //级联表 养殖区域
            //级联表
            YangzhiquyuEntity yangzhiquyu = yangzhiquyuService.selectById(shuichan.getYangzhiquyuId());
            if(yangzhiquyu != null){
            BeanUtils.copyProperties( yangzhiquyu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYangzhiquyuId(yangzhiquyu.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shuichan.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShuichanEntity shuichan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shuichan:{}",this.getClass().getName(),shuichan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shuichan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShuichanEntity> queryWrapper = new EntityWrapper<ShuichanEntity>()
            .eq("yangzhiquyu_id", shuichan.getYangzhiquyuId())
            .eq("yonghu_id", shuichan.getYonghuId())
            .eq("shuichan_name", shuichan.getShuichanName())
            .eq("shuichan_types", shuichan.getShuichanTypes())
            .eq("shuichan_number", shuichan.getShuichanNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShuichanEntity shuichanEntity = shuichanService.selectOne(queryWrapper);
        if(shuichanEntity==null){
            shuichan.setInsertTime(new Date());
            shuichan.setCreateTime(new Date());
            shuichanService.insert(shuichan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShuichanEntity shuichan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shuichan:{}",this.getClass().getName(),shuichan.toString());
        ShuichanEntity oldShuichanEntity = shuichanService.selectById(shuichan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shuichan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(shuichan.getShuichanPhoto()) || "null".equals(shuichan.getShuichanPhoto())){
                shuichan.setShuichanPhoto(null);
        }
        if("".equals(shuichan.getShuichanFile()) || "null".equals(shuichan.getShuichanFile())){
                shuichan.setShuichanFile(null);
        }

            shuichanService.updateById(shuichan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShuichanEntity> oldShuichanList =shuichanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shuichanService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ShuichanEntity> shuichanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShuichanEntity shuichanEntity = new ShuichanEntity();
//                            shuichanEntity.setYangzhiquyuId(Integer.valueOf(data.get(0)));   //养殖区域 要改的
//                            shuichanEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shuichanEntity.setShuichanName(data.get(0));                    //水产名称 要改的
//                            shuichanEntity.setShuichanUuidNumber(data.get(0));                    //水产编号 要改的
//                            shuichanEntity.setShuichanPhoto("");//详情和图片
//                            shuichanEntity.setShuichanFile(data.get(0));                    //水产附件 要改的
//                            shuichanEntity.setShuichanTypes(Integer.valueOf(data.get(0)));   //水产类型 要改的
//                            shuichanEntity.setShuichanNumber(Integer.valueOf(data.get(0)));   //养殖数量 要改的
//                            shuichanEntity.setToufangTime(sdf.parse(data.get(0)));          //投放日期 要改的
//                            shuichanEntity.setLaochuTime(sdf.parse(data.get(0)));          //捞出日期 要改的
//                            shuichanEntity.setShuichanContent("");//详情和图片
//                            shuichanEntity.setInsertTime(date);//时间
//                            shuichanEntity.setCreateTime(date);//时间
                            shuichanList.add(shuichanEntity);


                            //把要查询是否重复的字段放入map中
                                //水产编号
                                if(seachFields.containsKey("shuichanUuidNumber")){
                                    List<String> shuichanUuidNumber = seachFields.get("shuichanUuidNumber");
                                    shuichanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shuichanUuidNumber = new ArrayList<>();
                                    shuichanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shuichanUuidNumber",shuichanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //水产编号
                        List<ShuichanEntity> shuichanEntities_shuichanUuidNumber = shuichanService.selectList(new EntityWrapper<ShuichanEntity>().in("shuichan_uuid_number", seachFields.get("shuichanUuidNumber")));
                        if(shuichanEntities_shuichanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShuichanEntity s:shuichanEntities_shuichanUuidNumber){
                                repeatFields.add(s.getShuichanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [水产编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shuichanService.insertBatch(shuichanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ShuichanView> returnShuichanViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = shuichanCollectionService.queryPage(params1);
        List<ShuichanCollectionView> collectionViewsList =(List<ShuichanCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ShuichanCollectionView collectionView:collectionViewsList){
            Integer shuichanTypes = collectionView.getShuichanTypes();
            if(typeMap.containsKey(shuichanTypes)){
                typeMap.put(shuichanTypes,typeMap.get(shuichanTypes)+1);
            }else{
                typeMap.put(shuichanTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("shuichanTypes",type);
            PageUtils pageUtils1 = shuichanService.queryPage(params2);
            List<ShuichanView> shuichanViewList =(List<ShuichanView>)pageUtils1.getList();
            returnShuichanViewList.addAll(shuichanViewList);
            if(returnShuichanViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = shuichanService.queryPage(params);
        if(returnShuichanViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnShuichanViewList.size();//要添加的数量
            List<ShuichanView> shuichanViewList =(List<ShuichanView>)page.getList();
            for(ShuichanView shuichanView:shuichanViewList){
                Boolean addFlag = true;
                for(ShuichanView returnShuichanView:returnShuichanViewList){
                    if(returnShuichanView.getId().intValue() ==shuichanView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnShuichanViewList.add(shuichanView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnShuichanViewList = returnShuichanViewList.subList(0, limit);
        }

        for(ShuichanView c:returnShuichanViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnShuichanViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shuichanService.queryPage(params);

        //字典表数据转换
        List<ShuichanView> list =(List<ShuichanView>)page.getList();
        for(ShuichanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShuichanEntity shuichan = shuichanService.selectById(id);
            if(shuichan !=null){


                //entity转view
                ShuichanView view = new ShuichanView();
                BeanUtils.copyProperties( shuichan , view );//把实体数据重构到view中

                //级联表
                    YangzhiquyuEntity yangzhiquyu = yangzhiquyuService.selectById(shuichan.getYangzhiquyuId());
                if(yangzhiquyu != null){
                    BeanUtils.copyProperties( yangzhiquyu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYangzhiquyuId(yangzhiquyu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shuichan.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShuichanEntity shuichan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shuichan:{}",this.getClass().getName(),shuichan.toString());
        Wrapper<ShuichanEntity> queryWrapper = new EntityWrapper<ShuichanEntity>()
            .eq("yangzhiquyu_id", shuichan.getYangzhiquyuId())
            .eq("yonghu_id", shuichan.getYonghuId())
            .eq("shuichan_name", shuichan.getShuichanName())
            .eq("shuichan_uuid_number", shuichan.getShuichanUuidNumber())
            .eq("shuichan_types", shuichan.getShuichanTypes())
            .eq("shuichan_number", shuichan.getShuichanNumber())
//            .notIn("shuichan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShuichanEntity shuichanEntity = shuichanService.selectOne(queryWrapper);
        if(shuichanEntity==null){
            shuichan.setInsertTime(new Date());
            shuichan.setCreateTime(new Date());
        shuichanService.insert(shuichan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

