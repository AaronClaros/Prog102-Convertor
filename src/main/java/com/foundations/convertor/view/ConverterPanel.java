/*
 *
 *  Copyright (c) 2018 Jala Foundation.
 *
 *  2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  All rights reserved.
 *  This software is the confidential and proprietary information of
 *  Jala Foundation, ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jala Foundation.
 *
 */

package com.foundations.convertor.view;

import javax.swing.*;
import java.awt.*;

/**
 *  JPanel Object that contains conversion parameters
 *
 * @author Kevin Herrera - AWT-[01].
 * @version 0.1
 */

public class ConverterPanel extends JPanel {
    //label for title panel
    JLabel labelPanelTitle;

    JLabel labelOutPath;

    JTextField fieldOutPath;

    /**
     * constructor of father class JPanel
     * @param fWidth main frame width
     * @param fHeight main frame height
     */
    public ConverterPanel(int fWidth, int fHeight) {
        super();
        // Initialize attributes or components
        initComp();
        // set the panel
        settings(fWidth,fHeight);
    }

    /**
     * configure components
     * @param w main frame width
     * @param h main frame height
     */
    private void settings(int w, int h) {
        // Panel size and location
        //this.setSize(3*w/4-20,(h-40)/2);
        this.setBounds(w/4+5,h/2-5,3*w/4-20,(h)/2-30);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.lightGray);
        // layout not used, to position components
        this.setLayout(null);
    }

    /**
     * Initialize components
     */
    private void initComp() {
        // instance labelPanelTitle and set text
        labelPanelTitle = new JLabel("Conversion parameters");

        labelPanelTitle.setBounds(10,10,150,25);

        labelOutPath = new JLabel("Output Path");

        labelOutPath.setBounds(10, 50, 100, 25);

        fieldOutPath = new JTextField();

        fieldOutPath.setBounds(90,50,200,30);

        // add components to panel
        this.add(labelPanelTitle);
        this.add(labelOutPath);
        this.add(fieldOutPath);
        this.setVisible(true);
    }
}
