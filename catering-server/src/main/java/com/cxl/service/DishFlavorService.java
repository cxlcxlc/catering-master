package com.cxl.service;

import com.cxl.entity.DishFlavor;
import com.cxl.utils.BaseService;

import java.util.List;

public interface DishFlavorService extends BaseService<DishFlavor> {

    List<DishFlavor> getByDishId(Long dishId);
}
