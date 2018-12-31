package com.lusr.dao;

import com.lusr.entity.Transaction;

import java.util.List;

/**
 * 订单表的相关dao
 *
 * @author chgl16
 * @date 2018-12-31
 * @version 1.0
 */

public interface TransactionDao {

    /**
     * 创建订单
     *
     * @param transaction
     */
    public void insertTransaction(Transaction transaction);

    /**
     * 通过phone获取有效相关订单
     *
     * @param phone
     * @return
     */
    public List<Transaction> selectValidTransactionByPhone(String phone);

    /**
     * 通过phone获取所有相关订单
     *
     * @param phone
     * @return
     */
    public List<Transaction> selectAllTransactionByPhone(String phone);

    /**
     * 获取所有订单
     *
     * @return
     */
    public List<Transaction> selectAllTransaction();

    /**
     * 退订订单
     *
     * @param id
     */
    public void updateStatusZero(Integer id);
}
