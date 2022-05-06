package com.cxl.utils;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface BaseDao<T extends BaseEntity<T>> extends BaseMapper<T> {

}
