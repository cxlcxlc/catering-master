package com.cxl.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.cxl.utils.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 菜品
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Dish extends BaseEntity<Dish> implements Serializable {

    private static final long serialVersionUID = 1L;

    //菜品名称
    private String name;


    //菜品分类id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long categoryId;


    //菜品价格
    private BigDecimal price;


    //商品码
    private String code;


    //图片
    private String image;


    //描述信息
    private String description;


    //0 停售 1 起售
    private Integer status;


    //顺序
    private Integer sort;

    @TableField(exist = false)
    private Category category;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    @TableField(fill = FieldFill.INSERT)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long createUser;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long updateUser;


    //是否删除
    @TableLogic(delval = "1")
    private Integer isDeleted;

}
