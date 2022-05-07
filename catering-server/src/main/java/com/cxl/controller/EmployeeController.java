package com.cxl.controller;

import com.cxl.entity.Employee;
import com.cxl.service.EmployeeService;
import com.cxl.utils.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseController<EmployeeService, Employee> {
}
