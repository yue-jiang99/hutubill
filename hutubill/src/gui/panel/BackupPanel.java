package gui.panel;

import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;

public class BackupPanel extends WorkingPanel{
    static {
        GUIUtil.useLNF();
    }
    public static BackupPanel instance = new BackupPanel();
    JButton bBackup = new JButton("±¸·Ý");

    public BackupPanel() {
        GUIUtil.setColor(ColorUtil.blueColor,bBackup);
        this.add(bBackup);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(BackupPanel.instance);
    }

    @Override
    public void updateDate() {

    }

    @Override
    public void addListener() {

    }
}
