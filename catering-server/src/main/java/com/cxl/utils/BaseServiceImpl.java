package com.cxl.utils;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

public abstract class BaseServiceImpl<M extends BaseDao<T>,T extends BaseEntity<T>> extends ServiceImpl<M, T> implements BaseService<T> {


    @Override
    public Page<T> listPage(T entity, int pageNum, int pageSize) {
        return baseMapper.selectPage(new Page<>(pageNum, pageSize), Wrappers.emptyWrapper());
    }


    @Override
    public List<T> list(T entity) {
        return getBaseMapper().selectList(Wrappers.emptyWrapper());
    }

}
