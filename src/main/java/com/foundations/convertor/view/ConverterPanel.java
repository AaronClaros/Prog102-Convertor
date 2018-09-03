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
    private JButton buttonGetTSelection;
    //label for output path
    private JLabel labelOutPath;
    //text field for output path
    private JTextField tFieldOutPath;
    //button for output path
    private JButton buttonOutPath;

    /**
     * constructor of father class JPanel
     */
    public ConverterPanel() {
        super();
        // Initialize attributes or components
        initComp();
        // set the panel
        settings();
    }

    /**
     * configure components
     */
    private void settings() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.setBorder(BorderFactory.createLineBorder(Color.black));

        this.setBackground(Color.lightGray);
    }

    /**
     * Initialize components
     */
    private void initComp() {
        //instance labelPanelTitle and set text
        labelPanelTitle = new JLabel("Conversion parameters");

        //create panel container for title section
        JPanel panelTitle = new JPanel();
        //set layout for panel title
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        //add label labelTitle to panel
        panelTitle.add(labelPanelTitle);

        //instance labelInputPath and set text
        labelInputPath = new JLabel("Input Path");
        //instance textField for input path
        tFieldInputPath = new JTextField(15);
        //instance button get table selection and set text
        buttonGetTSelection = new JButton("Set Selection");
        JPanel panelInputPath = new JPanel();
        panelInputPath.setLayout(new FlowLayout(FlowLayout.LEADING));
        panelInputPath.add(labelInputPath);
        panelInputPath.add(tFieldInputPath);
        panelInputPath.add(buttonGetTSelection);

        //instance label output path and set text
        labelOutPath = new JLabel("Output Path");
        //instance textField for OutputPath
        tFieldOutPath = new JTextField(15);
        //instance button for output path and set text
        buttonOutPath = new JButton("Path");
        JPanel panelOutputPath = new JPanel();
        panelOutputPath.setLayout(new FlowLayout(FlowLayout.LEADING));
        panelOutputPath.add(labelInputPath);
        panelOutputPath.add(tFieldInputPath);
        panelOutputPath.add(buttonGetTSelection);


        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        panelInputPath.setMinimumSize(new Dimension(300, 300));
        panelInputPath.setMaximumSize(new Dimension(1000, 300));

        panelOutputPath.setMinimumSize(new Dimension(300, 300));
        panelOutputPath.setMaximumSize(new Dimension(1000, 300));

        panelCenter.add(panelInputPath);
        panelCenter.add(panelOutputPath);

        this.add(panelTitle);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(panelCenter);

        /*
        //instance labelInputPath and set text
        labelInputPath = new JLabel("Input Path");
        //instance textField for input path
        tFieldInputPath = new JTextField();
        //instance button get table selection and set text
        buttonGetTSelection = new JButton("Set Selection");
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
        buttonGetTSelection.setBounds(300,50,110,25);
        labelOutPath.setBounds(430, 50, 100, 25);
        tFieldOutPath.setBounds(520,50,200,25);
        buttonOutPath.setBounds(730,50,60,25);
        // add components to panel
        this.add(labelPanelTitle);
        this.add(labelInputPath);
        this.add(tFieldInputPath);
        this.add(buttonGetTSelection);
        this.add(buttonOutPath);
        this.add(labelOutPath);
        this.add(tFieldOutPath);
        */

        //this.add(mainPanel);
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
        return buttonGetTSelection;
    }

    /**
     * getter method for button output path
     * @return text field input path
     */
    public JButton getBOutputPath(){
        return  buttonOutPath;
    }
}
