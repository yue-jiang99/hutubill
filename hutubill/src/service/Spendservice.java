package service;

import dao.RecordDAO;
import entity.Record;
import gui.page.SpendPage;
import gui.panel.SpendPanel;
import util.DateUtil;

import java.util.List;

public class Spendservice {
    public SpendPage getSpendPage(){
        RecordDAO dao = new RecordDAO();
        //本月数据
        List<Record> thisMonthRecord = dao.getThisMonthRecord();
        //今日数据
        List<Record> today = dao.getToDayRecord();
        //本月总天数
        int thisMonthTotalday = DateUtil.thisMouthTotalDay();
        int monthSpend = 0;
        int todaySpend = 0;
        int avgSpendPerDay = 0;
        int monthAvailable = 0;
        int dayAvgAvailable = 0;
        int monthLeftDay = 0;
        int usagePercentage = 0;

        // 预算
        int monthBudget = new Configservice().getIntBudget();

        // 统计本月消费
        for (Record record : thisMonthRecord) {
            monthSpend += record.getSpend();
        }

        // 统计今日消费
        for (Record record : today) {
            todaySpend += record.getSpend();
        }
        // 计算日均消费
        avgSpendPerDay = monthSpend / thisMonthTotalday;
        // 计算本月剩余
        monthAvailable = monthBudget - monthSpend;

        // 距离月末
        monthLeftDay = DateUtil.thisMouthLastDay();

        // 计算日均可用
        dayAvgAvailable = monthAvailable / monthLeftDay;

        // 计算使用比例
        usagePercentage = monthSpend * 100 / monthBudget;

        // 根据这些信息，生成SpendPage对象

        return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay,
                usagePercentage);

    }
}
