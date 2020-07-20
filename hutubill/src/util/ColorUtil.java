package util;

import javax.swing.*;
import java.awt.*;

public class ColorUtil {

    /**
     *颜色
     */
    public static Color blueColor = Color.decode("#3399FF");           //blueColor 淡蓝色
    public static Color grayColor = Color.decode("#999999");           //grayColor 灰色
    public static Color warningColor = Color.decode("#FF3333");        //warningColor 警告红色
    public static Color backgroundColor = Color.decode("#eeeeee");     //backgroundColor 背景色

    public static Color getByPercentage(int per){
        if(per>100){per=100;}
        int r = 51;
        int g = 255;
        int b = 51;

        float rate = per/100f;
        r = (int)(204 * rate +51);
        g = 255 - r + 51;
        Color color = new Color(r,g,b);
        return color;
    }

//    public static class MainFrame extends JFrame {
//        private static final long serialVersionUID = 1L;
//        public static MainFrame instance = new MainFrame();
//
//        private MainFrame(){
//            //设置窗体大小
//            this.setSize(500,450);
//            //设置窗口标题
//            this.setTitle("一本糊涂账");
//            //设置床架的主面板
//            this.setContentPane(MainPanel.instance);
//            //窗体居中显示
//            this.setLocationRelativeTo(null);
//            //设置窗体大小是否可调
//            this.setResizable(false);
//            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        }
//
//        public static void main(String[] args){
//            instance.setVisible(true);
//        }
//    }
}
