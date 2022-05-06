package com.cxl.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface BaseService<T extends BaseEntity<T>> extends IService<T> {

    Page<T> listPage(T entity, int pageNum, int pageSize);

    List<T> list(T entity);

}
