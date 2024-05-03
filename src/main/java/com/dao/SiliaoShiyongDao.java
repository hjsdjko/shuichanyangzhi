package com.dao;

import com.entity.SiliaoShiyongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SiliaoShiyongView;

/**
 * 饲料使用 Dao 接口
 *
 * @author 
 */
public interface SiliaoShiyongDao extends BaseMapper<SiliaoShiyongEntity> {

   List<SiliaoShiyongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
