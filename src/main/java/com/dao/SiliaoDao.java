package com.dao;

import com.entity.SiliaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SiliaoView;

/**
 * 饲料 Dao 接口
 *
 * @author 
 */
public interface SiliaoDao extends BaseMapper<SiliaoEntity> {

   List<SiliaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
