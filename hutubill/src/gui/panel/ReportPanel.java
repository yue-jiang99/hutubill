package gui.panel;

import entity.Record;
import service.Reportservice;
import util.ChartUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ReportPanel extends WorkingPanel{
    static {
        GUIUtil.useLNF();
    }
    public static ReportPanel instance = new ReportPanel();
    JLabel l = new JLabel();

    public ReportPanel() {
        this.setLayout(new BorderLayout());
        List<Record> rs = new Reportservice().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 400, 300);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
        this.add(l);
        addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ReportPanel.instance);
    }

    @Override
    public void updateDate() {
        List<Record> rs = new Reportservice().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 350, 250);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);

    }

    @Override
    public void addListener() {

    }
}
