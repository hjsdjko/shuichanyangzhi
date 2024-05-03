package com.dao;

import com.entity.YangzhiquyuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YangzhiquyuView;

/**
 * 养殖区域 Dao 接口
 *
 * @author 
 */
public interface YangzhiquyuDao extends BaseMapper<YangzhiquyuEntity> {

   List<YangzhiquyuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
