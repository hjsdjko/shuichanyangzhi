package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.SiliaoDao;
import com.entity.SiliaoEntity;
import com.service.SiliaoService;
import com.entity.view.SiliaoView;

/**
 * 饲料 服务实现类
 */
@Service("siliaoService")
@Transactional
public class SiliaoServiceImpl extends ServiceImpl<SiliaoDao, SiliaoEntity> implements SiliaoService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<SiliaoView> page =new Query<SiliaoView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
