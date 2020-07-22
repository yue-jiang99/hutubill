package gui.panel;

import gui.page.SpendPage;
import service.Spendservice;
import util.ChartUtil;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class SpendPanel extends WorkingPanel{
    //皮肤
    static {
        GUIUtil.useLNF();
    }
    public static SpendPanel instance = new SpendPanel();


    public JLabel lMouthSpend = new JLabel("本月消费");
    public JLabel lTodaySpend = new JLabel("今日消费");
    public JLabel lAvgSpendPerDay = new JLabel("日均消费");
    public JLabel lMouthLeft = new JLabel("本月剩余");
    public JLabel lDayAvgAvailable = new JLabel("日均可用");
    public JLabel lMouthLeftDay = new JLabel("距离月末");


    public JLabel vMouthSpend = new JLabel("123");
    public JLabel vTodaySpend = new JLabel("231");
    public JLabel vAvgSpendPerDay = new JLabel("312");
    public JLabel vMouthLeft = new JLabel("465");
    public JLabel vDayAvgAvailable = new JLabel("456");
    public JLabel vMouthLeftDay = new JLabel("789");

    CircleProgressBar bar;

    private SpendPanel(){
        //设置背景
        this.setLayout(new BorderLayout());
        //初始化○
        bar = new CircleProgressBar();
        //设置圆颜色
        bar.setBackgroundColor(ColorUtil.blueColor);
        //设置组件背景颜色
        GUIUtil.setColor(ColorUtil.grayColor,lAvgSpendPerDay,lDayAvgAvailable,lMouthLeft,lMouthLeftDay,lMouthSpend,
                                            lTodaySpend,vAvgSpendPerDay,vDayAvgAvailable,vMouthLeft,vMouthLeftDay);
        GUIUtil.setColor(ColorUtil.blueColor,vMouthSpend,vTodaySpend);
        //设置字体
        vMouthSpend.setFont(new Font("微软雅黑",Font.BOLD,40));
        vTodaySpend.setFont(new Font("微软雅黑",Font.BOLD,45));

        this.add(center(),BorderLayout.CENTER);
        this.add(south(),BorderLayout.SOUTH);
    }

    private JPanel south() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,4));
        p.add(lAvgSpendPerDay);
        p.add(lMouthLeft);
        p.add(lDayAvgAvailable);
        p.add(lMouthLeftDay);
        p.add(vAvgSpendPerDay);
        p.add(vMouthLeft);
        p.add(vDayAvgAvailable);
        p.add(vMouthLeftDay);
        return p;
    }

    private JPanel center() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(west(),BorderLayout.WEST);
        p.add(center2(),BorderLayout.CENTER);
        return p;
    }

    private Component center2() {
        return bar;
    }

    private Component west() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4,1));
        p.add(lMouthSpend);
        p.add(vMouthSpend);
        p.add(lTodaySpend);
        p.add(vTodaySpend);
        return  p;
    }

    @Override
    public void updateDate() {
        SpendPage spend = new Spendservice().getSpendPage();
        vMouthSpend.setText(spend.monthSpend);
        vTodaySpend.setText(spend.todaySpend);
        vAvgSpendPerDay.setText(spend.avgSpendPerDay);
        vMouthLeft.setText(spend.monthAvailable);
        vDayAvgAvailable.setText(spend.dayAvgAvailable);
        vMouthLeftDay.setText(spend.monthLeftDay);

        bar.setProgress(spend.usagePercentage);
        if (spend.isOverSpend) {
            vMouthLeft.setForeground(ColorUtil.warningColor);
            vMouthSpend.setForeground(ColorUtil.warningColor);
            vTodaySpend.setForeground(ColorUtil.warningColor);

        } else {
            vMouthLeft.setForeground(ColorUtil.grayColor);
            vMouthSpend.setForeground(ColorUtil.blueColor);
            vTodaySpend.setForeground(ColorUtil.blueColor);
        }
        bar.setForegroundColor(ColorUtil.getByPercentage(spend.usagePercentage));
        addListener();


    }

    @Override
    public void addListener() {

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(SpendPanel.instance);
    }
}
