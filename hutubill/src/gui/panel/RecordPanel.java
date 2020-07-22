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
    //����
    static {
        GUIUtil.useLNF();
    }

    public static RecordPanel instance = new RecordPanel();


    public JLabel lSpend = new JLabel("����");
    public JLabel lCatrgory = new JLabel("����");
    public JLabel lComment = new JLabel("��ע");
    public JLabel lDate = new JLabel("����");

    public JTextField tfSpend = new JTextField("0");
    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<Category>(cbModel);
    public JTextField tfComment = new JTextField();
    public JXDatePicker datePicker = new JXDatePicker(new Date());

    JButton bSubmit = new JButton("��һ��");

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
        //���¸�ֵcbModel�е�cs����
        cbModel.cs = new Categoryservice().getCategoryRecordNumber();
        //������Ⱦ
        cbCategory.updateUI();

        //���������Ŀؼ�
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
