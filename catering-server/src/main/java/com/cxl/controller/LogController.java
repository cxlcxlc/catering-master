package com.cxl.controller;

import com.cxl.dto.ResponseBean;
import com.cxl.entity.Employee;
import com.cxl.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping
@RestController
public class LogController {

    @Resource
    private EmployeeService employeeService;

    @PostMapping("/employee/login")
    public ResponseBean<String> login(@RequestBody Employee employee) {
        if (employee == null || employee.getUsername() == null) return ResponseBean.error();
        return ResponseBean.success(employeeService.login(employee.getUsername(), employee.getPassword()));
    }
    @GetMapping("/employee/logout")
    public ResponseBean<String> logout() {
        SecurityUtils.getSubject().logout();
        return ResponseBean.success("操作成功");
    }

}
