package gui.listener;

import entity.Config;
import gui.panel.ConfigPanel;
import service.Configservice;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ConfigListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * 1�������ж������Ԥ����Ϣ�Ƿ�Ϊ����
         * 2�������ж�MySQL�ð�װ·���Ƿ���ȷ���жϸ�Ŀ¼��binĿ¼���Ƿ���mysql.exe��
         * 3)����ConfigService��update�����޸����ݿ�����
         */
        //��ȡ������Ϣ�����ʵ��
        ConfigPanel cp = ConfigPanel.instance;
        //�ж������Ԥ���Ƿ�Ϊ����,String�����Ϊ����ĺ���
        if (!GUIUtil.checkNnuber(cp.tfBudget,"����Ԥ��")){
            return;
        }
        //��ȡmysql�İ�װ·��
        String mysqlPath = cp.tfMysql.getText().trim();
        //�����벻Ϊ��,���һ�����mysql��װĿ¼�Ƿ���ȷ
        if (0 == mysqlPath.length()) {
            File f = new File(mysqlPath,"bin/mysql.txt");
            if (!f.exists()){
                JOptionPane.showMessageDialog(cp,"mysql��װ·������ȷ");
                cp.tfMysql.grabFocus();
                return;
            }
        }
        Configservice cs = new Configservice();
        cs.update(Configservice.budget, cp.tfBudget.getText());
        cs.update(Configservice.mysqlPath,mysqlPath);
        JOptionPane.showMessageDialog(cp,"�����޸ĳɹ�");
    }
}
