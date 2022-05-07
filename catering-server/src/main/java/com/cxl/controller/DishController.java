package com.cxl.controller;

import com.cxl.entity.Dish;
import com.cxl.service.DishService;
import com.cxl.utils.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dish")
public class DishController extends BaseController<DishService, Dish> {
}
