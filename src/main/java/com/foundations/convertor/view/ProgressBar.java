package com.foundations.convertor.view;

import javax.swing.*;
import java.awt.*;

public class ProgressBar extends JFrame {
    private JLabel lblProgres;
    private JProgressBar progBar;
    private JSlider slider;
    private Dimension dimension;
    private GridBagConstraints bagConstraints;

    private MyThreat myThreat;
    private Thread thread;
    private Timer timer;
    private int value;


    /**
     * this method will set the items and time
     * for the progress bar
     */
    public ProgressBar(){
        settings();
        initComp();
        //iniBar();
    }

    /**
     * this method allows to create a threat for the
     * progress bar
     */
    public void iniBar() {
        myThreat = new MyThreat();
        thread = new Thread(myThreat);
        thread.start();
    }

    public void setValue(int value) {
        this.value = value;iniBar();
    }

    public void updateB(int val){
        progBar.setValue(value);
        progBar.repaint();
        System.out.println(value+"----------------");
    }
    /**
     * setting for the frame
     */
    private void settings(){
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());
        bagConstraints = new GridBagConstraints();
        this.setSize(dimension);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        this.setBackground(new Color(0,0,0,0));
        //this.setOpacity(0.2f);
    }

    /**
     * initialize the components for the frame
     */
    private void initComp(){
        lblProgres = new JLabel("Procesando........",SwingConstants.CENTER);
        progBar = new JProgressBar();
        progBar.setValue(0);
        progBar.setStringPainted(true);

        JPanel panel = new JPanel();

        // setting constrains of label
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.insets = new Insets(5,0,5,0);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(lblProgres,bagConstraints);

        // setting constrains of progress bar
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.insets = new Insets(5,0,5,0);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(progBar,bagConstraints);
        panel.setBackground(new Color(1,100,100,100));
        panel.setOpaque(true);
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // manage threats at the same time
    public class MyThreat implements Runnable{
        @Override
        public void run() {
           updateB(value);
           if (value==100)
               dispose();
        }
    }
}
