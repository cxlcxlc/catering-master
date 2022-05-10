package com.cxl.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxl.dao.DishDao;
import com.cxl.dto.DishDto;
import com.cxl.entity.Category;
import com.cxl.entity.Dish;
import com.cxl.entity.DishFlavor;
import com.cxl.service.CategoryService;
import com.cxl.service.DishFlavorService;
import com.cxl.service.DishService;
import com.cxl.utils.BaseServiceImpl;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DishServiceImpl extends BaseServiceImpl<DishDao, Dish> implements DishService{

    @Resource
    private CategoryService categoryService;

    @Resource
    private DishFlavorService dishFlavorService;

    @Override
    public Page<Dish> listPage(Dish entity, int pageNum, int pageSize) {
        QueryWrapper<Dish> qw = new QueryWrapper<>();
        if (entity != null && entity.getName() != null) {
            qw.like("name", entity.getName());
        }
        Page<Dish> dishPage = baseMapper.selectPage(new Page<>(pageNum, pageSize), qw);
        List<Dish> records = dishPage.getRecords();
        for (Dish record : records) {
            record.setCategory(categoryService.getById(record.getCategoryId()));
        }
        return dishPage;
    }

    @Override
    public List<Dish> list(Dish entity) {
        return baseMapper.selectList(Wrappers.<Dish>query().orderByAsc("sort"));
    }

    @Override
    public DishDto getDishDtoById(Long id) {
        Dish dish = baseMapper.selectById(id);
        Category category = categoryService.getById(dish.getCategoryId());
        DishDto dishDto = new DishDto();
        dishDto.setCategory(category);
        dishDto.setCategoryName(category.getName());
        BeanUtil.copyProperties(dish, dishDto);
        dishDto.setFlavors(dishFlavorService.getByDishId(id));
        return dishDto;
    }

    @Override
    public boolean saveDishDto(DishDto dishDto) {
        if (dishDto == null) return false;
        Dish dish = new Dish();
        BeanUtil.copyProperties(dishDto, dish);
        if (dish.insert()) {
            List<DishFlavor> flavors = dishDto.getFlavors();
            boolean result = true;
            for (DishFlavor flavor : flavors) {
                flavor.setUserId(dishDto.getUserId());
                flavor.setDishId(dishDto.getId());
                result &= flavor.insert();
            }
            return result;
        }
        return false;
    }

    @Override
    public boolean updateDishDto(DishDto dishDto) {
        if (dishDto == null || dishDto.getId() == null) return false;
        Dish dish = new Dish();
        BeanUtil.copyProperties(dishDto, dish);
        if (dish.updateById()) {
            boolean result;
            result = dishFlavorService.remove(Wrappers.<DishFlavor>query().eq("dish_id", dish.getId()));
            List<DishFlavor> flavors = dishDto.getFlavors();
            for (DishFlavor flavor : flavors) {
                flavor.setId(null);
                flavor.setDishId(dish.getId());
                flavor.setUserId(dishDto.getUserId());
                if (!(StringUtil.isEmpty(flavor.getName()) || flavor.getValue().equals("[]"))) {
                    result &= flavor.insert();
                }
            }
            return result;
        }
        return false;
    }
}
