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
 * @authors Adrian Rojas, Kevin Herrera, Kevin Sanchez - AWT-[01].
 * @version 0.1
 */

import com.foundations.convertor.utils.LoggerManager;

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
    // button with search action
    private JButton buttonSearch;
    //Title File name
    private JLabel labelFileExt;
    //Box for file name criteria
    private JComboBox boxFileExt;
    //Label for combo box frame rate
    private JLabel labelFrameRate;
    //Combo Box for frame rate selection;
    private JComboBox comboxFrameRate;
    //Label duration time video
    private JLabel labelDuration;
    //Label duration to time
    private JLabel labelDurationTo;
    // spinner for time duration from
    private JFormattedTextField boxDurationFrom;
    // spinner for time duration to
    private JFormattedTextField boxDurationTo;
    //Label for combo box frame rate
    private JLabel labelAspectRatio;
    //Combo Box for frame rate selection;
    private JComboBox comboxAspectRatio;
    //Label for combo box frame rate
    private JLabel labelResolution;
    //Combo Box for frame rate selection;
    private JComboBox comboxResolution;
    //Label for combo box MM Codec
    private JLabel labelVideoCodec;
    //Combo Box for frame MM Codec;
    private JComboBox comboxVideoCodec;
    //Label for combo box Audio Codec
    private JLabel labelAudioCodec;
    //Combo Box for frame MM Codec;
    private JComboBox comboxAudioCodec;
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
        //set border to panel
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //set background color of panel
        this.setBackground(UIManager.getColor ( "Panel.background" ));
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

        //Label for text field path
        labelPath = new JLabel("Path:", SwingConstants.RIGHT);

        //button path instance and labelTitle set
        buttonPath = new JButton("Open");

        //text field path instance
        boxPath = new JTextField(15);

        //text field file name
        boxFileName = new JTextField(10);

        //label file name instance and text set
        titleFileName= new JLabel("File Name:", SwingConstants.RIGHT);

        //button search instance and text set
        buttonSearch = new JButton("Search");

        //label file extension instance and text set
        labelFileExt = new JLabel("File Ext.:", SwingConstants.RIGHT);

        //supported extensions array
        String[] supported_ext = {"","mp4","avi","flv","mkv","mov","3gp"};

        //text field file extension instance
        boxFileExt = new JComboBox(supported_ext);

        //label duration instance and text set
        labelDuration = new JLabel("Duration From:", SwingConstants.RIGHT);

        //label "duration to" instance and text set
        labelDurationTo = new JLabel("To:", SwingConstants.RIGHT);

        //label frame rate instance and text set
        labelFrameRate = new JLabel("Frame Rate:", SwingConstants.RIGHT);

        //frame rates array
        String[] frame_rates = {"","24","25","29","29.7","30","59.94"};

        //combo box frame rate instance and content set
        comboxFrameRate = new JComboBox(frame_rates);

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

        //label aspect ratio instance and text set
        labelAspectRatio = new JLabel("Aspect Ratio:", SwingConstants.RIGHT);

        //aspect ratio array
        String[] asp_ratios = {"","16:9","16:10","0:1","4:3","40:23"};

        //combo box aspect ratio instance and content set
        comboxAspectRatio = new JComboBox(asp_ratios);

        //label resolution instance and text set
        labelResolution = new JLabel("Resolution:", SwingConstants.RIGHT);

        //resolution array
        String[] resolutions = {"","1920X1080","1280X720","640X480","640X368","480X270","320X240","256X240","176X144"};

        //combo box resolution instance and content set
        comboxResolution = new JComboBox(resolutions);

        //label video code instance and text set
        labelVideoCodec = new JLabel("MM Codec:", SwingConstants.RIGHT);

        //video codecs array
        String[] video_codecs = {"","h264","h263","indeo4","mpeg4","flv","avi"};

        //combo box video codec instance and content set
        comboxVideoCodec = new JComboBox(video_codecs);

        //label audio code instance and text set
        labelAudioCodec = new JLabel("Audio Codec:", SwingConstants.RIGHT);

        //audio codecs array
        String[] audio_codecs = {"","MP3","WMA","OGG","VIDEO"};

        //combo box audio codec instance and content set
        comboxAudioCodec = new JComboBox(audio_codecs);

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
     * This method initialize the extension fields
     */
    private void initCompExtention(){

        // setting constrains of labelFileExt
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 4;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelFileExt,bagConstraints);

        // setting constrains of boxFileExt
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 4;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(boxFileExt,bagConstraints);
    }

    /**
     * This method initialize the Frame rate fields
     */
    private void initCompFrame(){
        // setting constrains of labelFrameRate
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 5;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelFrameRate,bagConstraints);

        // setting constrains of comboxFrameRate
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 5;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(comboxFrameRate,bagConstraints);
    }

    /**
     * This method initialize the aspect ratio fields
     * @return it return a JPanel object
     * to be added in the search panel
     */
    private void initCompAspect(){

        // setting constrains of labelAspectRatio
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 6;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelAspectRatio,bagConstraints);

        // setting constrains of comboxAspectRatio
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 6;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(comboxAspectRatio,bagConstraints);
    }

    /**
     * This method initialize the resolution fields
     * @return it return a JPanel object
     * to be added in the search panel
     */
    private void initCompResolution(){

        // setting constrains of labelResolution
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 7;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelResolution,bagConstraints);

        // setting constrains of comboxResolution
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 7;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(comboxResolution,bagConstraints);
    }

    /**
     * This method initialize the video codec fields
     */
    private void initCompVideo(){

        // setting constrains of labelVideoCodec
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 8;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelVideoCodec,bagConstraints);

        // setting constrains of comboxVideoCodec
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 8;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(comboxVideoCodec,bagConstraints);
    }

    /**
     * This method initialize the audio codec fields
     */
    private void initCompAudio(){

        // setting constrains of labelAudioCodec
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 9;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelAudioCodec,bagConstraints);

        // setting constrains of comboxAudioCodec
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 9;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(comboxAudioCodec,bagConstraints);
    }

    /**
     * This method initialize the search button fields
     */
    private void initCompBtnSearch(){

        // setting constrains of buttonSearch
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 11;
        bagConstraints.gridwidth = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.weighty = 0.5;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(buttonSearch,bagConstraints);
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
        initCompExtention();
        initCompFrame();
        initCompAspect();
        initCompResolution();
        initCompVideo();
        initCompAudio();
        initCompBtnSearch();

        // set visible the search panel
        this.setVisible(true);
    }

    /**
     * Getter of the search button
     * @return the search button object
     */
    public JButton getSearchButton(){
        return this.buttonSearch;
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
     * Getter for the file extension box
     * @return filer extension box object
     */
    public JComboBox getBoxFileExt() {
        return this.boxFileExt;
    }

    /**
     * Getter for the Frame Rate combo box
     * @return frame rate combo box object
     */
    public JComboBox getCBFrameRate() {
        return this.comboxFrameRate;
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
     * Getter for the Aspect Ratio combo box
     * @return aspect ratio combo box object
     */
    public JComboBox getCBAspectRatio() {
        return this.comboxAspectRatio;
    }

    /**
     * Getter for the Resolution combo box
     * @return resolution combo box object
     */
    public JComboBox getCBResolution() {
        return this.comboxResolution;
    }

    /**
     * Getter for the MM Codec combo box
     * @return video codec combo box object
     */
    public JComboBox getCBVideoCodec() {
        return this.comboxVideoCodec;
    }

    /**
     * Getter for the Audio Codec combo box
     * @return audio codec combo box object
     */
    public JComboBox getCBVAudioCodec() {
        return this.comboxAudioCodec;
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
    public void setDefaultDuration() {
        //set default duration time for duration from
        boxDurationFrom.setValue("00:00:00");
        //set default duration time for duration to
        boxDurationTo.setValue("99:59:59");
    }
}
