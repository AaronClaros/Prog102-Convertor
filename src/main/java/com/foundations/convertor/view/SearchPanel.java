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
        //Panel title
        title= new JLabel("Search Criteria");
        //button path instance and title set
        buttonPath = new JButton("Path");
        //text field path instance
        boxPath = new JTextField();
        //text field file name
        boxFileName = new JTextField();
        //label file name instance and text set
        titleFileName= new JLabel("File Name");
        //button search instance and text set
        buttonSearch = new JButton("Search");
        //label file extension instance and text set
        labelFileExt = new JLabel("File Ext.");
        //text field file extension instance
        boxFileExt = new JTextField();
        //label duration instance and text set
        labelDuration = new JLabel("Duration");
        //label "duration from" instance and text set
        labelDurationFrom = new JLabel("From");
        //label "duration to" instance and text set
        labelDurationTo = new JLabel("To");
        //label frame rate instance and text set
        labelFrameRate = new JLabel("Frame Rate");
        //frame rates array
        String[] frame_rates = {"","24","29","30","60"};
        //combo box frame rate instance and content set
        comboxFrameRate = new JComboBox(frame_rates);
        //box "duration from" instance and text format set
        boxDurationFrom = new JFormattedTextField(createFormat("###:##:##"));
        //set default duration time for duration from
        boxDurationFrom.setValue("000:00:00");
        //box "duration to" instance and text format set
        boxDurationTo = new JFormattedTextField(createFormat("###:##:##"));
        //set default duration time for duration to
        boxDurationTo.setValue("000:00:00");
        //label aspect ratio instance and text set
        labelAspectRatio = new JLabel("Aspect Ratio");
        //aspect ratio array
        String[] asp_ratios = {"","16:9","16:10","4:3"};
        //combo box aspect ratio instance and content set
        comboxAspectRatio = new JComboBox(asp_ratios);
        //label resolution instance and text set
        labelResolution = new JLabel("Resolution");
        //resolution array
        String[] resolutions = {"","720x480","1080x720","1440x1080"};
        //combo box resolution instance and content set
        comboxResolution = new JComboBox(resolutions);
        //label video code instance and text set
        labelVideoCodec = new JLabel("Video Codec");
        //video codecs array
        String[] video_codecs = {"","H264","MP4","AVI"};
        //combo box video codec instance and content set
        comboxVideoCodec = new JComboBox(video_codecs);
        //label audio code instance and text set
        labelAudioCodec = new JLabel("Audio Codec");
        //audio codecs array
        String[] audio_codecs = {"","MP3","WMA","OGG"};
        //combo box audio codec instance and content set
        comboxAudioCodec = new JComboBox(audio_codecs);

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
    public JTextField getBoxFileExt() {
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
        return this.boxDurationFrom;
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
     * Getter for the Video Codec combo box
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
        boxPath.setText(fc.getSelectedFile().getAbsolutePath());
    }
}
