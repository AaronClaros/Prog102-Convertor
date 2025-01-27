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
import com.foundations.convertor.utils.MetadataFormats;
import com.foundations.convertor.utils.StyleUtils;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;
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
    //Label for combo box Video Codec
    private JLabel labelVideoCodec;
    //Combo Box for frame Video Codec;
    private JComboBox comboxVideoCodec;
    //Label for combo box Audio Codec
    private JLabel labelAudioCodec;
    //Combo Box for frame Video Codec;
    private JComboBox comboxAudioCodec;
    //this variable helps to set objects of the search panel
    private GridBagConstraints bagConstraints;
    //Label for audio
    private JLabel labelSearchType;
    //toggle to show the panel audio search
    private JToggleButton toggleAudio;
    //toggle to show the panel audio search
    private JToggleButton toggleVideo;
    //label of audio bit rate
    private JLabel labelAudioBitrate;
    //combo box audio bitrate
    private JComboBox comBoxbAudioBitRate;
    //label audio sample rate
    private JLabel labelAudioSampleRate;
    //combo box audio sample rate
    private JComboBox comBoxAudioSampleRate;
    //label audio bit depth
    private JLabel labelAudioBitDepth;
    //combo box audio bit depth
    private JComboBox comBoxAudioBitDepth;
    //label audio channels
    private JLabel labelAudioChannels;
    //combo box audio channels
    private JComboBox comBoxAudioChannels;

    /**
     * Constructor of father class JPanel
     */
    public SearchPanel() {
        super();
        // set the panel
        settings();
        // Initialize attributes or components
        initComp();
        //Initialize the panel to Audio Search
        //searchAudioPanel = new SearchAudioPanel();
        //searchAudioPanel.setBackground(new java.awt.Color(233, 233, 233));
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
    private void settingComponents(){
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
        //Added Icon to button
        ImageIcon searchIcon = StyleUtils.getInstance().createImageIcon("Search.png");
        buttonSearch = new JButton(searchIcon);
        //label file extension instance and text set
        labelFileExt = new JLabel("File Ext.:", SwingConstants.RIGHT);
        setColorLabel(labelFileExt);
        //supported extensions array
        String[] supported_ext = {"","mp4","avi","flv","mkv","mov","3gp"};
        //text field file extension instance
        boxFileExt = new JComboBox(supported_ext);
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
        //label audio code instance and text set
        labelAudioCodec = new JLabel("Audio Codec:", SwingConstants.RIGHT);
        setColorLabel(labelAudioCodec);
        //audio codecs array
        String[] audio_codecs = MetadataFormats.audioCodecs;
        //combo box audio codec instance and content set
        comboxAudioCodec = new JComboBox(audio_codecs);
        //set action listener to button set search path
        buttonPath.addActionListener(this);
        //label file name instance and text set
        labelSearchType = new JLabel("Search Type:", SwingConstants.RIGHT);
        setColorLabel(labelSearchType);
        //toggles to change search type
        toggleAudio = new JToggleButton("Search Audios");
        toggleVideo = new JToggleButton("Search Videos");
        //set toggles to change search type
        toggleAudio.setSelected(false);
        toggleVideo.setSelected(true);
        toggleVideo.setEnabled(false);
        //set listeners to change search type
        toggleAudio.addActionListener(this);
        toggleVideo.addActionListener(this);
        settingVideoComponents();
        settingAudioComponents();
    }

    /**
     * set all the Jpanel components variables
     */
    private void settingVideoComponents(){
        //VIDEO SEARCH COMPONENTS
        //label frame rate instance and text set
        labelFrameRate = new JLabel("Frame Rate:", SwingConstants.RIGHT);
        setColorLabel(labelFrameRate);
        //frame rates array
        String[] frame_rates = MetadataFormats.videoFrameRates;
        //combo box frame rate instance and content set
        comboxFrameRate = new JComboBox(frame_rates);
        //label aspect ratio instance and text set
        labelAspectRatio = new JLabel("Aspect Ratio:", SwingConstants.RIGHT);
        setColorLabel(labelAspectRatio);
        //aspect ratio array
        String[] asp_ratios = MetadataFormats.videoAspectRatios;
        //combo box aspect ratio instance and content set
        comboxAspectRatio = new JComboBox(asp_ratios);
        //label resolution instance and text set
        labelResolution = new JLabel("Resolution:", SwingConstants.RIGHT);
        setColorLabel(labelResolution);
        //resolution array
        String[] resolutions = MetadataFormats.videoResolutions;
        //combo box resolution instance and content set
        comboxResolution = new JComboBox(resolutions);
        //label video code instance and text set
        labelVideoCodec = new JLabel("Video Codec:", SwingConstants.RIGHT);
        setColorLabel(labelVideoCodec);
        //video codecs array
        String[] video_codecs = MetadataFormats.videoCodecs;
        //combo box video codec instance and content set
        comboxVideoCodec = new JComboBox(video_codecs);
    }

    /**
     * set audio Jpanel components variables
     */
    private void settingAudioComponents(){
        //AUDIO SEARCH COMPONENTS
        //Label for Bitrate
        labelAudioBitrate = new JLabel("Bitrate (Kbps)", SwingConstants.RIGHT);
        String[] bit_rate = MetadataFormats.audioBitRate;
        //combo box selection bit_rate instance
        comBoxbAudioBitRate = new JComboBox(bit_rate);
        //Label for Sample Rate
        labelAudioSampleRate = new JLabel("Sample Rate (Hz):", SwingConstants.RIGHT);
        //sample rate array
        String[] sample_rate = MetadataFormats.audioSampleRates;
        //combo box selection sample rate instance
        comBoxAudioSampleRate = new JComboBox(sample_rate);
        //Label for Size
        labelAudioBitDepth = new JLabel("Bit depth (bits):", SwingConstants.RIGHT);
        //size array
        String[] bitDepth = MetadataFormats.audioBitDepth;
        //combo box selection size instance
        comBoxAudioBitDepth = new JComboBox(bitDepth);
        //Label for text field path
        labelAudioChannels = new JLabel("Channels:", SwingConstants.RIGHT);
        //channels array
        String[] channels = MetadataFormats.audioChannels;
        //combo box selection channels instance
        comBoxAudioChannels = new JComboBox(channels);
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
        bagConstraints.gridy = 2;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelPath,bagConstraints);

        // setting constrains of boxpath
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 2;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(boxPath,bagConstraints);

        // setting constrains of button path
        bagConstraints.gridx = 6;
        bagConstraints.gridy = 2;
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
        bagConstraints.gridy = 3;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(titleFileName,bagConstraints);

        // setting constrains of boxFileName
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 3;
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
        bagConstraints.gridy = 4;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelDuration,bagConstraints);

        // setting constrains of boxDurationFrom
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 4;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 0.2;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(boxDurationFrom,bagConstraints);

        // setting constrains of labelDurationTo
        bagConstraints.gridx = 3;
        bagConstraints.gridy = 4;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelDurationTo,bagConstraints);

        // setting constrains of boxDurationTo
        bagConstraints.gridx = 5;
        bagConstraints.gridy = 4;
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
    private void initCompExtension(){

        // setting constrains of labelFileExt
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 5;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelFileExt,bagConstraints);

        // setting constrains of boxFileExt
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 5;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(boxFileExt,bagConstraints);
    }

    /**
     * remove components for Frame rate fields
     * @return layout grid axis "Y" position of Frame Rate components
     */
    private void updateCompExtension(){
        String[] data = {""};
        if (toggleAudio.isSelected()){
            data = MetadataFormats.audioExtensions;
        }
        else {
            data = MetadataFormats.videoExtensions;
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel( data );
        boxFileExt.setModel( model );
        this.revalidate();
        this.repaint();
    }

    /**
     * This method initialize the Frame rate fields
     */
    private void initCompFrame(int gridAxisY){
        // setting constrains of labelFrameRate
        bagConstraints.gridx = 0;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelFrameRate,bagConstraints);

        // setting constrains of comboxFrameRate
        bagConstraints.gridx = 2;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(comboxFrameRate,bagConstraints);
    }

    /**
     * remove components for Frame rate fields
     * @return layout grid axis "Y" position of Frame Rate components
     */
    private int disableCompFrame(){
        this.remove(labelFrameRate);
        this.remove(comboxFrameRate);
        return 6;
    }

    /**
     * This method initialize the aspect ratio fields
     * @return it return a JPanel object
     * to be added in the search panel
     */
    private void initCompAspect(int gridAxisY){

        // setting constrains of labelAspectRatio
        bagConstraints.gridx = 0;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelAspectRatio,bagConstraints);

        // setting constrains of comboxAspectRatio
        bagConstraints.gridx = 2;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(comboxAspectRatio,bagConstraints);
    }
    /**
     * remove components for aspect ratio fields
     * @return layout grid axis "Y" position of aspect ratio components
     */
    private int disableCompAspect(){
        this.remove(labelAspectRatio);
        this.remove(comboxAspectRatio);
        return 7;
    }

    /**
     * This method initialize the resolution fields
     * @return it return a JPanel object
     * to be added in the search panel
     */
    private void initCompResolution(int gridAxisY){

        // setting constrains of labelResolution
        bagConstraints.gridx = 0;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelResolution,bagConstraints);

        // setting constrains of combox Resolution
        bagConstraints.gridx = 2;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(comboxResolution,bagConstraints);
    }

    /**
     * remove components for the resolution fields
     * @return layout grid axis "Y" position of the resolution fields
     */
    private int disableCompResolution(){
        this.remove(labelResolution);
        this.remove(comboxResolution);
        return 8;
    }

    /**
     * This method initialize the video codec fields
     */
    private void initCompVideo(int gridAxisY){
        // setting constrains of labelVideoCodec
        bagConstraints.gridx = 0;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelVideoCodec,bagConstraints);

        // setting constrains of comboxVideoCodec
        bagConstraints.gridx = 2;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(comboxVideoCodec,bagConstraints);
    }

    /**
     * remove components for the video codec fields
     * @return layout grid axis "Y" position of video codec components
     */
    private int disableCompVideo(){
        this.remove(labelVideoCodec);
        this.remove(comboxVideoCodec);
        return 9;
    }

    /**
     * This method initialize the audio codec fields
     */
    private void initCompAudio(){
        // setting constrains of labelAudioCodec
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 10;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelAudioCodec,bagConstraints);

        // setting constrains of comboxAudioCodec
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 10;
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
        bagConstraints.gridy = 14;
        bagConstraints.gridwidth = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.weighty = 0.1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(buttonSearch,bagConstraints);
    }

    /**
     * This method initialize the search type components
     */
    private void initCompSearchType(){
        // setting constrains of labelSearchType
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;bagConstraints.weighty=0.0;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelSearchType,bagConstraints);

        // setting constrains of toggleAudio
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 1;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;bagConstraints.weighty=0.0;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(toggleAudio,bagConstraints);

        // setting constrains of toggleVideo
        bagConstraints.gridx = 4;
        bagConstraints.gridy = 1;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;bagConstraints.weighty=0.0;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(toggleVideo,bagConstraints);
    }

    /**
     * set grid layout constraints and add audio sample rate components to panel
     * @param gridAxisY axis Y position on grid layout
     */
    private void initCompSampleRate(int gridAxisY){

        // setting constrains of label bit rate
        bagConstraints.gridx = 0;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelAudioSampleRate,bagConstraints);

        // setting constrains of combo bit rate
        bagConstraints.gridx = 2;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(comBoxAudioSampleRate,bagConstraints);
    }

    /**
     * remove audio sample rate components from panel
     * @return axis Y position on grid layout
     */
    private int disableCompSampleRate(){
        this.remove(labelAudioSampleRate);
        this.remove(comBoxAudioSampleRate);
        return 6;
    }

    /**
     * set grid layout constraints and add audio bit depth components to panel
     * @param gridAxisY axis Y position on grid layout
     */
    private void initCompBitDepth(int gridAxisY){

        // setting constrains of label bit rate
        bagConstraints.gridx = 0;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelAudioBitDepth,bagConstraints);

        // setting constrains of combo bit rate
        bagConstraints.gridx = 2;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(comBoxAudioBitDepth,bagConstraints);
    }

    /**
     * remove audio bit depth components from panel
     * @return axis Y position on grid layout
     */
    private int disableCompBitDepth(){
        this.remove(labelAudioBitDepth);
        this.remove(comBoxAudioBitDepth);
        return 7;
    }

    /**
     * set grid layout constraints and add audio bit rate components to panel
     * @param gridAxisY axis Y position on grid layout
     */
    private void initCompBitRate(int gridAxisY){

        // setting constrains of label bit rate
        bagConstraints.gridx = 0;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelAudioBitrate,bagConstraints);

        // setting constrains of combo bit rate
        bagConstraints.gridx = 2;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(comBoxbAudioBitRate,bagConstraints);
    }

    /**
     * remove audio bit rate components from panel
     * @return axis Y position on grid layout
     */
    private int disableCompBitRate(){
        this.remove(labelAudioBitrate);
        this.remove(comBoxbAudioBitRate);
        return 8;
    }

    /**
     * set grid layout constraints and add audio channel components to panel
     * @param gridAxisY axis Y position on grid layout
     */
    private void initCompChannels(int gridAxisY){

        // setting constrains of label bit rate
        bagConstraints.gridx = 0;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(labelAudioChannels,bagConstraints);

        // setting constrains of combo bit rate
        bagConstraints.gridx = 2;
        bagConstraints.gridy = gridAxisY;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(comBoxAudioChannels,bagConstraints);
    }

    /**
     * remove audio channel components from panel
     * @return axis Y position on grid layout
     */
    private int disableCompChannels(){
        this.remove(labelAudioChannels);
        this.remove(comBoxAudioChannels);
        return 9;
    }


    /**
     * Initialize components
     */
    private void initComp() {
        settingComponents();
        initCompTitle();
        initCompSearchP();
        initCompFileName();
        initCompDuration();
        initCompExtension();
        initCompFrame(6);
        initCompAspect(7);
        initCompResolution(8);
        initCompVideo(9);
        initCompAudio();
        initCompBtnSearch();
        initCompSearchType();
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
        this.repaint();
        //this.add(labelPath);
    }

    /**
     * Set path to default once the search starts
     */
    public void setPathRequiredDefault(){
        this.labelPath.setForeground(Color.darkGray);
    }

    //public SearchAudioPanel getSearchAudioPanel(){
    //    return searchAudioPanel;
    //}

    /**
     * Setting Color to label
     * @param jLabel
     */
    private void setColorLabel(JLabel jLabel){
        jLabel.setBackground(new java.awt.Color(59, 59, 61));
    }

    /**
     * getter for toggle audio component
     * @return toggle audio object
     */
    public JToggleButton getToggleAudio() {
        return toggleAudio;
    }

    /**
     * getter for toggle video component
     * @return toggle video object
     */
    public JToggleButton getToggleVideo() {
        return toggleVideo;
    }

    /**
     * getter for combo box audio bit rate component
     * @return combo box audio bit rate object
     */
    public JComboBox getComBoxbAudioBitRate() {
        return comBoxbAudioBitRate;
    }

    /**
     * getter for combo box audio sample rate component
     * @return combo box audio sample rate object
     */
    public JComboBox getComBoxAudioSampleRate() {
        return comBoxAudioSampleRate;
    }

    /**
     * getter for combo box audio bit depth component
     * @return combo box audio bit depth object
     */
    public JComboBox getComBoxAudioBitDepth() {
        return comBoxAudioBitDepth;
    }

    /**
     * getter for combo box audio channels component
     * @return combo box audio channels object
     */
    public JComboBox getComBoxAudioChannels() {
        return comBoxAudioChannels;
    }

    /**
     * change component fields on grid layout to search audio
     */
    private void showSearchAudioComponents(){
        initCompSampleRate( disableCompFrame() );
        initCompBitDepth( disableCompAspect() );
        initCompBitRate( disableCompResolution() );
        initCompChannels( disableCompVideo() );
        updateCompExtension();
        this.revalidate();
        this.repaint();
    }

    /**
     * change component fields on grid layout to search video
     */
    private void showSearchVideoComponents(){
        initCompFrame( disableCompSampleRate() );
        initCompAspect( disableCompBitDepth() );
        initCompResolution( disableCompBitRate() );
        initCompVideo( disableCompChannels() );
        updateCompExtension();
        this.revalidate();
        this.repaint();
    }

    /**
     * Obtain path for Search
     * @param e event of path button choosing directory
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == buttonPath) {
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
        else if ( src == toggleAudio){
            if (toggleAudio.isSelected()){
                //show search audio components when toggle audio is selected
                toggleVideo.setSelected(!toggleAudio.isSelected());
                toggleAudio.setEnabled(false);
                toggleVideo.setEnabled(true);
                showSearchAudioComponents();
            }
        }else if ( src == toggleVideo){
            if (toggleVideo.isSelected()){
                //show search video components when toggle video is selected
                toggleAudio.setSelected(!toggleVideo.isSelected());
                toggleVideo.setEnabled(false);
                toggleAudio.setEnabled(true);
                showSearchVideoComponents();
            }
        }
    }
}
