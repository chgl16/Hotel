package com.lusr.dao.impl;

import com.lusr.dao.VisitorDao;
import com.lusr.entity.Room;
import com.lusr.entity.Transaction;
import com.lusr.util.EMUtil;

import javax.persistence.EntityManager;

public class VisitorDaoImpl implements VisitorDao {
    private EntityManager em = EMUtil.getEM();

    @Override
    public void insertTransaction(Transaction transaction) {
        em.getTransaction().begin();
        em.persist(transaction);
        // 更新room的状态(只能通过id更新)
        Room r = em.find(Room.class, transaction.getRoom_id());
        r.setStatus(1);
        em.getTransaction().commit();
    }
}
