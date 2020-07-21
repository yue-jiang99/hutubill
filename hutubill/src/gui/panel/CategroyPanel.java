package gui.panel;

import entity.Category;
import gui.model.CategoryTableModel;
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

    }

    @Override
    public void addListener() {

    }
}
