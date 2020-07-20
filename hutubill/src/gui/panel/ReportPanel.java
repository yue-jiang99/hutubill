package gui.panel;

import entity.Record;
import util.ChartUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel{
    static {
        GUIUtil.useLNF();
    }
    public static ReportPanel instance = new ReportPanel();
    JLabel l = new JLabel();

    public ReportPanel() {
        this.setLayout(new BorderLayout());
        ImageIcon i = new ImageIcon("home.png");
        l.setIcon(i);
        l.setBounds(50,50,i.getIconWidth(),i.getIconHeight());
        this.add(l);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ReportPanel.instance);
    }
}
