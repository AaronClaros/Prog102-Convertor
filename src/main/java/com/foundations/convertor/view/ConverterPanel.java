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

import com.foundations.convertor.utils.LoggerManager;
import com.foundations.convertor.utils.StyleUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.EventListener;


/**
 *  JPanel Object that contains conversion parameters
 *
 * @authors Kevin Herrera, Kevin Sanchez - AWT-[01].
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */

public class ConverterPanel extends JPanel implements ActionListener, EventListener {
    // label for title panel
    private JLabel labelTitle;
    // label for input path
    private JLabel labelInputPath;
    // text field for input path
    private JTextField tFieldInputPath;
    // text field for new name
    private JTextField txtName;
    // label for output path
    private JLabel labelOutPath;
    // text field for output path
    private JTextField tFieldOutPath;
    // button for output path
    private JButton buttonOutPath;
    // label for resolution field
    private JLabel labelResolution;
    // label for Frame Rate field
    private JLabel labelFrameRate;
    // label for video Codec field
    private JLabel labelVideoCodec;
    // label for Audio Codec field
    private JLabel labelAudioCodec;
    // label for Format field
    private JLabel labelFormat;
    // label for new name field
    private JLabel labelName;
    // comboBox to chose new Resolution
    private JComboBox cmbResolution;
    // comboBox to chose new Frame Rate
    private JComboBox cmbFrameRate;
    // comboBox to chose new video Codec
    private JComboBox cmbVideoCodec;
    // comboBox to chose new Audio Codec
    private JComboBox cmbAudioCodec;
    // comboBox to chose new Format
    private JComboBox cmbFormat;
    // button to convert the video
    private JButton buttonConvert;
    // this variable helps to set objects of
    // the search panel
    private GridBagConstraints bagConstraints;

    //Label for audio
    private JLabel labelAudio;
    //Check box to show the panel audio search
    private JCheckBox checkBoxAudio;
    //The panel to add
    private SearchAudioPanel searchAudioPanel;

    /**
     * constructor of father class JPanel
     */
    public ConverterPanel() {
        super();
        // set the panel
        settings();
        // Initialize attributes or components
        initComp();
        //Initialize Search Audio Panel
        searchAudioPanel = new SearchAudioPanel();
        searchAudioPanel.setBackground(new java.awt.Color(254, 233, 52));
    }

    /**
     * configure components
     */
    private void settings() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(UIManager.getColor("Panel.background"));
        // type of layout for the panel
        this.setLayout(new GridBagLayout());
        bagConstraints = new GridBagConstraints();
    }

    /**
     * this method create the instance of the fields
     * for the converter panel
     */
    private void initCompFields(){
        // instance label title and set text
        labelTitle = new JLabel("Conversion parameters", SwingConstants.CENTER);
        setColorLabel(labelTitle);

        //instance labelInputPath and set text
        labelInputPath = new JLabel("File to Convert:",SwingConstants.RIGHT);
        setColorLabel(labelInputPath);

        //instance textField for input path
        tFieldInputPath = new JTextField(15);
        tFieldInputPath.setEnabled(false);

        //instance label output path and set text
        labelOutPath = new JLabel("Output Path:",SwingConstants.RIGHT);
        setColorLabel(labelOutPath);

        //instance textField for OutputPath
        tFieldOutPath = new JTextField(15);
        tFieldOutPath.setEnabled(false);

        //instance button for output path and set text
        //Added Icon to button
        ImageIcon openIcon = StyleUtils.getInstance().createImageIcon("Open_16.png");
        buttonOutPath = new JButton(openIcon);

        // instance label resolution and set text
        labelResolution = new JLabel("New Resolution:",SwingConstants.RIGHT);
        setColorLabel(labelResolution);

        // instance label frame rate and set text
        labelFrameRate = new JLabel("New Frame Ratio:",SwingConstants.RIGHT);
        setColorLabel(labelFrameRate);

        // instance label video codec and set text
        labelVideoCodec = new JLabel("New Video Codec:",SwingConstants.RIGHT);
        setColorLabel(labelVideoCodec);

        // instance label audio codec and set text
        labelAudioCodec = new JLabel("New Audio Codec:",SwingConstants.RIGHT);
        setColorLabel(labelAudioCodec);

        // instance label format and set text
        labelFormat = new JLabel("New Format:",SwingConstants.RIGHT);
        setColorLabel(labelFormat);

        // instance label new name
        labelName = new JLabel("New Name:",SwingConstants.RIGHT);
        setColorLabel(labelName);

        txtName = new JTextField(15);

        // addition of options to the resolution selector
        String[] resolOptions = {"","1920X1080","1280X720","640X480","640X368","480X270","320X240","256X240","176X144"};
        cmbResolution = new JComboBox(resolOptions);

        // addition of options to the frame rate selector
        String[] frameRateOptions = {"","24","25","29","29.7","30","60"};
        cmbFrameRate = new JComboBox(frameRateOptions);

        // addition of options to the video codec selector
        String[] videoCodOptions = {"","h264","h263","indeo4","mpeg4","flv","avi"};
        cmbVideoCodec = new JComboBox(videoCodOptions);

        // addition of options to the audio codec selector
        String[] audioCodOptions = {"","MP3","WMA","OGG","VIDEO"};
        cmbAudioCodec = new JComboBox(audioCodOptions);

        // addition of options to the format selector
        String[] formatOptions = {"","mp4","avi","flv","mkv","mov","3gp"};
        cmbFormat = new JComboBox(formatOptions);

        // set text to the convertor button
        //Added Icon to button
        ImageIcon convertIcon = StyleUtils.getInstance().createImageIcon("Grasshopper_32.png");
        buttonConvert = new JButton("Convert",convertIcon);

        //label file name instance and text set
        labelAudio= new JLabel("Audio Convert Criteria:", SwingConstants.RIGHT);
        setColorLabel(labelAudio);

        //check box audio
        checkBoxAudio = new JCheckBox();
        checkBoxAudio.setSelected(false);
        checkBoxAudio.addActionListener(this);
    }
    /**
     * This method initialize the tittle
     */
    private void initCompTitle(){

        // setting constrains of title
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        bagConstraints.gridwidth = 10;
        bagConstraints.gridheight = 1;
        bagConstraints.insets = new Insets(5,0,30,0);
        bagConstraints.fill = GridBagConstraints.BOTH;
        this.add(labelTitle,bagConstraints);
    }

    /**
     * This method initialize the fields of
     * input path and output path
     */
    private void initCompPaths(){

        // setting constrains of labelInputPath
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelInputPath,bagConstraints);

        // setting constrains of tFieldInputPath
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 1;
        bagConstraints.gridwidth = 8;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(tFieldInputPath,bagConstraints);

        // setting constrains of label OutPath
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 2;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelOutPath,bagConstraints);

        // setting constrains of tFieldOutPath
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 2;
        bagConstraints.gridwidth = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(tFieldOutPath,bagConstraints);

        // setting constrains of buttonOutPath
        bagConstraints.gridx = 5;
        bagConstraints.gridy = 2;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 0.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(buttonOutPath,bagConstraints);

        // setting constrains of labelName
        bagConstraints.gridx = 6;
        bagConstraints.gridy = 2;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelName,bagConstraints);

        // setting constrains of txtName
        bagConstraints.gridx = 7;
        bagConstraints.gridy = 2;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(txtName,bagConstraints);
    }

    /**
     * this method creates the congigurations to the left panel
     * including resolution, frame rate, video codec
     * @return a Jpanel object to be added to the main panel
     */
    private void initCompLeft(){
        // setting constrains of labelResolution
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 3;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelResolution,bagConstraints);

        // setting constrains of cmbResolution
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 3;
        bagConstraints.gridwidth = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(cmbResolution,bagConstraints);

        // setting constrains of labelFrameRate
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 4;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelFrameRate,bagConstraints);

        // setting constrains of cmbFrameRate
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 4;
        bagConstraints.gridwidth = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(cmbFrameRate,bagConstraints);

        // setting constrains of labelVideoCodec
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 5;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelVideoCodec,bagConstraints);

        // setting constrains of cmbVideoCodec
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 5;
        bagConstraints.gridwidth = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(cmbVideoCodec,bagConstraints);
    }

    /**
     * this method creates the congigurations to the middle panel
     * including videcodec, Audio codec, format
     * @return a Jpanel object to be added to the main panel
     */
    private void iniCompRight(){

        // setting constrains of labelAudioCodec
        bagConstraints.gridx = 6;
        bagConstraints.gridy = 3;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelAudioCodec,bagConstraints);

        // setting constrains of cmbAudioCodec
        bagConstraints.gridx = 7;
        bagConstraints.gridy = 3;
        bagConstraints.gridwidth = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(cmbAudioCodec,bagConstraints);

        // setting constrains of labelFormat
        bagConstraints.gridx = 6;
        bagConstraints.gridy = 4;
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(labelFormat,bagConstraints);

        // setting constrains of cmbFormat
        bagConstraints.gridx = 7;
        bagConstraints.gridy = 4;
        bagConstraints.gridwidth = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(cmbFormat,bagConstraints);
    }

    /**
     * this method creates the congigurations to the right panel
     * including button convert
     * @return a Jpanel object to be added to the main panel
     */
    private void iniCompButton(){

        // setting constrains of buttonConvert
        bagConstraints.gridx = 7;
        bagConstraints.gridy = 6;
        bagConstraints.gridwidth = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 0.0;
        bagConstraints.insets = new Insets(5,5,5,5);
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(buttonConvert,bagConstraints);
    }

    /**
     * This method initialize the search audio
     */
    private void initCompAudioCheck(){
      // setting constrains of labelAudioCodec
      bagConstraints.gridx = 0;
      bagConstraints.gridy = 6;
      bagConstraints.gridwidth = 2;
      bagConstraints.gridheight = 1;bagConstraints.weighty=0.0;
      bagConstraints.fill = GridBagConstraints.HORIZONTAL;
      bagConstraints.insets = new Insets(5,5,5,5);
      this.add(labelAudio,bagConstraints);

      // setting constrains of comboxAudioCodec
      bagConstraints.gridx = 1;
      bagConstraints.gridy = 6;
      bagConstraints.gridwidth = 2;
      bagConstraints.gridheight = 1;bagConstraints.weighty=0.0;
      bagConstraints.fill = GridBagConstraints.HORIZONTAL;
      bagConstraints.insets = new Insets(5,5,5,5);
      this.add(checkBoxAudio,bagConstraints);
    }

    /**
     * Initialize components
     */
    private void initComp() {
        initCompFields();
        initCompTitle();
        initCompPaths();
        initCompLeft();
        iniCompRight();
        iniCompButton();
        initCompAudioCheck();
        this.setVisible(true);
        buttonOutPath.addActionListener(this);
    }

    /**
     * Getter method for retrieve the new name
     * @return text field new name
     */
    public JTextField getTxtName(){
        return txtName;
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
     * getter method for button out path
     * @return out path button
     */
    public JButton getButtonOutPath() {
        return buttonOutPath;
    }

    /**
     * Getter of the convert button
     * @return the search button object
     */
    public JButton getConvertButton(){
        return this.buttonConvert;
    }

    /**
     * Obtain path for button out path
     * @param e event of path button choosing directory
     */
    @Override
    public void actionPerformed(ActionEvent e) {

      Object src = e.getSource();

      if (src == buttonOutPath) {
        //File chooser for path
        JFileChooser fc = new JFileChooser();
        // start at application current directory
        fc.setCurrentDirectory(new java.io.File("."));
        //Only can select directories
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
          File yourFolder = fc.getSelectedFile();
          //Copy selected path to the text box
          tFieldOutPath.setText(fc.getSelectedFile().getAbsolutePath());
        }
      }
      else{
        JCheckBox checkBox = (JCheckBox)e.getSource();
        if(checkBox == checkBoxAudio && checkBox.isSelected())
        {
          searchAudioPanel.setVisible(true);
          addNewSearchAudioPanel();
          searchAudioPanel.revalidate();
          searchAudioPanel.repaint();
          LoggerManager.getLogger().Log( "Audio panel visible", "INFO");
        }
        else{
          searchAudioPanel.setVisible(false);
          searchAudioPanel.revalidate();
          searchAudioPanel.repaint();
          searchAudioPanel.cleanFieldsToAudioSearch();
          LoggerManager.getLogger().Log( "Disabled the check box audio", "INFO");
        }
      }
    }

    /**
     * this method reset the fields for converter
    */
    public void cleanFields(){
        this.tFieldInputPath.setText("");
        this.tFieldOutPath.setText("");
        this.txtName.setText("");
        this.cmbResolution.setSelectedItem("");
        this.cmbFrameRate.setSelectedItem("");
        this.cmbVideoCodec.setSelectedItem("");
        this.cmbAudioCodec.setSelectedItem("");
        this.cmbFormat.setSelectedItem("");
    }

    /**
     *  Add the option visible of audio panel.
     */
    private void addNewSearchAudioPanel(){
      LoggerManager.getLogger().Log( "Into add new Panel search audio", "INFO");
      bagConstraints.gridx = 3;
      bagConstraints.gridy = 6;
      bagConstraints.gridwidth = 4;
      bagConstraints.gridheight = 1;
      bagConstraints.fill = GridBagConstraints.HORIZONTAL;
      bagConstraints.insets = new Insets(5,5,5,5);
      searchAudioPanel.setVisible(true);
      this.add(searchAudioPanel,bagConstraints);
      LoggerManager.getLogger().Log( "New audio panel added", "INFO");
    }

    /**
     * Setting Color to label
     * @param jLabel
     */
    private void setColorLabel(JLabel jLabel){
        jLabel.setBackground(new java.awt.Color(91, 78, 21));
    }
}
