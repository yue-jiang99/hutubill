package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ʱ�乤����
 */
public class DateUtil {
    static long MILLISECONDSOFONEDAY = 1000*60*60*24;
    public static java.sql.Date util2sql(java.util.Date d){
        return new java.sql.Date(d.getTime());
    }

    /**
     * ��ȡ����,����ʱ���붼��Ϊ��
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
     * ��ȡ�³�
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
     * ��ȡ��ĩ
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
     * ������ж�����
     * @return
     */
    public static int thisMouthTotalDay(){
        long lastDay =monthLast().getTime();
        long firstDay = monthBegin().getTime();
        return (int)((lastDay-firstDay)/MILLISECONDSOFONEDAY) +1;
    }

    /**
     * ����»�ʣ������
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
