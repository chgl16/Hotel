package com.lusr.dao;

import com.lusr.entity.Member;

/**
 * 会员的一些数据访问
 *
 * @author chgl16
 * @date 2018-12-24 19:31
 * @version 1.0
 */

public interface MemberDao {
    /**
     * 通过电话（唯一约束）查询用户信息
     *
     * @param phone
     * @return
     */
    public Member findMemberByPhone(String phone);


    /**
     * 注册一个会员
     *
     * @param member
     */
    public void insertMember(Member member);
}
