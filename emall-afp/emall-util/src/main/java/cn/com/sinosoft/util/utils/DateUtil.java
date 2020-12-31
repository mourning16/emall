package cn.com.sinosoft.util.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2020/12/30 18:53
 * @Version 1.0
 */

public class DateUtil {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String dateToStr(Date date){

        String str = simpleDateFormat.format(date);
        reentrantLock.lock();

        try {
            simpleDateFormat.format(date);
        }finally {
            reentrantLock.unlock();
        }
        return  str;
    }

    public static String test(Date date){
        return simpleDateFormat.format(date);
    }

}

