package com.cxl.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cxl.dto.DishDto;
import com.cxl.dto.ResponseBean;
import com.cxl.entity.Dish;
import com.cxl.service.DishService;
import com.cxl.utils.BaseController;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController extends BaseController<DishService, Dish> {


    @PutMapping("/batchEditStatus/{status}")
    public ResponseBean<String> batchEditStatus(@PathVariable Integer status, @RequestBody List<Long> ids) {
        if (service.update(Wrappers.<Dish>update().set("status", status).in("id", ids))) {
            return ResponseBean.success("操作成功");
        }
        return ResponseBean.error("操作失败");
    }

    @GetMapping("/getDishDtoById/{id}")
    public ResponseBean<DishDto> dishDto(@PathVariable Long id) {
        return ResponseBean.success(service.getDishDtoById(id));
    }

    @PostMapping("/saveDishDto")
    public ResponseBean<String> dishDto(@RequestBody DishDto dishDto, HttpServletRequest request) {
        dishDto.setUserId(Long.valueOf((String) request.getAttribute("userId")));
        return service.saveDishDto(dishDto) ? ResponseBean.success("操作成功") : ResponseBean.error("操作失败");
    }

    @PutMapping("/updateDishDto")
    public ResponseBean<String> editDishDto(@RequestBody DishDto dishDto, HttpServletRequest request) {
        dishDto.setUserId(Long.valueOf((String) request.getAttribute("userId")));
        return service.updateDishDto(dishDto) ? ResponseBean.success("操作成功") : ResponseBean.error("操作失败");
    }
}
