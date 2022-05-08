package com.cxl.service;

import com.cxl.entity.Employee;
import com.cxl.utils.BaseService;

public interface EmployeeService extends BaseService<Employee> {

    String login(String username, String password);
}
