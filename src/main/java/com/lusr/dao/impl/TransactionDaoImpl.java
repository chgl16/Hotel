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
        // 清除存储，到数据库取检索
        em.clear();
        Query query = em.createQuery("SELECT t FROM Transaction t WHERE t.status = 1 AND t.phone = ?1  ORDER BY t.id DESC");
        query.setParameter(1, new String(phone));
        List<Transaction> transactionList = query.getResultList();
        return transactionList;
    }

    @Override
    public List<Transaction> selectAllTransactionByPhone(String phone) {
        // 清除存储，到数据库取检索
        em.clear();
        Query query = em.createQuery("SELECT t FROM Transaction t WHERE  t.phone = ?1 ORDER BY t.id DESC");
        query.setParameter(1, new String(phone));
        List<Transaction> transactionList = query.getResultList();
        return transactionList;
    }

    @Override
    public List<Transaction> selectAllTransaction() {
        // 清除存储，到数据库取检索
        em.clear();
        Query query = em.createQuery("SELECT t FROM Transaction t  ORDER BY t.id DESC");
        List<Transaction> transactionList = query.getResultList();
        return transactionList;
    }

    @Override
    public void updateStatusZero(Integer id) {
        // 更新transaction的状态(只能通过id更新)
        em.getTransaction().begin();
        Transaction t = em.find(Transaction.class, id);
        t.setStatus(0);

        // 更新room的状态(只能通过id更新)
        Room r = em.find(Room.class, t.getRoom_id());
        r.setStatus(0);
        em.flush();
        em.getTransaction().commit();

        System.out.println("成功修改状态");
    }
}
