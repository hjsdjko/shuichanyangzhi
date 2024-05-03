
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
 * 饲料
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/siliao")
public class SiliaoController {
    private static final Logger logger = LoggerFactory.getLogger(SiliaoController.class);

    private static final String TABLE_NAME = "siliao";

    @Autowired
    private SiliaoService siliaoService;


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
        PageUtils page = siliaoService.queryPage(params);

        //字典表数据转换
        List<SiliaoView> list =(List<SiliaoView>)page.getList();
        for(SiliaoView c:list){
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
        SiliaoEntity siliao = siliaoService.selectById(id);
        if(siliao !=null){
            //entity转view
            SiliaoView view = new SiliaoView();
            BeanUtils.copyProperties( siliao , view );//把实体数据重构到view中
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
    public R save(@RequestBody SiliaoEntity siliao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,siliao:{}",this.getClass().getName(),siliao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<SiliaoEntity> queryWrapper = new EntityWrapper<SiliaoEntity>()
            .eq("siliao_name", siliao.getSiliaoName())
            .eq("siliao_number", siliao.getSiliaoNumber())
            .eq("siliao_danwei", siliao.getSiliaoDanwei())
            .eq("siliao_types", siliao.getSiliaoTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SiliaoEntity siliaoEntity = siliaoService.selectOne(queryWrapper);
        if(siliaoEntity==null){
            siliao.setInsertTime(new Date());
            siliao.setCreateTime(new Date());
            siliaoService.insert(siliao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SiliaoEntity siliao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,siliao:{}",this.getClass().getName(),siliao.toString());
        SiliaoEntity oldSiliaoEntity = siliaoService.selectById(siliao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(siliao.getSiliaoPhoto()) || "null".equals(siliao.getSiliaoPhoto())){
                siliao.setSiliaoPhoto(null);
        }
        if("".equals(siliao.getSiliaoFile()) || "null".equals(siliao.getSiliaoFile())){
                siliao.setSiliaoFile(null);
        }

            siliaoService.updateById(siliao);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<SiliaoEntity> oldSiliaoList =siliaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        siliaoService.deleteBatchIds(Arrays.asList(ids));

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
            List<SiliaoEntity> siliaoList = new ArrayList<>();//上传的东西
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
                            SiliaoEntity siliaoEntity = new SiliaoEntity();
//                            siliaoEntity.setSiliaoUuidNumber(data.get(0));                    //饲料编号 要改的
//                            siliaoEntity.setSiliaoName(data.get(0));                    //饲料名称 要改的
//                            siliaoEntity.setSiliaoPhoto("");//详情和图片
//                            siliaoEntity.setSiliaoFile(data.get(0));                    //附件 要改的
//                            siliaoEntity.setSiliaoNumber(Integer.valueOf(data.get(0)));   //数量 要改的
//                            siliaoEntity.setSiliaoDanwei(data.get(0));                    //单位 要改的
//                            siliaoEntity.setSiliaoTypes(Integer.valueOf(data.get(0)));   //饲料类型 要改的
//                            siliaoEntity.setSiliaoContent("");//详情和图片
//                            siliaoEntity.setInsertTime(date);//时间
//                            siliaoEntity.setCreateTime(date);//时间
                            siliaoList.add(siliaoEntity);


                            //把要查询是否重复的字段放入map中
                                //饲料编号
                                if(seachFields.containsKey("siliaoUuidNumber")){
                                    List<String> siliaoUuidNumber = seachFields.get("siliaoUuidNumber");
                                    siliaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> siliaoUuidNumber = new ArrayList<>();
                                    siliaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("siliaoUuidNumber",siliaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //饲料编号
                        List<SiliaoEntity> siliaoEntities_siliaoUuidNumber = siliaoService.selectList(new EntityWrapper<SiliaoEntity>().in("siliao_uuid_number", seachFields.get("siliaoUuidNumber")));
                        if(siliaoEntities_siliaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SiliaoEntity s:siliaoEntities_siliaoUuidNumber){
                                repeatFields.add(s.getSiliaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [饲料编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        siliaoService.insertBatch(siliaoList);
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
        PageUtils page = siliaoService.queryPage(params);

        //字典表数据转换
        List<SiliaoView> list =(List<SiliaoView>)page.getList();
        for(SiliaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SiliaoEntity siliao = siliaoService.selectById(id);
            if(siliao !=null){


                //entity转view
                SiliaoView view = new SiliaoView();
                BeanUtils.copyProperties( siliao , view );//把实体数据重构到view中

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
    public R add(@RequestBody SiliaoEntity siliao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,siliao:{}",this.getClass().getName(),siliao.toString());
        Wrapper<SiliaoEntity> queryWrapper = new EntityWrapper<SiliaoEntity>()
            .eq("siliao_uuid_number", siliao.getSiliaoUuidNumber())
            .eq("siliao_name", siliao.getSiliaoName())
            .eq("siliao_number", siliao.getSiliaoNumber())
            .eq("siliao_danwei", siliao.getSiliaoDanwei())
            .eq("siliao_types", siliao.getSiliaoTypes())
//            .notIn("siliao_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SiliaoEntity siliaoEntity = siliaoService.selectOne(queryWrapper);
        if(siliaoEntity==null){
            siliao.setInsertTime(new Date());
            siliao.setCreateTime(new Date());
        siliaoService.insert(siliao);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

