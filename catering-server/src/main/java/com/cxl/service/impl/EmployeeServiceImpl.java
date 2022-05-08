package com.cxl.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxl.config.JWTConfig;
import com.cxl.dao.EmployeeDao;
import com.cxl.entity.Category;
import com.cxl.entity.Employee;
import com.cxl.service.EmployeeService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

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


    @Override
    public String login(String username, String password) {
        Employee employee = baseMapper.selectOne(Wrappers.<Employee>query().eq("username", username));
        if(employee != null && employee.getStatus() != 0 && SecureUtil.md5(password).equals(employee.getPassword())){
            Map<String, String> userMap = new HashMap<>();
            userMap.put("id", String.valueOf(employee.getId()));
            userMap.put("username",username);
            userMap.put("name",employee.getName());
            userMap.put("role",String.valueOf(employee.getRole()));
            return JWTConfig.getToken(userMap);
        }
        return null;
    }
}
