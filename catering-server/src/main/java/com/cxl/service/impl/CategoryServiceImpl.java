package com.cxl.service.impl;

import com.cxl.dao.CategoryDao;
import com.cxl.entity.Category;
import com.cxl.service.CategoryService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl extends BaseServiceImpl<CategoryDao, Category> implements CategoryService {
}
