package com.cxl.dao;

import com.cxl.entity.Employee;
import com.cxl.utils.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends BaseDao<Employee> {
}
