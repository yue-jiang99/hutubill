package service;

import dao.RecordDAO;
import entity.Record;
import util.DBUtil;
import util.DateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Reportservice {
    public int getDaySpend(Date date, List<Record> monthRawData){
        int daySpend = 0;
        for (Record record : monthRawData ){
            if (record.getDate().equals(date)){
                daySpend+=record.getSpend();
            }
        }
        return daySpend;
    }
    public List<Record> listThisMonthRecords(){
        RecordDAO dao = new RecordDAO();
        List<Record> monthRawData = dao.getThisMonthRecord();
        List<Record> result = new ArrayList<>();
        Date monthBegin = DateUtil.monthBegin();
        int monthTotalDay = DateUtil.thisMouthTotalDay();
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < monthTotalDay; i++) {
            Record r = new Record();
            c.setTime(monthBegin);
            c.add(Calendar.DATE,i);
            Date eachDayOfThisMonth= c.getTime();
            int daySpend = getDaySpend(eachDayOfThisMonth,monthRawData);
            r.setSpend(daySpend);
            result.add(r);
        }
        return result;
    }
}
