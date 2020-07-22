package gui.listener;

import entity.Category;
import entity.Record;
import gui.panel.CategroyPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import service.Recordservice;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class RecordListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        RecordPanel rp = RecordPanel.instance;

        if (0 == rp.cbModel.getSize()){
            JOptionPane.showMessageDialog(rp,"���޴������Ϣ,�����");
            MainPanel.instance.workingPanel.show(CategroyPanel.instance);
            return;
        }
        if (!GUIUtil.checkZore(rp.tfSpend,"���ѽ��")){
            JOptionPane.showMessageDialog(rp,"��������ȷ�Ľ��");
            return;
        }
        //��ȡ���ѽ��
        int spend = Integer.parseInt(rp.tfSpend.getText());
        //��ȡ�������
        Category c = (Category) rp.cbCategory.getSelectedItem();

        String commment = rp.tfComment.getText();

        Date date = rp.datePicker.getDate();

        new Recordservice().add(spend,c,commment,date);

        MainPanel.instance.workingPanel.show(SpendPanel.instance);
    }
}
