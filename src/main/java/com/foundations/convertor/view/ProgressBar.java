/*
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.foundations.convertor.view;

import com.foundations.convertor.utils.LoggerManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.*;
import java.awt.*;

/**
 *  class for progress bar
 *
 * @author Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class ProgressBar extends JFrame implements ChangeListener {
    private JLabel lblProgres;
    private JProgressBar progBar;
    private Dimension dimension;
    private GridBagConstraints bagConstraints;
    JPanel panel;

    /**
     * this method will set the items and time
     * for the progress bar
     */
    public ProgressBar(){
        settings();
        initComp();
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
    }

    /**
     * initialize the components for the frame
     */
    private void initComp(){
        panel = new JPanel();
        lblProgres = new JLabel("Procesando........",SwingConstants.CENTER);
        progBar = new JProgressBar();
        progBar.setValue(0);
        progBar.setStringPainted(true);
        panel.setLayout(new GridBagLayout());

        // setting constrains of label
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.insets = new Insets(5,0,5,0);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(lblProgres,bagConstraints);

        // setting constrains of progress bar
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.insets = new Insets(5,0,5,0);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(progBar,bagConstraints);
        panel.setBackground(new Color(1,100,100,100));
        panel.setOpaque(true);
        this.add(panel);
        this.setLocationRelativeTo(null);
    }
    /**
     * this method makes the progress bar update
     */
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        try {
                int percentage;
                percentage = (int) Math.round((double) newValue * 100);
                if (percentage == 100 || percentage == 0){
                    this.setVisible(false);
                }else{
                    progBar.setValue(percentage);
                    this.setVisible(true);
                }
                // this allows to display the changes
                // in the progress bar
                Thread.sleep(400);
                this.setVisible(false);
        }catch (Exception e){
            LoggerManager.getLogger().Log(e.getMessage(),"ERROR");
        }
    }
}



