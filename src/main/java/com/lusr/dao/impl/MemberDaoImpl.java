package com.lusr.dao.impl;

import com.lusr.dao.MemberDao;
import com.lusr.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * 会员dao实现
 *
 * @author chgl16
 * @date 2018-12-24 19:44
 * @version 1.0
 */

public class MemberDaoImpl implements MemberDao {
    private static final EntityManager em = Persistence.createEntityManagerFactory("hotel").createEntityManager();

    @Override
    public Member findMemberByPhone(String phone) {
        // JPQL不同SQL，需要位置号，需要别名，等等(IDEA这里别开语法检测，不能识别会报错)
        Query query = em.createQuery("SELECT c FROM Member c WHERE c.phone = ?1");
        query.setParameter(1, phone);
        List<Member> members = query.getResultList();
        return members.size() == 0 ? null : members.get(0);
    }

    @Override
    public void insertMember(Member member) {
        em.getTransaction().begin();
        em.persist(member);
        em.getTransaction().commit();
        // 固定了一个数据库连接，就不关了
//        em.close();
    }
}
