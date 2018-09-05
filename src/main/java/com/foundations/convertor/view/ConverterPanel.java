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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/**
 *  JPanel Object that contains conversion parameters
 *
 * @authors Kevin Herrera, Kevin Sanchez - AWT-[01].
 * @version 0.1
 */

public class ConverterPanel extends JPanel {
    // label for title panel
    private JLabel labelPanelTitle;
    // label for input path
    private JLabel labelInputPath;
    // text field for input path
    private JTextField tFieldInputPath;
    // button for get table selection
    private JButton buttonGetTSelection;
    // label for output path
    private JLabel labelOutPath;
    // text field for output path
    private JTextField tFieldOutPath;
    // button for output path
    private JButton buttonOutPath;
    // label for resolution field
    private JLabel labelResolution;
    // label for Aspect Ratio field
    private JLabel labelAspectRatio;
    // label for Frame Rate field
    private JLabel labelFrameRate;
    // label for Video Codec field
    private JLabel labelVideoCodec;
    // label for Audio Codec field
    private JLabel labelAudioCodec;
    // label for Format field
    private JLabel labelFormat;
    // comboBox to chose new Resolution
    private JComboBox cmbResolution;
    // comboBox to chose new Aspect Ratio
    private JComboBox cmbAspectRation;
    // comboBox to chose new Frame Rate
    private JComboBox cmbFrameRate;
    // comboBox to chose new Video Codec
    private JComboBox cmbVideoCodec;
    // comboBox to chose new Audio Codec
    private JComboBox cmbAudioCodec;
    // comboBox to chose new Format
    private JComboBox cmbFormat;
    // button to convert the video
    private JButton buttonConvert;

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

        this.setBackground(UIManager.getColor("Panel.background"));
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
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelTitle.setMinimumSize(new Dimension(300, 300));
        panelTitle.setMaximumSize(new Dimension(1000, 300));
        //add label labelTitle to panel
        panelTitle.add(labelPanelTitle);

        //instance labelInputPath and set text
        labelInputPath = new JLabel("Input Path");
        //instance textField for input path
        tFieldInputPath = new JTextField(15);
        //instance button get table selection and set text
        buttonGetTSelection = new JButton("Set Selection");
        JPanel panelInputPath = new JPanel();
        panelInputPath.setLayout(new FlowLayout(FlowLayout.LEFT));
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
        panelOutputPath.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelOutputPath.add(labelOutPath);
        panelOutputPath.add(tFieldOutPath);
        panelOutputPath.add(buttonOutPath);

        // this panel allows to improve the view in the input and output
        // path selectors
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.X_AXIS));
        panelInputPath.setMinimumSize(new Dimension(300, 300));
        panelInputPath.setMaximumSize(new Dimension(1000, 300));

        panelOutputPath.setMinimumSize(new Dimension(300, 300));
        panelOutputPath.setMaximumSize(new Dimension(1000, 300));

        panelCenter.add(panelInputPath);
        panelCenter.add(panelOutputPath);

        // instance label resolution and set text
        labelResolution = new JLabel("New Resolution");
        // instance label aspect ratio and set text
        labelAspectRatio = new JLabel("New Aspec Ratio");
        // instance label frame rate and set text
        labelFrameRate = new JLabel("New Frame Ratio");
        // instance label video codec and set text
        labelVideoCodec = new JLabel("New Video Codec");
        // instance label audio codec and set text
        labelAudioCodec = new JLabel("New Audio Codec");
        // instance label format and set text
        labelFormat = new JLabel("New Format");
        // addition of options to the resolution selector
        String[] resolOptions = {"","720x480","1080x720","1440x1080"};
        cmbResolution = new JComboBox(resolOptions);
        // addition of options to the aspect ratio selector
        String[] aspRatioOptions = {"","16:9","16:10","4:3"};
        cmbAspectRation = new JComboBox(aspRatioOptions);
        // disable the comboBox of aspect Ratio making it dependent
        // of resolution comboBox
        cmbAspectRation.setEnabled(false);
        // addition of options to the frame rate selector
        String[] frameRateOptions = {"","24","29","30","60"};
        cmbFrameRate = new JComboBox(frameRateOptions);
        // addition of options to the video codec selector
        String[] videoCodOptions = {"","H264","MP4","AVI"};
        cmbVideoCodec = new JComboBox(videoCodOptions);
        // addition of options to the audio codec selector
        String[] audioCodOptions = {"","MP3","WMA","OGG"};
        cmbAudioCodec = new JComboBox(audioCodOptions);
        // addition of options to the format selector
        String[] formatOptions = {"","mp4","flv"};
        cmbFormat = new JComboBox(formatOptions);
        // set text to the convertor button
        buttonConvert = new JButton("Convert");

        // add a item listener to create the dependency
        // between resolution and aspect ratio
        cmbResolution.addItemListener(new ItemListener() {
            /**
             * this anonymous method allows to change the content
             * of  aspect ratio comboBox according resolution
             * comboBox changes
             * @param e is the event of the Resolution comboBox
             * */
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int index = cmbResolution.getSelectedIndex();
                    cmbAspectRation.setSelectedIndex(index);
                }
            }
        });
        // this panel allows to manage the fields of resolution
        JPanel panelResol = new JPanel();
        panelResol.add(labelResolution);
        panelResol.add(cmbResolution);
        // this panel allows to manage the fields of aspect ratio
        JPanel panelAspRatio = new JPanel();
        panelAspRatio.add(labelAspectRatio);
        panelAspRatio.add(cmbAspectRation);
        // this panel allows to manage the fields of frame rate
        JPanel panelFrameRate = new JPanel();
        panelFrameRate.add(labelFrameRate);
        panelFrameRate.add(cmbFrameRate);
        // this panel allows to manage the fields of video codec
        JPanel panelVideoCod = new JPanel();
        panelVideoCod.add(labelVideoCodec);
        panelVideoCod.add(cmbVideoCodec);
        // this panel allows to manage the fields of audio codec
        JPanel panelAudioCod = new JPanel();
        panelAudioCod.add(labelAudioCodec);
        panelAudioCod.add(cmbAudioCodec);
        // this panel allows to manage the fields of format()
        JPanel panelFormat = new JPanel();
        panelFormat.add(labelFormat);
        panelFormat.add(cmbFormat);
        // this panel allows to manage all fields above and
        // the converter button
        JPanel panelAttrib = new JPanel();
        panelAttrib.add(panelResol);
        panelAttrib.add(panelAspRatio);
        panelAttrib.add(panelFrameRate);
        panelAttrib.add(panelVideoCod);
        panelAttrib.add(panelAudioCod);
        panelAttrib.add(panelFormat);
        panelAttrib.add(buttonConvert);
        panelAttrib.setLayout(new BoxLayout(panelAttrib,BoxLayout.Y_AXIS));

        this.add(panelTitle);
        this.add(panelCenter);
        this.add(panelAttrib);
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

    /**
     * getter method for comboBox Resolution
     * @return Resolution comboBox
    */
    public JComboBox getCmbResolution() {
        return cmbResolution;
    }

    /**
     * getter method for comboBox aspect ratio
     * @return aspect ratio comboBox
     */
    public JComboBox getCmbAspectRation() {
        return cmbAspectRation;
    }

    /**
     * getter method for comboBox frame rate
     * @return frame rate comboBox
     */
    public JComboBox getCmbFrameRate() {
        return cmbFrameRate;
    }

    /**
     * getter method for comboBox video codec
     * @return video codec comboBox
     */
    public JComboBox getCmbVideoCodec() {
        return cmbVideoCodec;
    }

    /**
     * getter method for comboBox audio codec
     * @return audio codec comboBox
     */
    public JComboBox getCmbAudioCodec() {
        return cmbAudioCodec;
    }

    /**
     * getter method for comboBox format
     * @return format comboBox
     */
    public JComboBox getCmbFormat() {
        return cmbFormat;
    }

    /**
     * getter method for button getSelection
     * @return getSelection button
     */
    public JButton getButtonGetTSelection() {
        return buttonGetTSelection;
    }

    /**
     * getter method for button out path
     * @return out path button
     */
    public JButton getButtonOutPath() {
        return buttonOutPath;
    }
}
