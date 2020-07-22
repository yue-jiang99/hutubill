package gui.listener;

import entity.Category;
import gui.panel.CategroyPanel;
import service.Categoryservice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CategroyPanel p = CategroyPanel.instance;
        JButton button = (JButton) e.getSource();
        if (button == p.bAdd){
            String name = JOptionPane.showInputDialog(null);
            if (0 == name.length()){
                JOptionPane.showMessageDialog(p,"����������Ϊ��");
                return;
            }
            new Categoryservice().add(name);
        }

        if(button == p.bEidt){
            //��ȡ��ѡ�е��������
            Category c = p.getSelectCategory();
            /*********************/
            String name = JOptionPane.showInputDialog("�޸ķ�������",c.getName());
            if(0 == name.length()){
                JOptionPane.showMessageDialog(p, "�������Ʋ���Ϊ��");
                return;
            }
            new Categoryservice().update(c.getId(), name);
        }

        if (button == p.bDelete){
            Category c = p.getSelectCategory();
            if (0 != c.getRecordNumber()){
                JOptionPane.showMessageDialog(p,"�����Ѽ�¼������ɾ��");
                return;
            }
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p,"ȷ��Ҫɾ��")){
                return;
            }
            new Categoryservice().delete(c.getId());
        }
        p.updateDate();
    }
}
