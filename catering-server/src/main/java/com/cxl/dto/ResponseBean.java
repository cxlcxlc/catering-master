package com.cxl.dto;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseBean<T> {

    private Integer code;

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    public static <T> ResponseBean<T> success(T object) {
        ResponseBean<T> responseBean = new ResponseBean<T>();
        responseBean.msg = "操作成功";
        responseBean.data = object;
        responseBean.code = 200;
        return responseBean;
    }

    public static <T> ResponseBean<T> error(String msg) {
        ResponseBean<T> responseBean = new ResponseBean<>();
        responseBean.msg = msg;
        responseBean.code = 400;
        return responseBean;
    }
    public static <T> ResponseBean<T> error() {
        ResponseBean<T> responseBean = new ResponseBean<>();
        responseBean.msg = "操作失败";
        responseBean.code = 400;
        return responseBean;
    }

    public ResponseBean<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
