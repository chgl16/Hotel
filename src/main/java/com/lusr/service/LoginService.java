package com.lusr.service;

public interface LoginService {
    /**
     * 会员登录
     *
     * @param phone
     * @param password
     * @return "success" / "wrong-password" / "unregistered"
     */
    public String MemberLogin(String phone, String password);


}
