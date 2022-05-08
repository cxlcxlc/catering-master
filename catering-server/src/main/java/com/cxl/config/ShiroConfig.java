package com.cxl.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {

    //1.创建shiroFilter 负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        //实例化Shiro过滤器工厂
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //在工厂中注入安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //将我们自己的filter添加到Shiro
        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
        filters.put("jwt",new JWTFilter());
        //创建一个有序键值对用于存储黑白名单
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        //anon表示无须登陆就能访问的资源地址
        filterChainDefinitionMap.put("/employee/login/**", "anon");
        filterChainDefinitionMap.put("/user/login/**", "anon");
        //其余所有请求地址均需要通过jwt校验
        filterChainDefinitionMap.put("/**", "jwt");
        //将黑白名单配置到shiro过滤器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager initSecurityManager(Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean("realm")
    public JWTRealm getRealm(){
        return new JWTRealm();
    }

}
