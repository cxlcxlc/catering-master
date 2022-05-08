package com.cxl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxl.dao.EmployeeDao;
import com.cxl.entity.Category;
import com.cxl.entity.Employee;
import com.cxl.service.EmployeeService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl extends BaseServiceImpl<EmployeeDao, Employee> implements EmployeeService {

    @Override
    public Page<Employee> listPage(Employee entity, int pageNum, int pageSize) {
        QueryWrapper<Employee> qw = new QueryWrapper<>();
        if (entity != null && entity.getName() != null) {
            qw.like("name", entity.getName());
        }
        return baseMapper.selectPage(new Page<>(pageNum, pageSize), qw);
    }
}
