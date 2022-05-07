package com.cxl.service.impl;

import com.cxl.dao.UserDao;
import com.cxl.entity.User;
import com.cxl.service.UserService;
import com.cxl.utils.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements UserService {
}
