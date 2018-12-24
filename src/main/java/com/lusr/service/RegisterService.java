package com.lusr.service;

/**
 * 会员和员工注册业务
 *
 * @author chgl16
 * @date 2018-12-24 19:06
 * @version 1.0
 */

public interface RegisterService {
    /**
     * 会员注册
     *
     * @param phone
     * @param username
     * @param password
     * @return true-成功/false-失败
     */
    public boolean MemberRegister(String phone, String username, String password);
}
