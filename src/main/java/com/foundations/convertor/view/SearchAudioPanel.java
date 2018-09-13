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
 *  Panel for the audio search criteria
 *
 * @authors Angelica Lopez - AWT-[01].
 * @version 0.1
 */

import javax.swing.*;
import java.awt.*;

public class SearchAudioPanel extends JPanel {
    // this variable helps to set objects of
    // the search panel for audio
    private JLabel lbRate;
    private JLabel lbSize;
    private JLabel lbBitrate;
    private JLabel lbChannel;
    private JComboBox cbRate;
    private JComboBox cbSize;
    private JComboBox cbBitRate;
    private JComboBox cbChannel;
    private GridBagConstraints bagConstraints;

    public SearchAudioPanel(){
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
        //Label for Sample Rate
        lbRate = new JLabel("Sample Rate:", SwingConstants.RIGHT);

        //Label for Size
        lbSize = new JLabel("Size:", SwingConstants.RIGHT);

        //Label for Bitrate
        lbBitrate = new JLabel("Bitrate", SwingConstants.RIGHT);

        //Label for text field path
        lbChannel = new JLabel("Channels:", SwingConstants.RIGHT);

        //audio codec array
        String[] audio_codec = {"","mp2","mp3"};

        //sample rate array
        String[] sample_rate = {"","48000 Hz"};

        //combo box selection sample rate instance
        cbRate = new JComboBox(sample_rate);

        //size array
        String[] size = {"","16 bit"};

        //combo box selection size instance
        cbSize = new JComboBox(size);

        //BitRate array
        String[] bit_rate = {"","224 kbps"};

        //combo box selection bit_rate instance
        cbBitRate = new JComboBox(bit_rate);

        //channels array
        String[] channels = {"","Stereo"};

        //combo box selection channels instance
        cbChannel = new JComboBox(channels);
    }

    /**
     * This method initialize the Sample Rate
     */
    private void initCompSampleRate(){

        // setting constrains of label sample rate
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 2;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(lbRate,bagConstraints);

        // setting constrains of combo rate
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 2;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(cbRate,bagConstraints);

        // setting constrains of label size
        bagConstraints.gridx = 4;
        bagConstraints.gridy = 2;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(lbSize,bagConstraints);

        // setting constrains of combo size
        bagConstraints.gridx = 6;
        bagConstraints.gridy = 2;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(cbSize,bagConstraints);

    }

    /**
     * This method initialize the bit rate fields
     */
    private void initCompBitRate(){

        // setting constrains of label bit rate
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 3;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(lbBitrate,bagConstraints);

        // setting constrains of combo bit rate
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 3;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(cbBitRate,bagConstraints);
    }

    /**
     * This method initialize the channels fields
     */
    private void initCompChannels(){

        // setting constrains of label channel
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 4;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(lbChannel,bagConstraints);

        // setting constrains of combo channel
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 4;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(cbChannel,bagConstraints);
    }

    /**
     * Initialize components
     */
    private void initComp() {
        initCompFields();
        initCompSampleRate();
        initCompBitRate();
        initCompChannels();
    }

    /**
     * Getter for the file extension box
     * @return filer extension box object
     */
    public JComboBox getcbRate() {
        return this.cbRate;
    }

    /**
     * Getter for the file extension box
     * @return filer extension box object
     */
    public JComboBox getcbSize() {
        return this.cbSize;
    }

    /**
     * Getter for the file extension box
     * @return filer extension box object
     */
    public JComboBox getcbBitRate() {
        return this.cbBitRate;
    }

    /**
     * Getter for the file extension box
     * @return filer extension box object
     */
    public JComboBox getcbChannel() {
        return this.cbChannel;
    }

    /**
     * this method reset the fields for panel Audio Search
     */
    public void cleanFieldsToAudioSearch(){
      this.cbRate.setSelectedItem("");
      this.cbSize.setSelectedItem("");
      this.cbBitRate.setSelectedItem("");
      this.cbChannel.setSelectedItem("");
    }
}
