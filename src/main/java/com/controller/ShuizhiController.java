
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
 * 水质
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shuizhi")
public class ShuizhiController {
    private static final Logger logger = LoggerFactory.getLogger(ShuizhiController.class);

    private static final String TABLE_NAME = "shuizhi";

    @Autowired
    private ShuizhiService shuizhiService;


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
        PageUtils page = shuizhiService.queryPage(params);

        //字典表数据转换
        List<ShuizhiView> list =(List<ShuizhiView>)page.getList();
        for(ShuizhiView c:list){
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
        ShuizhiEntity shuizhi = shuizhiService.selectById(id);
        if(shuizhi !=null){
            //entity转view
            ShuizhiView view = new ShuizhiView();
            BeanUtils.copyProperties( shuizhi , view );//把实体数据重构到view中
            //级联表 养殖区域
            //级联表
            YangzhiquyuEntity yangzhiquyu = yangzhiquyuService.selectById(shuizhi.getYangzhiquyuId());
            if(yangzhiquyu != null){
            BeanUtils.copyProperties( yangzhiquyu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYangzhiquyuId(yangzhiquyu.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(shuizhi.getYonghuId());
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
    public R save(@RequestBody ShuizhiEntity shuizhi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shuizhi:{}",this.getClass().getName(),shuizhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shuizhi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShuizhiEntity> queryWrapper = new EntityWrapper<ShuizhiEntity>()
            .eq("yangzhiquyu_id", shuizhi.getYangzhiquyuId())
            .eq("yonghu_id", shuizhi.getYonghuId())
            .eq("shuizhi_time", new SimpleDateFormat("yyyy-MM-dd").format(shuizhi.getShuizhiTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShuizhiEntity shuizhiEntity = shuizhiService.selectOne(queryWrapper);
        if(shuizhiEntity==null){
            shuizhi.setInsertTime(new Date());
            shuizhi.setCreateTime(new Date());
            shuizhiService.insert(shuizhi);
            return R.ok();
        }else {
            return R.error(511,"该用户该天已经记录了该区域的水质情况");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShuizhiEntity shuizhi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shuizhi:{}",this.getClass().getName(),shuizhi.toString());
        ShuizhiEntity oldShuizhiEntity = shuizhiService.selectById(shuizhi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shuizhi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(shuizhi.getShuizhiPhoto()) || "null".equals(shuizhi.getShuizhiPhoto())){
                shuizhi.setShuizhiPhoto(null);
        }
        if("".equals(shuizhi.getShuizhiFile()) || "null".equals(shuizhi.getShuizhiFile())){
                shuizhi.setShuizhiFile(null);
        }

            shuizhiService.updateById(shuizhi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShuizhiEntity> oldShuizhiList =shuizhiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shuizhiService.deleteBatchIds(Arrays.asList(ids));

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
            List<ShuizhiEntity> shuizhiList = new ArrayList<>();//上传的东西
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
                            ShuizhiEntity shuizhiEntity = new ShuizhiEntity();
//                            shuizhiEntity.setYangzhiquyuId(Integer.valueOf(data.get(0)));   //养殖区域 要改的
//                            shuizhiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shuizhiEntity.setShuizhiUuidNumber(data.get(0));                    //水质编号 要改的
//                            shuizhiEntity.setShuizhiPhoto("");//详情和图片
//                            shuizhiEntity.setShuizhiFile(data.get(0));                    //附件 要改的
//                            shuizhiEntity.setShuizhiTypes(Integer.valueOf(data.get(0)));   //水质状态 要改的
//                            shuizhiEntity.setShuizhiTime(sdf.parse(data.get(0)));          //所属日期 要改的
//                            shuizhiEntity.setShuizhiContent("");//详情和图片
//                            shuizhiEntity.setInsertTime(date);//时间
//                            shuizhiEntity.setCreateTime(date);//时间
                            shuizhiList.add(shuizhiEntity);


                            //把要查询是否重复的字段放入map中
                                //水质编号
                                if(seachFields.containsKey("shuizhiUuidNumber")){
                                    List<String> shuizhiUuidNumber = seachFields.get("shuizhiUuidNumber");
                                    shuizhiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shuizhiUuidNumber = new ArrayList<>();
                                    shuizhiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shuizhiUuidNumber",shuizhiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //水质编号
                        List<ShuizhiEntity> shuizhiEntities_shuizhiUuidNumber = shuizhiService.selectList(new EntityWrapper<ShuizhiEntity>().in("shuizhi_uuid_number", seachFields.get("shuizhiUuidNumber")));
                        if(shuizhiEntities_shuizhiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShuizhiEntity s:shuizhiEntities_shuizhiUuidNumber){
                                repeatFields.add(s.getShuizhiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [水质编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shuizhiService.insertBatch(shuizhiList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shuizhiService.queryPage(params);

        //字典表数据转换
        List<ShuizhiView> list =(List<ShuizhiView>)page.getList();
        for(ShuizhiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShuizhiEntity shuizhi = shuizhiService.selectById(id);
            if(shuizhi !=null){


                //entity转view
                ShuizhiView view = new ShuizhiView();
                BeanUtils.copyProperties( shuizhi , view );//把实体数据重构到view中

                //级联表
                    YangzhiquyuEntity yangzhiquyu = yangzhiquyuService.selectById(shuizhi.getYangzhiquyuId());
                if(yangzhiquyu != null){
                    BeanUtils.copyProperties( yangzhiquyu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYangzhiquyuId(yangzhiquyu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shuizhi.getYonghuId());
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
    public R add(@RequestBody ShuizhiEntity shuizhi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shuizhi:{}",this.getClass().getName(),shuizhi.toString());

        Wrapper<ShuizhiEntity> queryWrapper = new EntityWrapper<ShuizhiEntity>()
                .eq("yangzhiquyu_id", shuizhi.getYangzhiquyuId())
                .eq("yonghu_id", shuizhi.getYonghuId())
                .eq("shuizhi_time", new SimpleDateFormat("yyyy-MM-dd").format(shuizhi.getShuizhiTime()))
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShuizhiEntity shuizhiEntity = shuizhiService.selectOne(queryWrapper);
        if(shuizhiEntity==null){
            shuizhi.setInsertTime(new Date());
            shuizhi.setCreateTime(new Date());
            shuizhiService.insert(shuizhi);
            return R.ok();
        }else {
            return R.error(511,"该用户该天已经记录了该区域的水质情况");
        }
    }

}

