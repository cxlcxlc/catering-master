package com.cxl.service.impl;

import com.cxl.dao.EmployeeDao;
import com.cxl.entity.Employee;
import com.cxl.service.EmployeeService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl extends BaseServiceImpl<EmployeeDao, Employee> implements EmployeeService {
}
