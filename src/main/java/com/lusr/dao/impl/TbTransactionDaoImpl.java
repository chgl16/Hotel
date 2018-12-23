package com.lusr.dao.impl;

import com.lusr.dao.ITbTransactionDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ownlove on 2018/12/20.
 */
public class TbTransactionDaoImpl extends BaseDaoImpl implements ITbTransactionDao{
    @Override
    public void a() {

    }

    @Override
    public void save(Object o) {
        this.save(o);
    }

    @Override
    public void update(Object o) {
        this.update(o);
    }

    @Override
    public void delete(Object o) {
        this.delete(o);
    }

    @Override
    public void delete(Class clz, Serializable id) {
        this.delete(clz,id);
    }

    @Override
    public Object find(Class clz, Serializable id) {
        return this.find(clz,id);
    }

    @Override
    public List findAll(Class clz) {
        return this.findAll(clz);
    }
}
