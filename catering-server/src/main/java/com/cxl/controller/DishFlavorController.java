package com.cxl.controller;

import com.cxl.dto.ResponseBean;
import com.cxl.entity.DishFlavor;
import com.cxl.service.DishFlavorService;
import com.cxl.utils.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dishFlavor")
public class DishFlavorController extends BaseController<DishFlavorService, DishFlavor> {

    @GetMapping("/getByDishId/{id}")
    public ResponseBean<List<DishFlavor>> dishFlavors(@PathVariable Long id) {
        return ResponseBean.success(service.getByDishId(id));
    }
}
