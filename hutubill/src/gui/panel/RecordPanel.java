package gui.panel;

import entity.Category;
import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import org.jdesktop.swingx.JXDatePicker;
import service.Categoryservice;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class RecordPanel extends WorkingPanel{
    //背景
    static {
        GUIUtil.useLNF();
    }

    public static RecordPanel instance = new RecordPanel();


    public JLabel lSpend = new JLabel("花费");
    public JLabel lCatrgory = new JLabel("分类");
    public JLabel lComment = new JLabel("备注");
    public JLabel lDate = new JLabel("日期");

    public JTextField tfSpend = new JTextField("0");
    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<Category>(cbModel);
    public JTextField tfComment = new JTextField();
    public JXDatePicker datePicker = new JXDatePicker(new Date());

    JButton bSubmit = new JButton("记一笔");

    public RecordPanel(){
        GUIUtil.setColor(ColorUtil.grayColor,lCatrgory,lComment,lDate,lSpend);
        GUIUtil.setColor(ColorUtil.blueColor,bSubmit);
        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();

        int gap = 40;
        pInput.setLayout(new GridLayout(4,2,gap,gap));

        pInput.add(lSpend);
        pInput.add(tfSpend);
        pInput.add(lCatrgory);
        pInput.add(cbCategory);
        pInput.add(lComment);
        pInput.add(tfComment);
        pInput.add(lDate);
        pInput.add(datePicker);

        pSubmit.add(bSubmit);

        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.CENTER);

        addListener();

    }

    @Override
    public void updateDate() {
        //重新赋值cbModel中的cs数组
        cbModel.cs = new Categoryservice().getCategoryRecordNumber();
        //重新渲染
        cbCategory.updateUI();

        //重置其他的控件
        tfSpend.setText("");
        tfComment.setText("");
        if(0 != cbModel.getSize()){
            cbCategory.setSelectedItem(0);
        }

        datePicker.setDate(new Date());
    }

    @Override
    public void addListener() {
        RecordListener listener = new RecordListener();

        bSubmit.addActionListener( listener);

    }
}
