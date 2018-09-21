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

import com.foundations.convertor.utils.MetadataFormats;

import javax.swing.*;
import java.awt.*;

public class SearchAudioPanel extends JPanel {
    // this variable helps to set objects of
    // the search panel for audio
    private JLabel lbSampleRate;
    private JLabel lbBitDepth;
    private JLabel lbBitrate;
    private JLabel lbChannels;
    private JComboBox cbSampleRate;
    private JComboBox cbBitDepth;
    private JComboBox cbBitRate;
    private JComboBox cbChannels;
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
        lbSampleRate = new JLabel("Sample Rate (Hz):", SwingConstants.RIGHT);

        //Label for Size
        lbBitDepth = new JLabel("Bit depth (bits):", SwingConstants.RIGHT);

        //Label for Bitrate
        lbBitrate = new JLabel("Bitrate (Kbps)", SwingConstants.RIGHT);

        //Label for text field path
        lbChannels = new JLabel("Channels:", SwingConstants.RIGHT);

        //combo box selection sample rate instance
        cbSampleRate = new JComboBox(MetadataFormats.audioSampleRates);

        //combo box selection size instance
        cbBitDepth = new JComboBox(MetadataFormats.audioBitDepth);

        //combo box selection bit_rate instance
        cbBitRate = new JComboBox(MetadataFormats.audioBitRate);

        //combo box selection channels instance
        cbChannels = new JComboBox(MetadataFormats.audioChannels);
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
        this.add(lbSampleRate,bagConstraints);

        // setting constrains of combo rate
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 2;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(cbSampleRate,bagConstraints);

    }
    /**
     * This method initialize the Bit Depth
     */
    private void initCompBitDepth(){
        // setting constrains of label bit Depth
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 3;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(lbBitDepth,bagConstraints);

        // setting constrains of combo size
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 3;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(cbBitDepth,bagConstraints);

    }

    /**
     * This method initialize the bit rate fields
     */
    private void initCompBitRate(){

        // setting constrains of label bit rate
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 4;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(lbBitrate,bagConstraints);

        // setting constrains of combo bit rate
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 4;
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
        bagConstraints.gridy = 5;
        bagConstraints.gridwidth = 2;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(lbChannels,bagConstraints);

        // setting constrains of combo channel
        bagConstraints.gridx = 2;
        bagConstraints.gridy = 5;
        bagConstraints.gridwidth = 4;
        bagConstraints.gridheight = 1;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.insets = new Insets(5,5,5,5);
        this.add(cbChannels,bagConstraints);
    }

    /**
     * Initialize components
     */
    private void initComp() {
        initCompFields();
        initCompSampleRate();
        initCompBitDepth();
        initCompBitRate();
        initCompChannels();
    }

    /**
     * Getter for the file extension box
     * @return filer extension box object
     */
    public JComboBox getcbSampleRate() {
        return this.cbSampleRate;
    }

    /**
     * Getter for the file extension box
     * @return filer extension box object
     */
    public JComboBox getcbSize() {
        return this.cbBitDepth;
    }

    /**
     * Getter for the file extension box
     * @return filer extension cbox object
     */
    public JComboBox getcbBitRate() {
        return this.cbBitRate;
    }

    /**
     * Getter for the file channels box
     * @return channels cbox object
     */
    public JComboBox getcbChannels() {
        return this.cbChannels;
    }

    /**
     * Getter for the bit depth
     * @return cb cit depth
     */
    public JComboBox getcbBitDepth(){
        return this.cbBitDepth;
    }
    /**
     * this method reset the fields for panel Audio Search
     */
    public void cleanFieldsToAudioSearch(){
      this.cbSampleRate.setSelectedItem("");
      this.cbBitDepth.setSelectedItem("");
      this.cbBitRate.setSelectedItem("");
      this.cbChannels.setSelectedItem("");
    }
}
