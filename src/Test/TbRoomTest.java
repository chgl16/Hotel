import com.lusr.entity.TbManagerEntity;
import com.lusr.entity.TbRoomEntity;
import com.lusr.dao.ITbManagerDao;
import com.lusr.dao.impl.TbManagerDaoImpl;
import com.lusr.util.JPAUtil;
import com.lusr.util.TimeUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ownlove on 2018/12/20.
 */
public class TbRoomTest {
    private int pk_id;
    private BigDecimal price;
    private String  type;
    private Integer statu;
    private Timestamp start_time;
    private Timestamp end_time;

    EntityManager em;
    @Test
    public void insert() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String year = "2010";
        String month = "06";
        String day = "02";

        String hour="16";
        String minute = "10";
        String second="38";

        String time = year +"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
        System.out.println(time);

        Date date = df.parse(time);

        System.out.println(date.toString());
//        Timestamp now = new Timestamp(System.currentTimeMillis());

        Timestamp now = TimeUtil.getTimeStampNow();

        TbRoomEntity tbRoomEntity = new TbRoomEntity();

        tbRoomEntity.setPrice(new BigDecimal(99.0));
        tbRoomEntity.setStatu(0);
        tbRoomEntity.setType("钟点");
        tbRoomEntity.setStart_time(now);
        tbRoomEntity.setEnd_time(now);
        tbRoomEntity.setPk_id(507);

        em = JPAUtil.getManager();
        em.getTransaction().begin();
        em.persist(tbRoomEntity);
        em.getTransaction().commit();
    }

    @Test
    public void delete(){
        em = JPAUtil.getManager();
        TbRoomEntity tbRoomEntity = em.find(TbRoomEntity.class,506);
        JPAUtil.delete(tbRoomEntity);
    }
    @Test
    public void update(){
        em = JPAUtil.getManager();
        TbRoomEntity tbRoomEntity = em.find(TbRoomEntity.class,504);
        tbRoomEntity.setPrice(new BigDecimal(14.0));
        JPAUtil.update(tbRoomEntity);
        /*
        em.getTransaction().begin();
//        em.merge(tbRoomEntity);
        em.flush();
        em.getTransaction().commit();
        */
    }
    @Test
    public void query(){
        em = JPAUtil.getManager();
        List<TbRoomEntity> list = null;

        String name = "TbRoomEntity";
        String sql = "select a from "+name+ " a";
        //只能全部查询出来
        Query query = em.createQuery(sql);

        list = (List<TbRoomEntity>) query.getResultList();

        for(int i=0;i<list.size();++i){
            System.out.println(list.get(i).getPrice());
        }

    }

    @Test
    public void up(){
        List<TbRoomEntity> list = JPAUtil.findAll(TbRoomEntity.class);
        for (int i=0;i<list.size();++i){
            System.out.println(list.get(i).getPrice());
        }
    }

    @Test
    public void find(){
        ITbManagerDao tbManagerDao = new TbManagerDaoImpl();
        TbManagerEntity tbMemberEntity = (TbManagerEntity) tbManagerDao.find(TbManagerEntity.class,1);
        System.out.println(tbMemberEntity.getName());
    }

}
