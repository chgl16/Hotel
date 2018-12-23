
import com.lusr.entity.TbTransactionEntity;
import com.lusr.util.JPAUtil;
import com.lusr.util.TimeUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

/**
 * Created by ownlove on 2018/12/20.
 */
public class TbTrasactionTest {

    EntityManager em;
    @Test
    public void insert(){
        TbTransactionEntity tbTransactionEntity = new TbTransactionEntity();
        tbTransactionEntity.setStart_time(TimeUtil.getTimeStampNow());
        tbTransactionEntity.setStatu(0);
        tbTransactionEntity.setDays(1);
        tbTransactionEntity.setTransaction_id(TimeUtil.timeStamp().toString().substring(4));
        tbTransactionEntity.setTime(TimeUtil.getTimeStampNow());//时间
        tbTransactionEntity.setRoom_id(504);
        tbTransactionEntity.setPhone("1375565464");
        tbTransactionEntity.setMoney(new BigDecimal(100.9));
        tbTransactionEntity.setEnd_time(TimeUtil.getTimeStampNow());
        tbTransactionEntity.setIdentity("15435353");
        tbTransactionEntity.setMember_id(1143);
        JPAUtil.save(tbTransactionEntity);
    }

    @Test
    public void delete(){

    }
    @Test
    public void update(){

    }

}
