package com.cxl.service;

import com.cxl.entity.SetMeal;
import com.cxl.utils.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface SetMealService extends BaseService<SetMeal> {
}
