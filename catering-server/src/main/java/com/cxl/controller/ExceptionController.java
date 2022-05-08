package com.cxl.controller;

import com.cxl.dto.ResponseBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/401")
    public ResponseBean<String> exception() {
        ResponseBean<String> responseBean = new ResponseBean<>();
        responseBean.setMsg("未登录");
        responseBean.setCode(401);
        return responseBean;
    }

    @GetMapping("/402")
    public ResponseBean<String> exception2() {
        ResponseBean<String> responseBean = new ResponseBean<>();
        responseBean.setMsg("登录异常");
        responseBean.setCode(402);
        return responseBean;
    }

}
