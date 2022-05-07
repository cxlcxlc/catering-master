package com.cxl.controller;

import com.cxl.entity.Category;
import com.cxl.service.CategoryService;
import com.cxl.utils.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController<CategoryService, Category> {
}
