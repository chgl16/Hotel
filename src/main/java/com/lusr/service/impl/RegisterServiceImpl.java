package com.lusr.service.impl;

import com.lusr.entity.TbManagerEntity;
import com.lusr.dao.ITbManagerDao;
import com.lusr.dao.impl.TbManagerDaoImpl;
import com.lusr.service.IRegisterService;

/**
 * Created by ownlove on 2018/12/21.
 */
public class RegisterServiceImpl implements IRegisterService{

    @Override
    public void login(TbManagerEntity tbManagerEntity) {
        ITbManagerDao tbManagerDao = new TbManagerDaoImpl();

    }

    @Override
    public void changeMassage() {

    }
}
