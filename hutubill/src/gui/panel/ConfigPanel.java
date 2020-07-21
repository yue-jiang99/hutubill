package gui.panel;

import gui.listener.ConfigListener;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel{
    static {
        GUIUtil.useLNF();
    }
    public static ConfigPanel instance = new ConfigPanel();

    JLabel lBudget = new JLabel("本月预算￥");
    public JTextField tfBudget = new JTextField("0");
    JLabel lMysql = new JLabel("MySQL安装目录");
    public JTextField tfMysql = new JTextField("");

    JButton bUpdate = new JButton("更新");


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
    public void addListener(){
        ConfigListener c = new ConfigListener();
        bUpdate.addActionListener(c);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ConfigPanel.instance);
    }
}
