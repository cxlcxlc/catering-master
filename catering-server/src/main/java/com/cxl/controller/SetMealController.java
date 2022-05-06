package com.cxl.controller;

import com.cxl.entity.SetMeal;
import com.cxl.service.SetMealService;
import com.cxl.utils.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setMeals")
public class SetMealController extends BaseController<SetMealService, SetMeal> {
}
