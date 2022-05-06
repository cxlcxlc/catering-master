package com.cxl.utils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseEntity<T extends Model<?>> extends Model<T> implements Serializable {

    /**
     * 实体编号（唯一标识）
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    protected Long id;

}

