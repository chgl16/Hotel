package com.lusr.dao;


import java.io.Serializable;
import java.util.List;

/**
 * 定义共有操作的接口
 * save:保存一个Entity
 * update:保存一个Entity
 * delete:删除一个T对象
 * Created by ownlove on 2018/12/20.
 */
public interface IBaseDao<T> {
    /**
     *
     * @param t 更新后的Entity
     */
    void save(T t);
    void update(T t);
    void delete(T t);
    void delete(Class clz, Serializable id);
    T find(Class clz, Serializable id);
    List<T> findAll(Class clz);
}
