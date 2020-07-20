package util;

import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * 图形界面上的工具类
 */
public class GUIUtil {
    //图片存放位置
    private static String imageFolder = "img";

    /**
     * 判断是否为空
     * @param jf
     * @param input
     * @return
     */
    public static boolean checkEmpty(JTextField jf,String input){
        String text = jf.getText().trim();
        if(0== text.length()){
            //弹出窗口提示不能为空
            JOptionPane.showMessageDialog(null,input+"不能为空");
            //获取输出焦点
            jf.grabFocus();

            return false;
        }
        return true;
    }

    /**
     *判断是否为数字
     * @param jf
     * @param input
     * @return
     */
    public static boolean checkNnuber(JTextField jf,String input){
        //判断是否为空
        if(!checkEmpty(jf,input)){
            return false;
        }
        //获取输入的内容并去除空格
        String text = jf.getText().trim();
        try {
            Integer.parseInt(text);
            return true;
        }catch (NumberFormatException e){
            //捕获数据转化异常 并提示窗口
            JOptionPane.showMessageDialog(null,input+"需要是整数");
            return false;
        }
    }

    /**
     * 判断是否为零
     * @param jf
     * @param input
     * @return
     */
    public static boolean checkZore(JTextField jf ,String input){
        //判断是否为空
        if(!checkEmpty(jf, input)){
            return false;
        }
        //获取输入的内容并去除空格
        String text = jf.getText().trim();
        if (0 == Integer.parseInt(text)){
            //捕获数据转化异常 并提示窗口
            JOptionPane.showMessageDialog(null,input+"不能为零");
            return  false;
        }
        return true;
    }

    /**
     * 为一个或多个组件设置前景色
     * @param color
     * @param cs
     */
    public static void setColor(Color color,JComponent...cs){
        for (JComponent jComponent:cs) {
            jComponent.setForeground(color);
        }
    }

    /**
     *给按钮设置图标,按钮内的文字,以及提示文字
     * @param b
     * @param filename
     * @param tip
     */
    public static void setImageIcon(JButton b,String filename,String tip){
        //获取图片信息
        ImageIcon i = new ImageIcon(new File(imageFolder,filename).getAbsolutePath());
        //设置按钮图片
        b.setIcon(i);
        //设置组建的首选大小
        b.setPreferredSize(new Dimension(61,81));
        //设置提示文字
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalAlignment(JButton.CENTER);
        b.setText(tip);
    }

    /**
     * 设置皮肤
     * 在界面渲染前设置才能生效
     */
    public static void useLNF(){
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示画版类
     * @param p
     * @param strech 组件拉伸比 1表示满屏
     */
    public static void showPanel(JPanel p,double strech){
        GUIUtil.useLNF();
        JFrame f = new JFrame();
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(strech);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        cp.show(p);

    }

    /**
     * 默认为0.85的拉伸比例
     * @param b
     */
    public static void showPanel(JPanel b){
        showPanel(b,0.85);
    }

}
