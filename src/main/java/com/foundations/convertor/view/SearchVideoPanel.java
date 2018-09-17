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
 * @authors Angelica Lopez - AWT-[01].
 * @version 0.1
 */
import com.foundations.convertor.utils.LoggerManager;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

public class SearchVideoPanel extends JPanel {

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
  private GridBagConstraints bagConstraints;
  private SearchPanel searchPanel;
  private ButtonSearchPanel btnSearchPanel;

  /**
   * Constructor of father class JPanel
   */
  public SearchVideoPanel() {
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

    //label extension and text set
    labelFileExt = new JLabel("Extensión:", SwingConstants.RIGHT);
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

    //label frame rate instance and text set
    labelFrameRate = new JLabel("Frame Rate:", SwingConstants.RIGHT);
    setColorLabel(labelFrameRate);

    //frame rates array
    String[] frame_rates = {"","24","25","29","29.7","30","60"};

    //combo box frame rate instance and content set
    comboxFrameRate = new JComboBox(frame_rates);

    //label aspect ratio instance and text set
    labelAspectRatio = new JLabel("Aspect Ratio:", SwingConstants.RIGHT);
    setColorLabel(labelAspectRatio);

    //aspect ratio array
    String[] asp_ratios = {"","16:9","16:10","0:1","4:3","40:23"};

    //combo box aspect ratio instance and content set
    comboxAspectRatio = new JComboBox(asp_ratios);

    //label resolution instance and text set
    labelResolution = new JLabel("Resolution:", SwingConstants.RIGHT);
    setColorLabel(labelResolution);

    //resolution array
    String[] resolutions = {"","1920X1080","1280X720","640X480","640X368","480X270","320X240","256X240","176X144"};

    //combo box resolution instance and content set
    comboxResolution = new JComboBox(resolutions);

    //label video code instance and text set
    labelVideoCodec = new JLabel("Video Codec:", SwingConstants.RIGHT);
    setColorLabel(labelVideoCodec);

    //video codecs array
    String[] video_codecs = {"","h264","h263","indeo4","mpeg4","flv","avi"};

    //combo box video codec instance and content set
    comboxVideoCodec = new JComboBox(video_codecs);

    //label audio code instance and text set
    labelAudioCodec = new JLabel("Audio Codec:", SwingConstants.RIGHT);
    setColorLabel(labelAudioCodec);

    //audio codecs array
    String[] audio_codecs = {"","MP3","WMA","OGG","VIDEO"};

    //combo box audio codec instance and content set
    comboxAudioCodec = new JComboBox(audio_codecs);
  }

  /**
   *  Add the option visible of search panel.
   */
  private void initNewSearchPanel(){

    searchPanel = new SearchPanel();
    LoggerManager.getLogger().Log( "Into add new Panel search", "INFO");
    bagConstraints.gridx = 0;
    bagConstraints.gridy = 0;
    bagConstraints.gridwidth = 4;
    bagConstraints.gridheight = 1;
    bagConstraints.fill = GridBagConstraints.HORIZONTAL;
    bagConstraints.insets = new Insets(5,5,5,5);
    this.add(searchPanel,bagConstraints);
    searchPanel.setVisible(true);

    LoggerManager.getLogger().Log( "New panel added", "INFO");
    searchPanel.revalidate();
    searchPanel.repaint();
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

  private void initCompButtonSearch(){
    btnSearchPanel = new ButtonSearchPanel();
    LoggerManager.getLogger().Log( "Into add button search", "INFO");
    // setting constrains of label channel
    bagConstraints.gridx = 2;
    bagConstraints.gridy = 10;
    bagConstraints.gridwidth = 2;
    bagConstraints.gridheight = 1;
    bagConstraints.fill = GridBagConstraints.HORIZONTAL;
    bagConstraints.insets = new Insets(5,5,5,5);
    this.add(btnSearchPanel,bagConstraints);

    btnSearchPanel.setVisible(true);

    LoggerManager.getLogger().Log( "Button search added", "INFO");
    btnSearchPanel.revalidate();
    btnSearchPanel.repaint();
  }

  /**
   * Initialize components
   */
  private void initComp() {
    initNewSearchPanel();
    initCompFields();
    initCompExtention();
    initCompFrame();
    initCompAspect();
    initCompResolution();
    initCompVideo();
    initCompAudio();
    initCompButtonSearch();
    // set visible the search panel
    this.setVisible(true);
  }

  /**
   * Setting Color to label
   * @param jLabel
   */
  private void setColorLabel(JLabel jLabel){
    jLabel.setBackground(new java.awt.Color(59, 59, 61));
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

  public JComboBox getBoxFileExt() {
    return boxFileExt;
  }
}
