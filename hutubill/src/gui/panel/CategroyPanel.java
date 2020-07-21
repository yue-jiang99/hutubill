package gui.panel;

import entity.Category;
import gui.listener.CategoryListener;
import gui.model.CategoryTableModel;
import service.Categoryservice;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class CategroyPanel extends WorkingPanel{
    static {
        GUIUtil.useLNF();
    }
    public static CategroyPanel instance = new CategroyPanel();

    public JButton bAdd = new JButton("����");
    public JButton bEidt = new JButton("�༭");
    public JButton bDelete = new JButton("ɾ��");
    String colunmNames[] = new String[]{"��������","���Ѵ���"};

    public CategoryTableModel ctm = new CategoryTableModel();
    public JTable t = new JTable();

    private CategroyPanel(){

        GUIUtil.setColor(ColorUtil.blueColor);

        JScrollPane sp = new JScrollPane(t);
        JPanel pSubmit = new JPanel();

        pSubmit.add(bAdd);
        pSubmit.add(bEidt);
        pSubmit.add(bDelete);

        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);

        addListener();
    }
    public Category getSelectCategory(){
        int index = t.getSelectedRow();
        return ctm.cs.get(index);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(CategroyPanel.instance,1);
    }

    @Override
    public void updateDate() {
        ctm.cs = new Categoryservice().getCategoryRecordNumber();
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);



        //�����б���ϢΪ0ʱ ����ɾ���ͱ༭��ť������
        if( 0 == ctm.cs.size()){
            bEidt.setEnabled(false);
            bDelete.setEnabled(false);
        }else{
            bEidt.setEnabled(true);
            bDelete.setEnabled(true);
        }

    }

    @Override
    public void addListener() {
        CategoryListener listener = new CategoryListener();
        bAdd.addActionListener(listener);
        bEidt.addActionListener(listener);
        bDelete.addActionListener(listener);

    }
}
