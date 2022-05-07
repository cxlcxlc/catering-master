package com.cxl.entity;

import com.cxl.utils.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单明细
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDetail extends BaseEntity<OrderDetail> implements Serializable {

    private static final long serialVersionUID = 1L;

    //名称
    private String name;

    //订单id
    private Long orderId;


    //菜品id
    private Long dishId;


    //套餐id
    private Long setMealId;


    //口味
    private String dishFlavor;


    //数量
    private Integer number;

    //金额
    private BigDecimal amount;

    //图片
    private String image;
}
