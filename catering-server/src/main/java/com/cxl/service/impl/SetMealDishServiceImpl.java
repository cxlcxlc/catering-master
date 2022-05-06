package com.cxl.service.impl;

import com.cxl.dao.SetMealDishDao;
import com.cxl.entity.SetMealDish;
import com.cxl.service.SetMealDishService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SetMealDishServiceImpl extends BaseServiceImpl<SetMealDishDao, SetMealDish> implements SetMealDishService {
}
