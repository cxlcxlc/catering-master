package com.cxl.config;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends BasicHttpAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //返回值true表示请求向下继续执行
        //判断请求头中是否包含token
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getHeader("token") != null) {
            //调用认证方法,认证结果就代表本次是否放行
            boolean res = false;
            try {
                res = executeLogin(request, response);
            }catch (Exception e) {
                executeException(req, response, "/exception/402");
            }
            return res;
        }
        executeException(req, response, "/exception/401");
        //返回值false shiro会抛出401异常
        return false;
    }

    public void executeException(HttpServletRequest req, ServletResponse response, String url) {
        try {
            req.getRequestDispatcher(url).forward(req, response);
        } catch (ServletException | IOException ignored) {
        }
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        //调用领域类中的方法执行认证
        Subject subject = SecurityUtils.getSubject();
        String token = req.getHeader("token");
        DecodedJWT verify = JWTConfig.verify(token);
        if (verify == null) return false;
        req.setAttribute("userId", JWTConfig.parseToken(token).get("id"));
        //让shiro通过领域类完成认证
        subject.login(new JWTToken(token));//执行认证 不是登陆
        return true;
    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        //处理跨域
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        //如果请求方式是options，代表着是预检请求，因此，直接放行
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}

