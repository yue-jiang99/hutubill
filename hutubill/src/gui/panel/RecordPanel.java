package gui.panel;

import org.jdesktop.swingx.JXDatePicker;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;

public class RecordPanel extends JPanel{
    //背景
    static {
        GUIUtil.useLNF();
    }

    public static RecordPanel instance = new RecordPanel();


    private JLabel lSpend = new JLabel("花费");
    private JLabel lCatrgory = new JLabel("分类");
    private JLabel lComment = new JLabel("备注");
    private JLabel lDate = new JLabel("日期");

    private JTextField jt = new JTextField("0");
    private JTextField jt1 = new JTextField("餐饮");
    private JTextField jt2 = new JTextField("");
    private JXDatePicker datePicker = new JXDatePicker();

    JButton bSubmit = new JButton("记一笔");

    public RecordPanel(){
        GUIUtil.setColor(ColorUtil.grayColor,lCatrgory,lComment,lDate,lSpend);
        GUIUtil.setColor(ColorUtil.blueColor,bSubmit);
        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();

        int gap = 40;
        pInput.setLayout(new GridLayout(4,2,gap,gap));

        pInput.add(lSpend);
        pInput.add(jt);
        pInput.add(lCatrgory);
        pInput.add(jt1);
        pInput.add(lComment);
        pInput.add(jt2);
        pInput.add(lDate);
        pInput.add(datePicker);

        pSubmit.add(bSubmit);

        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.CENTER);

    }

}
