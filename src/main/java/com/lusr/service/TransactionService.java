package com.lusr.service;

import com.lusr.entity.Transaction;

import java.util.List;

/**
 * 交易业务
 *
 * @author chgl16
 * @date 2018-12-31
 * @version 1.0
 */

public interface TransactionService {
    /**
     * 创建订单
     *
     * @param room_id
     * @param days
     * @param money
     * @param phone
     * @param identity
     */
    public void createBookTransaction(int room_id, int days, float money, String phone, String identity);

    /**
     * 通过phone获取订单
     *
     * @param phone
     * @return
     */
    public List<Transaction> getAllTransactionByPhone(String phone);

    /**
     * 通过phone获取有效订单
     *
     * @param phone
     * @return
     */
    public List<Transaction> getValidTransactionByPhone(String phone);

    /**
     * 获取所有订单
     *
     * @return
     */
    public List<Transaction> getAllTransaction();

    /**
     * 更新订单状态为失效
     *
     * @param id
     */
    public void updateStatusZero(Integer id);
}
