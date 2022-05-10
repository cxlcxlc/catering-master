package com.cxl.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cxl.dao.DishFlavorDao;
import com.cxl.entity.DishFlavor;
import com.cxl.service.DishFlavorService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DishFlavorServiceImpl extends BaseServiceImpl<DishFlavorDao, DishFlavor> implements DishFlavorService {

    @Override
    public List<DishFlavor> getByDishId(Long dishId) {
        return baseMapper.selectList(Wrappers.<DishFlavor>query().eq("dish_id", dishId));
    }
}
