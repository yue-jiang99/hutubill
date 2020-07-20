package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtil {
    static long MILLISECONDSOFONEDAY = 1000*60*60*24;
    public static java.sql.Date util2sql(java.util.Date d){
        return new java.sql.Date(d.getTime());
    }

    /**
     * 获取今天,并把时分秒都置为零
     * @return
     */
    public static Date today(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        return c.getTime();
    }

    /**
     * 获取月初
     * @return
     */
    public static Date monthBegin(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DATE,1);
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);
        return c.getTime();
    }

    /**
     * 获取月末
     * @return
     */
    public static Date monthLast(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);

        c.set(Calendar.DATE,1);
        c.add(Calendar.MONDAY,1);
        c.add(Calendar.DATE,-1);
        return c.getTime();
    }

    /**
     * 这个月有多少天
     * @return
     */
    public static int thisMouthTotalDay(){
        long lastDay =monthLast().getTime();
        long firstDay = monthBegin().getTime();
        return (int)((lastDay-firstDay)/MILLISECONDSOFONEDAY) +1;
    }

    /**
     * 这个月还剩多少天
     * @return
     */
    public static int thisMouthLastDay(){
        long lastDay = monthLast().getTime();
        long today = today().getTime();
        return (int)((lastDay-today)/MILLISECONDSOFONEDAY) +1 ;
    }

    public static void main(String[] args) {

        System.out.println(DateUtil.today());
        System.out.println(DateUtil.monthBegin());
        System.out.println(DateUtil.monthLast());
        System.out.println(DateUtil.thisMouthTotalDay());
        System.out.println(DateUtil.thisMouthLastDay());
    }
}
