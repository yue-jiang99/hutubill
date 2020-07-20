package util;

import javax.swing.*;
import java.awt.*;

public class ColorUtil {

    /**
     *��ɫ
     */
    public static Color blueColor = Color.decode("#3399FF");           //blueColor ����ɫ
    public static Color grayColor = Color.decode("#999999");           //grayColor ��ɫ
    public static Color warningColor = Color.decode("#FF3333");        //warningColor �����ɫ
    public static Color backgroundColor = Color.decode("#eeeeee");     //backgroundColor ����ɫ

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
//            //���ô����С
//            this.setSize(500,450);
//            //���ô��ڱ���
//            this.setTitle("һ����Ϳ��");
//            //���ô��ܵ������
//            this.setContentPane(MainPanel.instance);
//            //���������ʾ
//            this.setLocationRelativeTo(null);
//            //���ô����С�Ƿ�ɵ�
//            this.setResizable(false);
//            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        }
//
//        public static void main(String[] args){
//            instance.setVisible(true);
//        }
//    }
}
