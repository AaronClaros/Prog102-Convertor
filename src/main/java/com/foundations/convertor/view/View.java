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
 *  View class for UI
 *
 * @authors Adrian Rojas, Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
import com.foundations.convertor.utils.LoggerManager;

import com.foundations.convertor.utils.StyleUtils;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.FontUIResource;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * main Frame for UI Convertor project
 */
public class View extends JFrame {  //
    // search criteria selection panel
    private SearchPanel sPanel;
    //  search list display panel
    private SearchListPanel slPanel;
    // conversion parameters panel
    private ConverterPanel convPanel;
    // Util class helper to button search
    private ButtonSearchPanel btnSearch;
    //search criteria audio panel
    private SearchAudioPanel sAudioPanel;
    //search criteria video panel
    private SearchVideoPanel sVideoPanel;
    // constructor of father class JFrame
    public Dimension screenSize;
    // this variable helps to set objects of
    // the frame
    private GridBagConstraints bagConstraints;

    /**
     * Constructor method
     */
    public View() {
        super();
        // set the frame properties
        settings();
        // Initialize attributes or components
        initComp();
        LoggerManager.getLogger().Log("Starting View","INFO");
        //Added Icon to button
        ImageIcon openIcon = StyleUtils.getInstance().createImageIcon("Grasshopper_32.png");
        this.setIconImage(openIcon.getImage());
    }

    /**
     * Set frame properties
     */
    private void settings() {
        // Project tittle
        this.setTitle("Convertor V 0.1");
        //Set screen size dimensions
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Frame size and Screen dimensions
        this.setSize(1080, 780-50);
        // Frame centered
        this.setLocationRelativeTo(null);
        // Frame resizable
        this.setResizable(true);
        // All processes are terminated once the frame is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // type of layout for the frame
        this.setLayout(new GridBagLayout());
        bagConstraints = new GridBagConstraints();
    }

    /**
     * Initialize components
     */
    private void initComp() {
        //Instance frame with search criteria
        sPanel = new SearchPanel();
        sPanel.setBackground(new java.awt.Color(184, 187, 192));

        //Instance frame with search criteria
        sAudioPanel = new SearchAudioPanel();
        sAudioPanel.setBackground(new java.awt.Color(184, 187, 192));

        //Instance panel with search video criteria
        sVideoPanel = new SearchVideoPanel();
        sVideoPanel.setBackground(new java.awt.Color(184, 187, 192));

        //Instance frame with result table panel
        slPanel = new SearchListPanel();

        //Instance frame with converter panel
        convPanel = new ConverterPanel();
        convPanel.setBackground(new java.awt.Color(229, 208, 47));

        // setting constrains of spanel
        // position where it starts
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;

        // number of columns and rows used
        bagConstraints.gridwidth = 1;
        bagConstraints.gridheight = 2;

        // stretching values
        bagConstraints.weightx = 0.8;
        bagConstraints.weighty = 1.0;

        // way it will change its size
        bagConstraints.fill = GridBagConstraints.BOTH;
        LoggerManager.getLogger().Log("Starting Search Panel","INFO");
        //Added Icon to button
        ImageIcon audioIcon = StyleUtils.getInstance().createImageIcon("Music_16px.png");
        //Added Icon to button
        ImageIcon videoIcon = StyleUtils.getInstance().createImageIcon("Movie_16px.png");
        JTabbedPane tab = new JTabbedPane();
        //Adding
        this.add(tab);
        //Add Tabs
        tab.addTab("Audio",audioIcon, sAudioPanel);
        tab.addTab("Video",videoIcon, sVideoPanel);
        //this.add(sPanel,bagConstraints);
        this.add(tab,bagConstraints);

        // setting constrains of slpanel
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 0;
        bagConstraints.gridwidth = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.weighty = 1.0;
        bagConstraints.fill = GridBagConstraints.BOTH;
        LoggerManager.getLogger().Log("Starting Search List Panel","INFO");
        this.add(slPanel,bagConstraints);

        // setting constrains of convPanel
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 1;
        bagConstraints.gridwidth = 3;
        bagConstraints.gridheight = 1;
        bagConstraints.weightx = 1.0;
        bagConstraints.weighty = 0.0;
        bagConstraints.fill = GridBagConstraints.BOTH;
        LoggerManager.getLogger().Log("Starting Convertor Panel","INFO");
        this.add(convPanel,bagConstraints);

        //Display the window
        this.pack();
        this.setVisible(true);
    }

    /**
     * Get panel for search criteria panel
     * @return Search criteria object
     */
    public SearchPanel getSPanel () { return sPanel; }

    /**
     * Get panel for search list result panel
     * @return Table for results object
     */
    public SearchListPanel getSLPanel ()
    {
        return slPanel;
    }

    /**
     * Get panel for search components
     * @return Panel convert
     */
    public ConverterPanel getConvPanel() {return convPanel;}

    /**
     * Get panel for button search component
     * @return Panel button caontains
     */
    public ButtonSearchPanel getBtnSearchPanel() {return btnSearch;}

    /**
     * Get panel for audio panel
     * @return Panel
     */
    public SearchAudioPanel getAudioSearchPanel() {return sAudioPanel;}

    /**
     * Get panel for video search panel
     * @return Panel
     */
    public SearchVideoPanel getVideoSearchPanel() {return sVideoPanel;}

    /**
     * Method to display message box with error message
     * @param error String with the error to be displayed
     */
    public void errorMessage(String error){
        showMessageDialog(null, error, "Error", JOptionPane.INFORMATION_MESSAGE);
        LoggerManager.getLogger().Log( error, "INFO");
    }
}
