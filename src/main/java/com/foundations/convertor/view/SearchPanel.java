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

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.BorderFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
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
     */
    public SearchPanel() {
        super();
        // Initialize attributes or components
        initComp();
        // set the panel
        settings();
    }

    /**
     * Search panel settings
     */
    private void settings() {
        //set panel layout as Box Layout
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //set border to panel
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //set background color of panel
        this.setBackground(UIManager.getColor ( "Panel.background" ));
    }

    /**
     * Initialize components
     */
    private void initComp() {
        //Panel labelTitle
        labelTitle = new JLabel("Search Criteria");
        //Label for text field path
        labelPath = new JLabel("Path:");
        //button path instance and labelTitle set
        buttonPath = new JButton("Open");
        //text field path instance
        boxPath = new JTextField(15);
        //text field file name
        boxFileName = new JTextField(10);
        //label file name instance and text set
        titleFileName= new JLabel("File Name:");
        //button search instance and text set
        buttonSearch = new JButton("Search");
        //label file extension instance and text set
        labelFileExt = new JLabel("File Ext.");
        //suportede extentions array
        String[] suported_ext = {"","mp4","flv"};
        //text field file extension instance
        boxFileExt = new JComboBox(suported_ext);
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
        boxDurationFrom = new JFormattedTextField(createFormat("##:##:##"));
        //set default duration time for duration from
        boxDurationFrom.setValue("00:00:00");
        //box "duration to" instance and text format set
        boxDurationTo = new JFormattedTextField(createFormat("##:##:##"));
        //set default duration time for duration to
        boxDurationTo.setValue("00:00:00");
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
        //set action listener to button set search path
        buttonPath.addActionListener(this);
        //      Setting title section
        //create panel container for title section
        JPanel panelTitle = new JPanel();
        //set layout for panel title
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        //add label labelTitle to panel
        panelTitle.add(labelTitle);
        //add panel labelTitle to search panel
        this.add(panelTitle);

        //      Setting path section
        //create panel container for path section
        JPanel panelPath = new JPanel();
        //set layout for panelPath
        panelPath.setLayout(new FlowLayout(FlowLayout.LEFT));
        //add components to panelPath
        panelPath.add(labelPath);
        panelPath.add(boxPath);
        panelPath.add(buttonPath);
        this.add(panelPath);

        //      Setting File Name section
        //create panel container for file name section
        JPanel panelFileName = new JPanel();
        //set layout for panelFileName
        panelFileName.setLayout(new FlowLayout(FlowLayout.LEADING));
        //add components to panelFileName
        panelFileName.add(titleFileName);
        panelFileName.add(boxFileName);
        this.add(panelFileName);

        //      Setting Duration section
        //create panel container for duration section
        JPanel panelDuration = new JPanel();
        //set layout for panelDuration
        panelDuration.setLayout(new FlowLayout(FlowLayout.LEADING));
        //add components to panelDuration
        panelDuration.add(labelDuration);
        panelDuration.add(labelDurationFrom);
        panelDuration.add(boxDurationFrom);
        panelDuration.add(labelDurationTo);
        panelDuration.add(boxDurationTo);
        //add panelDuration to search panel
        this.add(panelDuration);

        //      Setting File Extension section
        //create panel container for file extension section
        JPanel panelFileExt = new JPanel();
        //set layout for panelFileExt
        panelFileExt.setLayout(new FlowLayout(FlowLayout.LEADING));
        //add components to panelFileExt
        panelFileExt.add(labelFileExt);
        panelFileExt.add(boxFileExt);
        //add panelFileExt to search panel
        this.add(panelFileExt);

        //      Setting Frame Rate section
        //create panel for frame rate section
        JPanel panelFrameRate = new JPanel();
        //set layout for panelFrameRate
        panelFrameRate.setLayout(new FlowLayout(FlowLayout.LEADING));
        //add components to panelFrameRate
        panelFrameRate.add(labelFrameRate);
        panelFrameRate.add(comboxFrameRate);
        //add panelFrameRate to search panel
        this.add(panelFrameRate);

        //      Setting Aspect Ration section
        //create panel for aspect ratio section
        JPanel panelAspectRatio = new JPanel();
        //set layout for panelAspectRation
        panelAspectRatio.setLayout(new FlowLayout(FlowLayout.LEADING));
        //add components to panelAspectRatio
        panelAspectRatio.add(labelAspectRatio);
        panelAspectRatio.add(comboxAspectRatio);
        //add panelAspectRatio to search panel
        this.add(panelAspectRatio);

        //      Setting Resolution section
        //create panel for resolution section
        JPanel panelResolution = new JPanel();
        //set layout for panelResolution
        panelResolution.setLayout(new FlowLayout(FlowLayout.LEADING));
        //add components to panelResolution
        panelResolution.add(labelResolution);
        panelResolution.add(comboxResolution);
        //add panelResolution to search panel
        this.add(panelResolution);

        //      Setting Video Codec Section
        //create panel for video codec section
        JPanel panelVideoCodec = new JPanel();
        //set layout for panelVideoCodec
        panelVideoCodec.setLayout(new FlowLayout(FlowLayout.LEADING));
        //add components to panelVideoCodec
        panelVideoCodec.add(labelVideoCodec);
        panelVideoCodec.add(comboxVideoCodec);
        //add panelVideoCodec to search panel
        this.add(panelVideoCodec);

        //      Setting Audio Codec section
        //create panel for audio codec section
        JPanel panelAudioCodec = new JPanel();
        //set layout got panelAudioCodec
        panelAudioCodec.setLayout(new FlowLayout(FlowLayout.LEADING));
        //add components to panelAudioCodec
        panelAudioCodec.add(labelAudioCodec);
        panelAudioCodec.add(comboxAudioCodec);
        //add panelAudioCodec to search panel
        this.add(panelAudioCodec);

        //      Setting Search Button section
        //create panel for search panel section
        JPanel panelButtonSearch = new JPanel();
        //set layout for panelButtonSearch
        panelButtonSearch.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        //add components to panelButtonSearch
        panelButtonSearch.add(buttonSearch);
        //add panelButtonSearch  to search panel
        this.add(panelButtonSearch );
        //set visible the search panel
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
