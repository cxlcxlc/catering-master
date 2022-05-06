package com.cxl.service.impl;

import com.cxl.dao.SetMealDao;
import com.cxl.entity.SetMeal;
import com.cxl.service.SetMealService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SetMealServiceImpl extends BaseServiceImpl<SetMealDao, SetMeal> implements SetMealService {
}
