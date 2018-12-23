package com.lusr.dao.impl;

import com.lusr.entity.TbManagerEntity;
import com.lusr.dao.ITbManagerDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ownlove on 2018/12/20.
 */
public class TbManagerDaoImpl extends BaseDaoImpl implements ITbManagerDao<TbManagerEntity>{
    /**
     * 特有操作
     */

    /**
     * 共有操作
     * @param tbManagerEntity
     */
    @Override
    public void save(TbManagerEntity tbManagerEntity) {
        this.BaseSave(tbManagerEntity);
    }

    @Override
    public void update(TbManagerEntity tbManagerEntity) {
        this.BaseUpdate(tbManagerEntity);
    }

    @Override
    public void delete(TbManagerEntity tbManagerEntity) {
        this.BaseDelete(tbManagerEntity);
    }

    @Override
    public void delete(Class clz, Serializable id) {
        this.BaseDelete(clz,id);
    }

    @Override
    public TbManagerEntity find(Class clz, Serializable id) {
        return (TbManagerEntity) this.BaseFind(clz,id);
    }

    @Override
    public List<TbManagerEntity> findAll(Class clz) {
        return this.BaseFindAll(clz);
    }

}
