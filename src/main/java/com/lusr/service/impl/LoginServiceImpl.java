package com.lusr.service.impl;

import com.lusr.dao.MemberDao;
import com.lusr.dao.impl.MemberDaoImpl;
import com.lusr.entity.Member;
import com.lusr.service.LoginService;
import com.lusr.util.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginServiceImpl implements LoginService {
    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    private MemberDao memberDao = new MemberDaoImpl();

    @Override
    public String MemberLogin(String phone, String password) {
        Member member = memberDao.findMemberByPhone(phone);
        if (member != null) {
            log.info("用户已经注册");
            // 注意BCrypt的密码是不固定的，多对多，需要用其实现的算法判断是否匹配
            if (BCrypt.checkpw(password, member.getPassword())) {
                log.info("密码正确");
                return "success";
            } else {
                log.info("密码错误");
                return "wrong-password";
            }
        }
        return "unregistered";
    }
}
