package com.cxl.service.impl;

import com.cxl.dao.DishFlavorDao;
import com.cxl.entity.DishFlavor;
import com.cxl.service.DishFlavorService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DishFlavorServiceImpl extends BaseServiceImpl<DishFlavorDao, DishFlavor> implements DishFlavorService {
}
