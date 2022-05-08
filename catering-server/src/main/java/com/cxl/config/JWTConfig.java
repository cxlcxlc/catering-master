package com.cxl.config;

import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWTUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


import java.util.Calendar;
import java.util.Map;

@Component
public class JWTConfig {

    /**
     * 生成token  header.payload.signature
     */
    private static final String signature = "!q@we#cxl)zxc(cxl$*avi@";

    public static String getToken(Map<String,String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,3);//3天过期
        JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);
        return builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(signature));
    }

    public static JSONObject parseToken(String token) {
        cn.hutool.jwt.JWT jwt = JWTUtil.parseToken(token);
        return jwt.getPayloads();
    }

    /**
     * 验证token 合法性
     */
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(signature)).build().verify(token);
    }
}
