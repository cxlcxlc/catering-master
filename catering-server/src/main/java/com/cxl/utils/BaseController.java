package com.cxl.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<S extends BaseService<T>, T extends BaseEntity<T>> {

    @Autowired
    protected S service;

    protected Logger LOG = LoggerFactory.getLogger(this.getClass());


    protected Class<T> entityClass;

    public BaseController() {
        this.entityClass = GenericUtil.getSuperGenericClass2(this.getClass());
    }

    @GetMapping("/{id}")
    public T edit(@PathVariable Long id) throws Exception {
        T entity = service.getById(id);
        afterEdit(entity);
        return entity;
    }

    @RequestMapping("/page")
    public Page<T> listPage(T entity, @RequestParam(name = "page", defaultValue = "1", required = false) int page, @RequestParam(name = "pageSize", defaultValue = "10", required = false) int rows) {
        return service.listPage(entity, page, rows);
    }


    @GetMapping
    public List<T> list(T entity) {
        return service.list(entity);
    }

    @PutMapping
    public ResponseBean<T> update(@RequestBody T entity) {
        return this.save(entity);
    }


    @PostMapping
    public ResponseBean<T> save(@RequestBody T entity) {
        ResponseBean<T> rm = new ResponseBean<>();
        try {
            beforeSave(entity); //保存前处理实体类
            service.saveOrUpdate(entity);
            rm.setData(entity);
        } catch (Exception e) {
            e.printStackTrace();
            rm.setMsg("保存失败");
        }
        return rm;
    }


    @DeleteMapping("/{id}")
    public ResponseBean<String> delete(@PathVariable Long id) {
        ResponseBean<String> rm = new ResponseBean<>();
        try {
            service.removeById(id);
        } catch (Exception e) {
            e.printStackTrace();
            rm.setMsg("保存失败");
        }
        return rm;
    }


    @RequestMapping(value = "/delete")
    public ResponseBean<String> delete(List<Long> ids) {
        ResponseBean<String> rm = new ResponseBean<>();
        try {
            service.removeByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
            rm.setMsg("删除失败");
        }
        return rm;
    }


    public void beforeSave(T entity) {

    }


    public void afterEdit(T entity) {

    }

}
