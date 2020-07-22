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
    public JButton bSpend = new JButton("����һ��");
    public JButton bRecord = new JButton("��һ��");
    public JButton bCategory = new JButton("���ѷ���");
    public JButton bReport = new JButton("�����ѱ���");
    public JButton bConfig = new JButton("����");
    public JButton bBackup = new JButton("����");
    public JButton bRecover = new JButton("�ָ�");

    public CenterPanel workingPanel;

    private MainPanel(){
        GUIUtil.setImageIcon(bSpend,"home.png","����һ��");
        GUIUtil.setImageIcon(bRecord,"record.png","��һ��");
        GUIUtil.setImageIcon(bCategory,"category2.png","���ѷ���");
        GUIUtil.setImageIcon(bReport,"report.png","�����ѱ���");
        GUIUtil.setImageIcon(bConfig,"config.png","����");
        GUIUtil.setImageIcon(bBackup,"backup.png","����");
        GUIUtil.setImageIcon(bRecover,"record.png","�ָ�");

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
