package gui.frame;

import gui.panel.MainPanel;
import gui.panel.WorkingPanel;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public static MainFrame instance = new MainFrame();

    public MainFrame(){
        this.setSize(500, 450);
        this.setTitle("Ò»±¾ºýÍ¿ÕË");
        this.setContentPane(MainPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MainFrame.instance.setVisible(true);
    }
}