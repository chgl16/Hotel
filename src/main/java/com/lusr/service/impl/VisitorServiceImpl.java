package com.lusr.service.impl;

import com.lusr.dao.VisitorDao;
import com.lusr.dao.impl.VisitorDaoImpl;
import com.lusr.entity.Transaction;
import com.lusr.service.VisitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VisitorServiceImpl implements VisitorService {
    private static final Logger log = LoggerFactory.getLogger(VisitorServiceImpl.class);
    private VisitorDao visitorDao = new VisitorDaoImpl();


    @Override
    public void createBookTransaction(int room_id, int days, float money, String phone, String identity) {
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String series = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date());
        // 获取后days的时间
        Calendar nextDays = Calendar.getInstance();
        nextDays.add(Calendar.DAY_OF_YEAR, days);
        String after = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nextDays.getTime());
        log.info("后" + days + "天的到期时间是：" + after);

        Transaction transaction = new Transaction();
        transaction.setTime(now);
        transaction.setStart_time(now);
        transaction.setTransaction_id(series);
        transaction.setEnd_time(after);
        transaction.setStatus(1);
        transaction.setRoom_id(room_id);
        transaction.setDays(days);
        transaction.setMoney(money);
        transaction.setPhone(phone);
        transaction.setIdentity(identity);

        visitorDao.insertTransaction(transaction);
    }
}
