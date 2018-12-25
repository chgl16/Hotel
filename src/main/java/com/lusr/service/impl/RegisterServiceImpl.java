package com.lusr.service.impl;

import com.lusr.dao.MemberDao;
import com.lusr.dao.impl.MemberDaoImpl;
import com.lusr.entity.Member;
import com.lusr.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 注册业务实现
 *
 * @author chgl16
 * @date 2018-12-24 19:09
 * @version 1.0
 */

public class RegisterServiceImpl implements RegisterService {
    private static final Logger log = LoggerFactory.getLogger(RegisterServiceImpl.class);
    private MemberDao memberDao = new MemberDaoImpl();

    @Override
    public boolean MemberRegister(Member member) {
        if (memberDao.findMemberByPhone(member.getPhone()) == null) {
            log.info("该手机号尚未注册，现在为其注册");
            memberDao.insertMember(member);
            return true;
        }
        log.info("用户已经注册");
        return false;
    }
}
