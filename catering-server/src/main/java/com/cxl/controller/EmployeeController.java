package com.cxl.controller;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cxl.dto.ResponseBean;
import com.cxl.entity.Employee;
import com.cxl.service.EmployeeService;
import com.cxl.utils.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/employee")
@RequiresRoles("0")
public class EmployeeController extends BaseController<EmployeeService, Employee> {

    @Override
    public void beforeSave(Employee entity) {
        if (entity != null && entity.getPassword() != null && entity.getPassword().length() < 20) {
            entity.setPassword(SecureUtil.md5(entity.getPassword()));
        }
    }

    @GetMapping("/findByUserName/{username}")
    public ResponseBean<Employee> employee(@PathVariable("username") String username) {
        Employee employee = service.getBaseMapper().selectOne(Wrappers.<Employee>query().eq("username", username));
        if (employee == null) {
            return ResponseBean.error();
        }
        return ResponseBean.success(employee);
    }


    @GetMapping("/findCountByRole/{role}")
    public ResponseBean<Integer> count(@PathVariable Integer role) {
        return ResponseBean.success(service.count(Wrappers.<Employee>query().eq("role", role)));
    }



}
