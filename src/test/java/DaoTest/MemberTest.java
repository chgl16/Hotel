package DaoTest;

import com.lusr.dao.MemberDao;
import com.lusr.dao.impl.MemberDaoImpl;
import com.lusr.entity.Member;
import org.junit.Test;

public class MemberTest {
    MemberDao memberDao = new MemberDaoImpl();

    @Test
    public void testFind() {
        Member member = memberDao.findMemberByPhone("456");
        System.out.println(member);
    }
}
