package com.cxl.utils;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseBean<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    public static <T> ResponseBean<T> success(T object) {
        ResponseBean<T> responseBean = new ResponseBean<T>();
        responseBean.data = object;
        responseBean.code = 1;
        return responseBean;
    }

    public static <T> ResponseBean<T> error(String msg) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.msg = msg;
        responseBean.code = 0;
        return responseBean;
    }

    public ResponseBean<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
