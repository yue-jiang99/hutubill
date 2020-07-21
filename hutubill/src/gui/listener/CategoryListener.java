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
        JButton button = new JButton();
        if (button == p.bAdd){
            String name = JOptionPane.showInputDialog(null);
            if (0 == name.length()){
                JOptionPane.showMessageDialog(p,"分类名不能为空");
                return;
            }
            new Categoryservice().add(name);
        }

        if(button == p.bEidt){
            //获取被选中的消费类别
            Category c = p.getSelectCategory();
            /*********************/
            String name = JOptionPane.showInputDialog("修改分类名称",c.getName());
            if(0 == name.length()){
                JOptionPane.showMessageDialog(p, "分类名称不能为空");
                return;
            }
            new Categoryservice().update(c.getId(), name);
        }

        if (button == p.bDelete){
            Category c = p.getSelectCategory();
            if (0 != c.getRecordNumber()){
                JOptionPane.showMessageDialog(p,"该消费记录不可以删除");
                return;
            }
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p,"确认要删除")){
                return;
            }
            new Categoryservice().delete(c.getId());
        }
        p.updateDate();
    }
}
