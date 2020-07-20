package gui.panel;

import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class CategroyPanel extends JPanel{
    static {
        GUIUtil.useLNF();
    }
    public static CategroyPanel instance = new CategroyPanel();

    public JButton bAdd = new JButton("新增");
    public JButton bEidt = new JButton("编辑");
    public JButton bDelete = new JButton("删除");
    String colunmNames[] = new String[]{"分类名称","消费次数"};

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
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(CategroyPanel.instance,1);
    }
}
