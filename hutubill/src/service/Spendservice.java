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
        //��������
        List<Record> thisMonthRecord = dao.getThisMonthRecord();
        //��������
        List<Record> today = dao.getToDayRecord();
        //����������
        int thisMonthTotalday = DateUtil.thisMouthTotalDay();
        int monthSpend = 0;
        int todaySpend = 0;
        int avgSpendPerDay = 0;
        int monthAvailable = 0;
        int dayAvgAvailable = 0;
        int monthLeftDay = 0;
        int usagePercentage = 0;

        // Ԥ��
        int monthBudget = new Configservice().getIntBudget();

        // ͳ�Ʊ�������
        for (Record record : thisMonthRecord) {
            monthSpend += record.getSpend();
        }

        // ͳ�ƽ�������
        for (Record record : today) {
            todaySpend += record.getSpend();
        }
        // �����վ�����
        avgSpendPerDay = monthSpend / thisMonthTotalday;
        // ���㱾��ʣ��
        monthAvailable = monthBudget - monthSpend;

        // ������ĩ
        monthLeftDay = DateUtil.thisMouthLastDay();

        // �����վ�����
        dayAvgAvailable = monthAvailable / monthLeftDay;

        // ����ʹ�ñ���
        usagePercentage = monthSpend * 100 / monthBudget;

        // ������Щ��Ϣ������SpendPage����

        return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay,
                usagePercentage);

    }
}
