package com.cxl.controller;

import com.cxl.entity.DishFlavor;
import com.cxl.service.DishFlavorService;
import com.cxl.utils.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dishFlavor")
public class DishFlavorController extends BaseController<DishFlavorService, DishFlavor> {
}
