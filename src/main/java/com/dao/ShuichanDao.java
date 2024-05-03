package com.dao;

import com.entity.ShuichanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShuichanView;

/**
 * 水产 Dao 接口
 *
 * @author 
 */
public interface ShuichanDao extends BaseMapper<ShuichanEntity> {

   List<ShuichanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
