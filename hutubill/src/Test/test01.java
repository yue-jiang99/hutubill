package Test;

import util.ColorUtil;
import util.CircleProgressBar;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test01 {
    public static void main(String[] args) {

        GUIUtil.useLNF();

        //���
        JPanel p = new JPanel();

        //���������
        CircleProgressBar cpb = new CircleProgressBar();
        cpb.setBackgroundColor(ColorUtil.blueColor);
        cpb.setProgress(0);

        //��ť
        JButton b = new JButton("start!");

        //������
        p.setLayout(new BorderLayout());
        p.add(cpb,BorderLayout.CENTER);
        p.add(b,BorderLayout.SOUTH);
        //��ʾ���
        GUIUtil.showPanel(p);
        //����ť�Ӽ�����
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingWorker(){
                    @Override
                    protected Object doInBackground() throws Exception {
                        for (int i = 0; i < 100 ; i++) {
                            cpb.setProgress(i+1);
                            cpb.setBackgroundColor(ColorUtil.getByPercentage(i+1));
                            try {
                                Thread.sleep(100);
                            }catch (InterruptedException e2){
                                e2.printStackTrace();
                            }
                        }
                        return null;
                    }
                }.execute();
            }
        });
    }
}
