package com.cxl.service;

import com.cxl.dto.DishDto;
import com.cxl.entity.Dish;
import com.cxl.utils.BaseService;

public interface DishService extends BaseService<Dish> {

    DishDto getDishDtoById(Long id);

    boolean saveDishDto(DishDto dishDto);

    boolean updateDishDto(DishDto dishDto);
}
