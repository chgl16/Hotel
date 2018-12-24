import com.lusr.entity.TbMemberEntity;
import com.lusr.dao.impl.TbMemberDaoImpl;
import com.lusr.util.JPAUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by ownlove on 2018/12/19.
 */
public class TbMemberTest {

    @Test
    public void insert(){
        EntityManager em = JPAUtil.getManager();
    }

    @Test
    public void TbMemberEntityTest() throws Exception {
        EntityManager em = JPAUtil.getManager();
        TbMemberEntity tbMemberEntity = new TbMemberEntity();
        tbMemberEntity.setName("陆盛权f");
        tbMemberEntity.setUk_identity("458760888");
        tbMemberEntity.setUk_phone("13787");
        tbMemberEntity.setShadow("ssfa68fa");
        TbMemberDaoImpl tbMemberDao = new TbMemberDaoImpl();
//        tbMemberDao.insert(tbMemberEntity);
    }
    @Test
    public void select(){

        EntityManager em = JPAUtil.getManager();
        Query query = em.createQuery("select tb.uk_phone,tb.uk_identity,tb.name,tb.shadow from TbMemberEntity tb where tb.name=?1");
        query.setParameter(1,"陆盛权");
        List list =  query.getResultList();
        for (java.lang.Object tb:list
             ) {
            System.out.println(tb);
        }

    }
    @Test
    public void update(){
        EntityManager em = JPAUtil.getManager();
        TbMemberEntity tbMemberEntity = new TbMemberEntity();
        //第一步开启事务
        em.getTransaction().begin();
        //第二步，得到查询结果
        Query query = em.createQuery("update TbMemberEntity tb set tb.name='llll' where tb.name=?1");
        //第三步，设置参数
        query.setParameter(1,"lust");
        //第四步，执行更新
        query.executeUpdate();
        //第五步，提交事务
        em.getTransaction().commit();
    }
    @Test
    public void delete(){
        EntityManager em = JPAUtil.getManager();
        TbMemberEntity tbMemberEntity = new TbMemberEntity();
        //可以通过主键找到这个记录，再删除

        //第一步开启事务
        em.getTransaction().begin();
        //第二步，得到查询结果
        Query query = em.createQuery("delete from TbMemberEntity tb where tb.name=?1");
        //第三步，设置参数
        query.setParameter(1,"llll");
        //第四步，执行更新
        query.executeUpdate();
        //第五步，提交事务
        em.getTransaction().commit();
    }




}
