package com.cxl.controller;

import com.cxl.entity.SetMealDish;
import com.cxl.service.SetMealDishService;
import com.cxl.utils.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setMealDish")
public class SetMealDishController extends BaseController<SetMealDishService, SetMealDish> {
}
