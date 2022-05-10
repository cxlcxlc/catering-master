package com.cxl.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.cxl.utils.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
菜品口味
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DishFlavor extends BaseEntity<DishFlavor> implements Serializable {

    private static final long serialVersionUID = 1L;

    //菜品id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long dishId;

    //口味名称
    private String name;


    //口味数据list
    private String value;


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
