package gui.panel;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }
    public static MainPanel instance = new MainPanel();
    public JToolBar tb = new JToolBar();
    public JButton bSpend = new JButton("消费一览");
    public JButton bRecord = new JButton("记一笔");
    public JButton bCategory = new JButton("消费分类");
    public JButton bReport = new JButton("月消费报表");
    public JButton bConfig = new JButton("设置");
    public JButton bBackup = new JButton("备份");
    public JButton bRecover = new JButton("恢复");

    public CenterPanel workingPanel;

    private MainPanel(){
        GUIUtil.setImageIcon(bSpend,"home.png","消费一览");
        GUIUtil.setImageIcon(bRecord,"record.png","记一笔");
        GUIUtil.setImageIcon(bCategory,"category2.png","消费分类");
        GUIUtil.setImageIcon(bReport,"report.png","月消费报表");
        GUIUtil.setImageIcon(bConfig,"config.png","设置");
        GUIUtil.setImageIcon(bBackup,"backup.png","备份");
        GUIUtil.setImageIcon(bRecover,"record.png","恢复");

        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);

        tb.setFloatable(false);

        workingPanel = new CenterPanel(0.8);
        setLayout(new BorderLayout());
        add(tb,BorderLayout.NORTH);
        add(workingPanel,BorderLayout.CENTER);

        ButtonListener();

    }

    public void ButtonListener(){
        ToolBarListener tbl  = new ToolBarListener();
        bBackup.addActionListener(tbl);
        bSpend.addActionListener(tbl);
        bCategory.addActionListener(tbl);
        bConfig.addActionListener(tbl);
        bRecord.addActionListener(tbl);
        bReport.addActionListener(tbl);
        bRecover.addActionListener(tbl);

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(MainPanel.instance,1);
    }

    @Override
    public void updateDate() {

    }

    @Override
    public void addListener() {

    }
}
