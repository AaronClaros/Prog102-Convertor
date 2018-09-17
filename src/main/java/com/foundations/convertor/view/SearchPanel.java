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

/**
 *  Panel for the convertor search criteria
 *
 * @authors Adrian Rojas, Kevin Herrera, Kevin Sanchez, Angelica Lopez - AWT-[01].
 * @version 0.1
 */

import com.foundations.convertor.utils.LoggerManager;

import com.foundations.convertor.utils.StyleUtils;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.EventListener;

/**
 * UI: Search panel with the criteria options for the search
 */
public class SearchPanel extends JPanel implements ActionListener, EventListener{
    //Panel labelTitle:Search Criteria
    private JLabel labelTitle;
    //Panel labelTitle:Search Criteria
    private JLabel labelPath;
    // box for path insertion criteria
    private JTextField boxPath;
    // button with browse action
    private JButton buttonPath;
    //Title File name
    private JLabel titleFileName;
    // box for file name criteria
    private JTextField boxFileName;
    //Label duration time video
    private JLabel labelDuration;
    //Label duration to time
    private JLabel labelDurationTo;
    // spinner for time duration from
    private JFormattedTextField boxDurationFrom;
    // spinner for time duration to
    private JFormattedTextField boxDurationTo;
    // this variable helps to set objects of
    // the search panel
    private GridBagConstraints bagConstraints;

    /**
     * Constructor of father class JPanel
     */
    public SearchPanel() {
        super();
        // set the panel
        settings();
        // Initialize attributes or components
        initComp();
    }

    /**
     * Search panel settings
     */
    private void settings() {
        //set background color of panel
        this.setBackground(new java.awt.Color(184, 187, 192));
        // type of layout for the panel
        this.setLayout(new GridBagLayout());
        bagConstraints = new GridBagConstraints();
    }
    /**
     * this method create the instance of the fields
     * for the converter panel
     */
    private void initCompFields(){
        //Panel labelTitle
        labelTitle = new JLabel("Search Criteria", SwingConstants.CENTER);
        setColorLabel(labelTitle);

        //Label for text field path
        labelPath = new JLabel("Path:", SwingConstants.RIGHT);
        setColorLabel(labelPath);

        //button path instance and labelTitle set
        //Added Icon to button
        ImageIcon openIcon = StyleUtils.getInstance().createImageIcon("Open_16.png");
        buttonPath = new JButton(openIcon);

        //text field path instance
        boxPath = new JTextField(15);

        //text field file name
        boxFileName = new JTextField(10);

        //label file name instance and text set
        titleFileName= new JLabel("File Name:", SwingConstants.RIGHT);
        setColorLabel(titleFileName);

        //label duration instance and text set
        labelDuration = new JLabel("Duration From:", SwingConstants.RIGHT);
        setColorLabel(labelDuration);

        //label "duration to" instance and text set
        labelDurationTo = new JLabel("To:", SwingConstants.RIGHT);
        setColorLabel(labelDurationTo);

        //box "duration from" instance and text format set
        boxDurationFrom = new JFormattedTextField(createFormat("##:##:##"));
        boxDurationFrom.setHorizontalAlignment(SwingConstants.CENTER);

        //set default duration time for duration from
        boxDurationFrom.setValue("00:00:00");

        //box "duration to" instance and text format set
        boxDurationTo = new JFormattedTextField(createFormat("##:##:##"));
        boxDurationTo.setHorizontalAlignment(SwingConstants.CENTER);

        //set default duration time for duration to
        boxDurationTo.setValue("99:59:59");

        //set action listener to button set search path
        buttonPath.addActionListener(this);
    }

    /**
     * This method initialize the tittle
     */
    private void initCompTitle(){

        // setting constrains of title
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        bagConstraints.gridwidth = 7;
        bagConstraints.gridheight = 1;
        bagConstraints.insets = new Insets(10,0,30,0);
        bagConstraints.fill = GridBagConstraints.BOTH;
        this.add(labelTitle,bagConstraints);
    }

    /**
     * This method initialize the search fields
     */
    private void initCompSearchP(){

        // setting constrains of label path
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelPath,bagConstraints);

        // setting constrains of boxpath
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 1;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(boxPath,bagConstraints);

        // setting constrains of button path
        bagConstraints.gridx = 6;
        bagConstraints.gridy = 1;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(buttonPath,bagConstraints);
    }

    /**
     * This method initialize the file name fields
     */
    private void initCompFileName(){

        // setting constrains of titleFileName
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 2;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(titleFileName,bagConstraints);

        // setting constrains of boxFileName
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 2;
        bagConstraints.gridwidth = 5;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(boxFileName,bagConstraints);
    }

    /**
     * This method initialize the duration fields
     */
    private void initCompDuration(){

        // setting constrains of labelDuration
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 3;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelDuration,bagConstraints);

        // setting constrains of boxDurationFrom
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 3;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 0.2;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(boxDurationFrom,bagConstraints);

        // setting constrains of labelDurationTo
        bagConstraints.gridx = 3;
        bagConstraints.gridy = 3;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelDurationTo,bagConstraints);

        // setting constrains of boxDurationTo
        bagConstraints.gridx = 5;
        bagConstraints.gridy = 3;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(boxDurationTo,bagConstraints);
    }

    /**
     * Initialize components
     */
    private void initComp() {
        initCompFields();
        initCompTitle();
        initCompSearchP();
        initCompFileName();
        initCompDuration();
        // set visible the search panel
        this.setVisible(true);
    }

    /**
     * Getter of the search path box
     * @return Path text field object
     */
    public JTextField getBoxPath(){
        return this.boxPath;
    }

    /**
     * Getter for the file name box
     * @return file name text field object
     */
    public JTextField getBoxFileName(){
        return this.boxFileName;
    }

    /**
     * Getter for the Duration From box object
     */
    public JTextField getBoxDurationFrom() {
        return this.boxDurationFrom;
    }

    /**
     * Getter for the Duration To box
     * @return duration to combo box object
     */
    public JTextField getBoxDurationTo() {
        return this.boxDurationTo;
    }

    /**
     * try to create a masked text format
     * @param s desired format
     * @return text maskformat
     */
    private MaskFormatter createFormat(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }

    /**
     * Obtain path for Search
     * @param e event of path button choosing directory
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //File chooser for path
        JFileChooser fc = new JFileChooser();
        // start at application current directory
        fc.setCurrentDirectory(new java.io.File("."));
        //Only can select directories
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File yourFolder = fc.getSelectedFile();
        }
        //Copy selected path to the text box
        try {
            boxPath.setText(fc.getSelectedFile().getAbsolutePath());
        } catch (Exception ex){
            LoggerManager.getLogger().Log( ex.getMessage(), "Error");
        }
    }

    /**
     * Setting to duration field by default.
     */
    public void setDefaultDuration() {
          //set default duration time for duration from
          boxDurationFrom.setValue("00:00:00");
          //set default duration time for duration to
          boxDurationTo.setValue("99:59:59");
      }

    /**
     * Set path red: As a mandatory field
     */
    public void setPathRequiredRed(){
        this.labelPath.setForeground(Color.red);
        this.add(labelPath);
    }

    /**
     * Set path to default once the search starts
     */
    public void setPathRequiredDefault(){
        this.labelPath.setForeground(Color.darkGray);
    }

    /**
     * Setting Color to label
     * @param jLabel
     */
    private void setColorLabel(JLabel jLabel){
        jLabel.setBackground(new java.awt.Color(59, 59, 61));
    }
}
