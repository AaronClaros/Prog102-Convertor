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
    private JLabel labelPanelTitle;
    //label for input path
    private JLabel labelInputPath;
    //text field for input path
    private JTextField tFieldInputPath;
    //button for get table selection
    private JButton buttonGetTableSelect;
    //label for output path
    private JLabel labelOutPath;
    //text field for output path
    private JTextField tFieldOutPath;
    //button for output path
    private JButton buttonOutPath;

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
        //instance labelPanelTitle and set text
        labelPanelTitle = new JLabel("Conversion parameters");
        //instance labelInputPath and set text
        labelInputPath = new JLabel("Input Path");
        //instance textField for input path
        tFieldInputPath = new JTextField();
        //instance button get table selection and set text
        buttonGetTableSelect = new JButton("Set Selection");
        //instance label output path and set text
        labelOutPath = new JLabel("Output Path");
        //instance textField for OutputPath
        tFieldOutPath = new JTextField();
        //instance button for output path and set text
        buttonOutPath = new JButton("Path");
        //setting bounds
        labelPanelTitle.setBounds(10,10,150,25);
        labelInputPath.setBounds(10, 50, 100, 25);
        tFieldInputPath.setBounds(90,50,200,25);
        buttonGetTableSelect.setBounds(300,50,110,25);
        labelOutPath.setBounds(430, 50, 100, 25);
        tFieldOutPath.setBounds(520,50,200,25);
        buttonOutPath.setBounds(730,50,60,25);
        // add components to panel
        this.add(labelPanelTitle);
        this.add(labelInputPath);
        this.add(tFieldInputPath);
        this.add(buttonGetTableSelect);
        this.add(buttonOutPath);
        this.add(labelOutPath);
        this.add(tFieldOutPath);
        this.setVisible(true);
    }

    /**
     * getter method for text field input path
     * @return text field input path
     */
    public JTextField getTFInputPath(){
        return tFieldInputPath;
    }

    /**
     * getter method for text field output path
     * @return text field output path
     */
    public JTextField getTFOutputPath(){
        return tFieldOutPath;
    }

    /**
     * getter method for button get table selection
     * @return text field input path
     */
    public JButton getBTableSelect(){
        return buttonGetTableSelect;
    }

    /**
     * getter method for button output path
     * @return text field input path
     */
    public JButton getBOutputPath(){
        return  buttonOutPath;
    }
}
