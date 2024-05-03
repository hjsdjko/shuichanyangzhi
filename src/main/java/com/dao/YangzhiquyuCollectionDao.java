package com.dao;

import com.entity.YangzhiquyuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YangzhiquyuCollectionView;

/**
 * 养殖区域收藏 Dao 接口
 *
 * @author 
 */
public interface YangzhiquyuCollectionDao extends BaseMapper<YangzhiquyuCollectionEntity> {

   List<YangzhiquyuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
