package com.cxl.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxl.dto.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
public abstract class BaseController<S extends BaseService<T>, T extends BaseEntity<T>> {

    @Autowired
    protected S service;

    protected Logger LOG = LoggerFactory.getLogger(this.getClass());


    protected Class<T> entityClass;

    public BaseController() {
        this.entityClass = GenericUtil.getSuperGenericClass2(this.getClass());
    }

    @GetMapping("/{id}")
    public ResponseBean<T> edit(@PathVariable Long id) {
        T entity = service.getById(id);
        afterEdit(entity);
        return ResponseBean.success(entity);
    }

    @RequestMapping("/page")
    public ResponseBean<Page<T>> listPage(@RequestBody(required = false) T entity, @RequestParam(name = "page", defaultValue = "1", required = false) int page, @RequestParam(name = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return ResponseBean.success(service.listPage(entity, page, pageSize));
    }


    @GetMapping
    public ResponseBean<List<T>> list(T entity) {
        return ResponseBean.success(service.list(entity));
    }

    @PutMapping
    public ResponseBean<T> update(@RequestBody T entity) {
        if (entity == null || entity.getId() == null) return ResponseBean.error();
        if (service.updateById(entity)) {
            return ResponseBean.success(entity);
        }
        return ResponseBean.error();
    }


    @PostMapping
    public ResponseBean<T> save(@RequestBody T entity) {
        beforeSave(entity);
        if (service.save(entity)) {
            return ResponseBean.success(entity);
        }
        return ResponseBean.error();
    }


    @DeleteMapping("/{id}")
    public ResponseBean<String> delete(@PathVariable Long id) {
        if (!service.removeById(id)) {
            ResponseBean.error();
        }
        return ResponseBean.success(null);
    }


    @RequestMapping(value = "/delete")
    public ResponseBean<String> delete(@RequestBody List<Long> ids) {
        if (!service.removeByIds(ids)) {
            ResponseBean.error();
        }
        return ResponseBean.success(null);
    }


    public void beforeSave(T entity) {

    }


    public void afterEdit(T entity) {

    }

}
