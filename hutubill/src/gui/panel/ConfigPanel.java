package gui.panel;

import gui.listener.ConfigListener;
import service.Configservice;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends WorkingPanel{
    static {
        GUIUtil.useLNF();
    }
    public static ConfigPanel instance = new ConfigPanel();

    JLabel lBudget = new JLabel("����Ԥ�㣤");
    public JTextField tfBudget = new JTextField("0");
    JLabel lMysql = new JLabel("MySQL��װĿ¼");
    public JTextField tfMysql = new JTextField("");

    JButton bUpdate = new JButton("����");


    public ConfigPanel() {
        GUIUtil.setColor(ColorUtil.grayColor,lBudget,lMysql);
        GUIUtil.setColor(ColorUtil.blueColor,bUpdate);

        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 40;
        pInput.setLayout(new GridLayout(4,1,gap,gap));

        pInput.add(lBudget);
        pInput.add(tfBudget);
        pInput.add(lMysql);
        pInput.add(tfMysql);

        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);

        pSubmit.add(bUpdate);

        this.add(pSubmit,BorderLayout.CENTER);

        addListener();
    }

    @Override
    public void updateDate() {
        Configservice cs = new Configservice();
        //�����ݿ��л�ȡ������Ϣ
        String budget = cs.getValueByKey(Configservice.budget);
        String mysqlPath = cs.getValueByKey(Configservice.mysqlPath);
        //��������Ϣ��ʾ�ڽ���
        tfBudget.setText(budget);
        tfMysql.setText(mysqlPath);

        //������ȡ����
        tfBudget.grabFocus();

    }
    @Override
    public void addListener(){
        ConfigListener c = new ConfigListener();
        bUpdate.addActionListener(c);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ConfigPanel.instance);
    }
}
