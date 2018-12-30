package com.lusr.service;

/**
 * 普通游客业务
 *
 * @author chgl16
 * @date 2018-12-30
 * @version 1.0
 */

public interface VisitorService {
    public void createBookTransaction(int room_id, int days, float money, String phone, String identity);
}
