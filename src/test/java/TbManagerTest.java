import com.lusr.entity.TbManagerEntity;
import com.lusr.dao.ITbManagerDao;
import com.lusr.dao.impl.TbManagerDaoImpl;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.persistence.EntityManager;

/**
 * Created by ownlove on 2018/12/20.
 */
public class TbManagerTest {

    private static final Logger log = LoggerFactory.getLogger(TbManagerTest.class);

    EntityManager em;
    ITbManagerDao tbManagerDao = new TbManagerDaoImpl();

    @Test
    public void insert(){
        TbManagerEntity tbManagerEntity = new TbManagerEntity();
        tbManagerEntity.setShadow("sfaaffaisfafq");
        tbManagerEntity.setName("恍然大悟uq");
        tbManagerEntity.setUk_phone("135158687");
        tbManagerEntity.setUk_identity("550144576886559865");
//        JPAUtil.save(tbManagerEntity);
        tbManagerDao.save(tbManagerEntity);

    }

    @Test
    public void delete(){
//        TbManagerEntity tbManagerEntity = (TbManagerEntity) tbManagerDao.find(TbManagerEntity.class,6);
        tbManagerDao.delete(TbManagerEntity.class,4);
    }
    @Test
    public void update(){
        log.info("adffdasafds");
    }

    @Test
    public void query(){

    }
}
