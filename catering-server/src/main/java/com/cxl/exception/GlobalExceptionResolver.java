package com.cxl.exception;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.cxl.dto.ResponseBean;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "com.cxl")
@ResponseBody
public class GlobalExceptionResolver {

    @ExceptionHandler({AlgorithmMismatchException.class, InvalidClaimException.class, SignatureVerificationException.class})
    public ResponseBean<String> ExceptionHandler() {
        ResponseBean<String> bean = new ResponseBean<>();
        bean.setCode(401);
        bean.setMsg("登录异常");
        return bean;
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseBean<String> exceptionHandler(NullPointerException e) {
        return ResponseBean.error("内部服务器异常");
    }


    @ExceptionHandler(TokenExpiredException.class)
    @ResponseBody
    public ResponseBean<String> ExceptionHandler(TokenExpiredException e) {
        ResponseBean<String> bean = new ResponseBean<>();
        bean.setCode(403);
        bean.setMsg("登录过期");
        return bean;
    }


    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseBody
    public ResponseBean<String> unauthenticatedExceptionHandler() {
        ResponseBean<String> bean = new ResponseBean<>();
        bean.setCode(402);
        bean.setMsg("未登录");
        return bean;
    }

    @ExceptionHandler(UnknownAccountException.class)
    @ResponseBody
    public ResponseBean<String> unknownAccountExceptionHandler() {
        return ResponseBean.error("用户名错误");

    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    @ResponseBody
    public ResponseBean<String> incorrectCredentialsExceptionHandler() {
        return ResponseBean.error("密码错误");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseBean<String> ExceptionHandler(Exception e) {
        return ResponseBean.error(e.getMessage());
    }

}
