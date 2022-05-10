package com.cxl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxl.dao.CategoryDao;
import com.cxl.entity.Category;
import com.cxl.service.CategoryService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<CategoryDao, Category> implements CategoryService {

    @Override
    public Page<Category> listPage(Category entity, int pageNum, int pageSize) {
        QueryWrapper<Category> qw = new QueryWrapper<>();
        if (entity != null && entity.getType() != null) {
            qw.eq("type", entity.getType());
        }
        return  baseMapper.selectPage(new Page<>(pageNum, pageSize),qw);
    }

    @Override
    public List<Category> list(Category entity) {
        return baseMapper.selectList(Wrappers.<Category>query().orderByAsc("sort"));
    }
}
