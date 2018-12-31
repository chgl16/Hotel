package com.lusr.dao.impl;

import com.lusr.dao.TransactionDao;
import com.lusr.entity.Room;
import com.lusr.entity.Transaction;
import com.lusr.util.EMUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
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

    @Override
    public List<Transaction> selectValidTransactionByPhone(String phone) {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT t FROM Transaction t WHERE t.status = 1 AND t.phone = ?1");
        query.setParameter(1, new String(phone));
        return query.getResultList();
    }

    @Override
    public List<Transaction> selectAllTransactionByPhone(String phone) {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT t FROM Transaction t WHERE  t.phone = ?1");
        query.setParameter(1, new String(phone));
        return query.getResultList();
    }

    @Override
    public void updateStatusZero(Integer id) {
        // 更新transaction的状态(只能通过id更新)
        em.getTransaction().begin();
        Transaction t = em.find(Transaction.class, id);
        t.setStatus(0);
        em.getTransaction().commit();
        System.out.println("成功修改状态");
    }
}
