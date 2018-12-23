package com.lusr.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ownlove on 2018/12/20.
 */
public class TimeUtil {

    private static final DateFormat FORMAT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 将日期类型转换为formatDate
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        return FORMAT.format(date);
    }

    /**
     * 将字符串类型的日期转换为日期格式
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static Date parse(String dateString) throws ParseException {
        return FORMAT.parse(dateString);
    }


    /**
     * 时间戳转特定格式时间
     * @param timeStamp
     * @return
     */
    public static  String ToFormatTime(long timeStamp) {
        if (timeStamp == 0) {
            return "";
        }
        timeStamp = timeStamp * 1000;
        return FORMAT.format(new Date(timeStamp));
    }

    /**
     * 日期格式字符串转换成时间戳
     * @param date_str 字符串日期
     * @return
     */
    public static  long formateTimeToStamp(String date_str){
        try {
            return FORMAT.parse(date_str).getTime()/1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取当前时间的时间戳对应的TimeStamp格式的时间
     * @return
     */
    public static Timestamp getTimeStampNow(){
        return new Timestamp(timeStamp()*1000);
    }

    /**
     * 取得当前时间戳（精确到秒）
     * @return
     */
    public static  Long timeStamp(){
        long time = System.currentTimeMillis();
        return time/1000;
    }
}
