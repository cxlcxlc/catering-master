package com.cxl.controller;

import com.cxl.entity.User;
import com.cxl.service.UserService;
import com.cxl.utils.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserService, User> {
}
