package com.cxl.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxl.dao.CategoryDao;
import com.cxl.entity.Category;
import com.cxl.service.CategoryService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<CategoryDao, Category> implements CategoryService {

    @Override
    public Page<Category> listPage(Category entity, int pageNum, int pageSize) {
        return  baseMapper.selectPage(new Page<>(pageNum, pageSize), Wrappers.<Category>query().orderByAsc("sort"));
    }

}
