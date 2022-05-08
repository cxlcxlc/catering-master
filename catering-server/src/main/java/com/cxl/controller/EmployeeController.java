package com.cxl.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cxl.dto.ResponseBean;
import com.cxl.entity.Employee;
import com.cxl.service.EmployeeService;
import com.cxl.utils.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseController<EmployeeService, Employee> {


    @GetMapping("/findByUserName/{username}")
    public ResponseBean<Employee> employee(@PathVariable String username) {
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
