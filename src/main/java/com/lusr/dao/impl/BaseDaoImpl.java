package com.lusr.dao.impl;

import com.lusr.util.JPAUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 公共操作的实现类
 * Created by ownlove on 2018/12/20.
 */
public class BaseDaoImpl{

    public void BaseSave(Object o) {
        JPAUtil.save(o);
    }

    public void BaseUpdate(Object o) {
        JPAUtil.update(o);
    }

    public void BaseDelete(Object t) {
        JPAUtil.delete(t);
    }

    public void BaseDelete(Class clz,Serializable id) {
        JPAUtil.delete(clz,id);
    }

    public Object BaseFind(Class clz, Serializable id) {
        return JPAUtil.find(clz,id);
    }

    public List BaseFindAll(Class clz) {
        return JPAUtil.findAll(clz);
    }


}
