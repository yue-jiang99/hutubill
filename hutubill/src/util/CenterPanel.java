package util;



import gui.panel.WorkingPanel;

import javax.swing.*;
import java.awt.*;

/**
 * �������
 */
public class CenterPanel extends JPanel {
    //�������
    private double rate;
    //��ʾ�����
    private JComponent c;
    //�Ƿ�����
    private boolean strech;

    public CenterPanel(double rate, boolean strech) {
        this.setLayout(null);
        this.rate = rate;
        this.strech = strech;
    }

    //strechĬ��Ϊtrue
    public CenterPanel(double rate) {
        this(rate,true);
    }

    public void  repaint(){
        if (null != c){
            Dimension containerSize = this.getSize();
            Dimension conponentSize = c.getPreferredSize();

            if(strech){
                c.setSize((int)(containerSize.width * rate),(int)(containerSize.height * rate));
            }else {
                c.setSize(conponentSize);
                c.setLocation(containerSize.width / 2 - c.getSize().width /2,
                        containerSize.height /2 - c.getSize().height / 2);
            }
        }
        super.repaint();
    }

    /**
     * ��ʾ���
     * @param p
     */
    public void show(JComponent p ){
        this.c=p;
        Component[] cs = getComponents();
        for (Component c : cs ){
            remove(c);
        }
       if (p instanceof WorkingPanel){

        }
        add(p);
        this.updateUI();

    }
}


