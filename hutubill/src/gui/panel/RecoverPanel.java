package gui.panel;

import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;

public class RecoverPanel extends WorkingPanel{
    static {
        GUIUtil.useLNF();
    }
    public static RecoverPanel instance = new RecoverPanel();
    JButton bRecover = new JButton("»Ö¸´");

    public RecoverPanel() {
        GUIUtil.setColor(ColorUtil.blueColor,bRecover);
        this.add(bRecover);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }

    @Override
    public void updateDate() {

    }

    @Override
    public void addListener() {

    }
}
