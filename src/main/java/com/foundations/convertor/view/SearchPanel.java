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
 * @authors Adrian Rojas, Kevin Herrera - AWT-[01].
 * @version 0.1
 */
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
    //Panel title:Search Criteria
    private JLabel title;
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
    private JTextField boxFileExt;
    //Label for combo box frame rate
    private JLabel labelFrameRate;
    //Combo Box for frame rate selection;
    private JComboBox comboxFrameRate;
    //Label duration time video
    private JLabel labelDuration;
    //Label duration from time
    private JLabel labelDurationFrom;
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
    //Label for combo box Video Codec
    private JLabel labelVideoCodec;
    //Combo Box for frame Video Codec;
    private JComboBox comboxVideoCodec;
    //Label for combo box Audio Codec
    private JLabel labelAudioCodec;
    //Combo Box for frame Video Codec;
    private JComboBox comboxAudioCodec;

    /**
     * Constructor of father class JPanel
     * @param fWidth main frame width
     * @param fHeight main frame height
     */
    public SearchPanel(int fWidth, int fHeight) {
        super();
        // Initialize attributes or components
        initComp();
        // set the panel
        settings(fWidth,fHeight);
    }

    /**
     * Search panel settings
     * @param w main frame width
     * @param h main frame height
     */
    private void settings(int w,int h) {
        // Panel size: main frame/4 for width
        this.setBounds(5,5,w/4-10,h-40);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.lightGray);
        // layout not used, to position components
        this.setLayout(null);
    }

    /**
     * Initialize components
     */
    private void initComp() {
        title= new JLabel("Search Criteria");
        buttonPath = new JButton("Path");
        boxPath = new JTextField();
        boxFileName = new JTextField();
        titleFileName= new JLabel("File Name");
        buttonSearch = new JButton("Search");
        labelFileExt = new JLabel("File Ext.");
        boxFileExt = new JTextField();
        labelDuration = new JLabel("Duration");
        labelDurationFrom = new JLabel("From");
        labelDurationTo = new JLabel("To");
        labelFrameRate = new JLabel("Frame Rate");
        String[] frame_rates = {"","24","29","30","60"};
        comboxFrameRate = new JComboBox(frame_rates);
        boxDurationFrom = new JFormattedTextField(createFormat("###:##:##"));
        boxDurationTo = new JFormattedTextField(createFormat("###:##:##"));
        labelAspectRatio = new JLabel("Aspect Ratio");
        String[] asp_ratios = {"","16:9","16:10","4:3"};
        comboxAspectRatio = new JComboBox(asp_ratios);
        labelResolution = new JLabel("Resolution");
        String[] resolutions = {"","720x480","1080x720","1440x1080"};
        comboxResolution = new JComboBox(resolutions);
        labelVideoCodec = new JLabel("Video Codec");
        String[] video_codecs = {"","H264","MP4","AVI"};
        comboxVideoCodec = new JComboBox(video_codecs);
        labelAudioCodec = new JLabel("Audio Codec");
        String[] audio_codecs = {"","MP3","WMA","OGG"};
        comboxAudioCodec = new JComboBox(audio_codecs);
        // Panel title
        //title.setText("Search Criteria");
        //button title
        //buttonPath.setText("Path");
        //Field title
        //titleFileName.setText("File Name");
        // Text for button
        //buttonSearch.setText("Search");
        //Setting text labelDuration
        //labelDuration.setText("Duration");
        //Setting text labelDuration
        //labelDurationFrom.setText("From");
        //Setting text labelDuration
        //labelDurationTo.setText("To");
        //Setting text labelFileExt;
        //labelFileExt.setText("File Ext.");
        //Setting text labelFrameRate
        //labelFrameRate.setText("Frame Rate");
        //Setting default duration from time
        boxDurationFrom.setValue("000:00:00");
        //Setting default duration to time
        boxDurationTo.setValue("000:00:00");
        //Setting labelAspectRatio text
        //labelAspectRatio.setText("Aspect Ratio");
        // box is listening for the path button to fill
        buttonPath.addActionListener(this);
        //title set positions and sizes
        title.setBounds(10,20,100,20);
        //field Path set positions and sizes
        buttonPath.setBounds(220, 50, 60, 25);
        boxPath.setBounds(10, 50, 200, 25);
        //field FileName set positions and sizes
        titleFileName.setBounds(10,90,80,25);
        boxFileName.setBounds(90, 90, 200, 25);
        //field FileExt set positions and sizes
        labelFileExt.setBounds(10, 120, 80, 25);
        boxFileExt.setBounds(90, 120, 50, 25);
        //field FrameRate set positions and sizes
        labelFrameRate.setBounds(10, 150, 100, 25);
        comboxFrameRate.setBounds(90, 150, 50, 25);
        //field Duration set positions and size
        labelDuration.setBounds(10,180,80,25);
        labelDurationFrom.setBounds(90,180,80,25);
        boxDurationFrom.setBounds(125,180,60,25);
        labelDurationTo.setBounds(200,180,80,25);
        boxDurationTo.setBounds(220,180,60,25);
        //Field AspectRatio set positions and size
        labelAspectRatio.setBounds(10,210,100,25);
        comboxAspectRatio.setBounds(90,210,50,25);
        //Field Resolution set positions and size
        labelResolution.setBounds(10,240,100,25);
        comboxResolution.setBounds(90,240,100,25);
        //Field Video Codec set positions and size
        labelVideoCodec.setBounds(10,270,100,25);
        comboxVideoCodec.setBounds(90,270,60,25);
        //Field Audio Codec set positions and size
        labelAudioCodec.setBounds(10,300,100,25);
        comboxAudioCodec.setBounds(90,300,60,25);
        //field buttonSearch set positions and size
        buttonSearch.setBounds(50, 600, 200, 30);
        // add components to frame and make them visible
        this.add(title);
        this.add(buttonPath);
        this.add(boxPath);
        this.add(titleFileName);
        this.add(boxFileName);
        this.add(buttonSearch);
        this.add(labelDuration);
        this.add(labelDurationFrom);
        this.add(labelDurationTo);
        this.add(boxDurationFrom);
        this.add(boxDurationTo);
        this.add(labelFileExt);
        this.add(boxFileExt);
        this.add(labelFrameRate);
        this.add(comboxFrameRate);
        this.add(labelAspectRatio);
        this.add(comboxAspectRatio);
        this.add(labelResolution);
        this.add(comboxResolution);
        this.add(labelVideoCodec);
        this.add(comboxVideoCodec);
        this.add(labelAudioCodec);
        this.add(comboxAudioCodec);
        this.setVisible(true);
    }
    /**
     * Getter of the search button
     * @return the button
     */
    public JButton getSearchButton(){
        return this.buttonSearch;
    }

    /**
     * Getter of the search path box
     * @return path string
     */
    public JTextField getBoxPath(){
        return this.boxPath;
    }

    /**
     * Getter for the file name box
     * @return file name string
     */
    public JTextField getBoxFileName(){
        return this.boxFileName;
    }

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
        boxPath.setText(fc.getSelectedFile().getAbsolutePath());
    }
}
