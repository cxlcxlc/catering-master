package com.cxl.service.impl;

import com.cxl.dao.DishDao;
import com.cxl.entity.Dish;
import com.cxl.service.DishService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DishServiceImpl extends BaseServiceImpl<DishDao, Dish> implements DishService{
}
