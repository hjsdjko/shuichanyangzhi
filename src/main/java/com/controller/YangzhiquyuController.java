
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
 * 养殖区域
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yangzhiquyu")
public class YangzhiquyuController {
    private static final Logger logger = LoggerFactory.getLogger(YangzhiquyuController.class);

    private static final String TABLE_NAME = "yangzhiquyu";

    @Autowired
    private YangzhiquyuService yangzhiquyuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private NewsService newsService;//水产资讯
    @Autowired
    private ShuichanService shuichanService;//水产
    @Autowired
    private ShuichanCollectionService shuichanCollectionService;//水产收藏
    @Autowired
    private ShuizhiService shuizhiService;//水质
    @Autowired
    private SiliaoService siliaoService;//饲料
    @Autowired
    private SiliaoShiyongService siliaoShiyongService;//饲料使用
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
        PageUtils page = yangzhiquyuService.queryPage(params);

        //字典表数据转换
        List<YangzhiquyuView> list =(List<YangzhiquyuView>)page.getList();
        for(YangzhiquyuView c:list){
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
        YangzhiquyuEntity yangzhiquyu = yangzhiquyuService.selectById(id);
        if(yangzhiquyu !=null){
            //entity转view
            YangzhiquyuView view = new YangzhiquyuView();
            BeanUtils.copyProperties( yangzhiquyu , view );//把实体数据重构到view中
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
    public R save(@RequestBody YangzhiquyuEntity yangzhiquyu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yangzhiquyu:{}",this.getClass().getName(),yangzhiquyu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YangzhiquyuEntity> queryWrapper = new EntityWrapper<YangzhiquyuEntity>()
            .eq("yangzhiquyu_name", yangzhiquyu.getYangzhiquyuName())
            .eq("yangzhiquyu_address", yangzhiquyu.getYangzhiquyuAddress())
            .eq("yangzhiquyu_types", yangzhiquyu.getYangzhiquyuTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YangzhiquyuEntity yangzhiquyuEntity = yangzhiquyuService.selectOne(queryWrapper);
        if(yangzhiquyuEntity==null){
            yangzhiquyu.setInsertTime(new Date());
            yangzhiquyu.setCreateTime(new Date());
            yangzhiquyuService.insert(yangzhiquyu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YangzhiquyuEntity yangzhiquyu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yangzhiquyu:{}",this.getClass().getName(),yangzhiquyu.toString());
        YangzhiquyuEntity oldYangzhiquyuEntity = yangzhiquyuService.selectById(yangzhiquyu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(yangzhiquyu.getYangzhiquyuPhoto()) || "null".equals(yangzhiquyu.getYangzhiquyuPhoto())){
                yangzhiquyu.setYangzhiquyuPhoto(null);
        }

            yangzhiquyuService.updateById(yangzhiquyu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YangzhiquyuEntity> oldYangzhiquyuList =yangzhiquyuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yangzhiquyuService.deleteBatchIds(Arrays.asList(ids));

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
            List<YangzhiquyuEntity> yangzhiquyuList = new ArrayList<>();//上传的东西
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
                            YangzhiquyuEntity yangzhiquyuEntity = new YangzhiquyuEntity();
//                            yangzhiquyuEntity.setYangzhiquyuName(data.get(0));                    //区域名称 要改的
//                            yangzhiquyuEntity.setYangzhiquyuUuidNumber(data.get(0));                    //养殖区域编号 要改的
//                            yangzhiquyuEntity.setYangzhiquyuPhoto("");//详情和图片
//                            yangzhiquyuEntity.setYangzhiquyuAddress(data.get(0));                    //养殖区域地点 要改的
//                            yangzhiquyuEntity.setYangzhiquyuTypes(Integer.valueOf(data.get(0)));   //养殖区域类型 要改的
//                            yangzhiquyuEntity.setYangzhiquyuContent("");//详情和图片
//                            yangzhiquyuEntity.setInsertTime(date);//时间
//                            yangzhiquyuEntity.setCreateTime(date);//时间
                            yangzhiquyuList.add(yangzhiquyuEntity);


                            //把要查询是否重复的字段放入map中
                                //养殖区域编号
                                if(seachFields.containsKey("yangzhiquyuUuidNumber")){
                                    List<String> yangzhiquyuUuidNumber = seachFields.get("yangzhiquyuUuidNumber");
                                    yangzhiquyuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yangzhiquyuUuidNumber = new ArrayList<>();
                                    yangzhiquyuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yangzhiquyuUuidNumber",yangzhiquyuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //养殖区域编号
                        List<YangzhiquyuEntity> yangzhiquyuEntities_yangzhiquyuUuidNumber = yangzhiquyuService.selectList(new EntityWrapper<YangzhiquyuEntity>().in("yangzhiquyu_uuid_number", seachFields.get("yangzhiquyuUuidNumber")));
                        if(yangzhiquyuEntities_yangzhiquyuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YangzhiquyuEntity s:yangzhiquyuEntities_yangzhiquyuUuidNumber){
                                repeatFields.add(s.getYangzhiquyuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [养殖区域编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yangzhiquyuService.insertBatch(yangzhiquyuList);
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
        List<YangzhiquyuView> returnYangzhiquyuViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = yangzhiquyuCollectionService.queryPage(params1);
        List<YangzhiquyuCollectionView> collectionViewsList =(List<YangzhiquyuCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(YangzhiquyuCollectionView collectionView:collectionViewsList){
            Integer yangzhiquyuTypes = collectionView.getYangzhiquyuTypes();
            if(typeMap.containsKey(yangzhiquyuTypes)){
                typeMap.put(yangzhiquyuTypes,typeMap.get(yangzhiquyuTypes)+1);
            }else{
                typeMap.put(yangzhiquyuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("yangzhiquyuTypes",type);
            PageUtils pageUtils1 = yangzhiquyuService.queryPage(params2);
            List<YangzhiquyuView> yangzhiquyuViewList =(List<YangzhiquyuView>)pageUtils1.getList();
            returnYangzhiquyuViewList.addAll(yangzhiquyuViewList);
            if(returnYangzhiquyuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = yangzhiquyuService.queryPage(params);
        if(returnYangzhiquyuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnYangzhiquyuViewList.size();//要添加的数量
            List<YangzhiquyuView> yangzhiquyuViewList =(List<YangzhiquyuView>)page.getList();
            for(YangzhiquyuView yangzhiquyuView:yangzhiquyuViewList){
                Boolean addFlag = true;
                for(YangzhiquyuView returnYangzhiquyuView:returnYangzhiquyuViewList){
                    if(returnYangzhiquyuView.getId().intValue() ==yangzhiquyuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnYangzhiquyuViewList.add(yangzhiquyuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnYangzhiquyuViewList = returnYangzhiquyuViewList.subList(0, limit);
        }

        for(YangzhiquyuView c:returnYangzhiquyuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnYangzhiquyuViewList);
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
        PageUtils page = yangzhiquyuService.queryPage(params);

        //字典表数据转换
        List<YangzhiquyuView> list =(List<YangzhiquyuView>)page.getList();
        for(YangzhiquyuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YangzhiquyuEntity yangzhiquyu = yangzhiquyuService.selectById(id);
            if(yangzhiquyu !=null){


                //entity转view
                YangzhiquyuView view = new YangzhiquyuView();
                BeanUtils.copyProperties( yangzhiquyu , view );//把实体数据重构到view中

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
    public R add(@RequestBody YangzhiquyuEntity yangzhiquyu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yangzhiquyu:{}",this.getClass().getName(),yangzhiquyu.toString());
        Wrapper<YangzhiquyuEntity> queryWrapper = new EntityWrapper<YangzhiquyuEntity>()
            .eq("yangzhiquyu_name", yangzhiquyu.getYangzhiquyuName())
            .eq("yangzhiquyu_uuid_number", yangzhiquyu.getYangzhiquyuUuidNumber())
            .eq("yangzhiquyu_address", yangzhiquyu.getYangzhiquyuAddress())
            .eq("yangzhiquyu_types", yangzhiquyu.getYangzhiquyuTypes())
//            .notIn("yangzhiquyu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YangzhiquyuEntity yangzhiquyuEntity = yangzhiquyuService.selectOne(queryWrapper);
        if(yangzhiquyuEntity==null){
            yangzhiquyu.setInsertTime(new Date());
            yangzhiquyu.setCreateTime(new Date());
        yangzhiquyuService.insert(yangzhiquyu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

