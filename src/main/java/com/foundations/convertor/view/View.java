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
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */
import javax.swing.*;
import java.awt.*;

/**
 * main Frame for UI Convertor project
 */
public class View extends JFrame {  //
    // search criteria selection panel
    private SearchPanel sPanel;
    // search list display panel
    private SearchListPanel slPanel;
    // conversion parameters panel
    private ConverterPanel convPanel;
    // constructor of father class JFrame
    public Dimension screenSize;
    public View() {
        super();
        // set the frame properties
        settings();
        // Initialize attributes or components
        initComp();
    }

    /**
     * Set frame properties
     */
    private void settings() {
        // Project tittle
        this.setTitle("Convertor V 0.1");
        //Set screensize dimensions
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Frame size and Screen dimensions
        this.setSize(1080, 780-50);
        // Frame centered
        this.setLocationRelativeTo(null);
        // Frame resizable
        this.setResizable(true);
        // All processes are terminated once the frame is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Initialize components
     */
    private void initComp() {
        //Instance frame with search criteria
        sPanel = new SearchPanel();
        //Instance frame with result table panel
        slPanel = new SearchListPanel();
        //Instance frame with converter panel
        convPanel = new ConverterPanel();
        //set layout for main frame
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
        //set search panel minimum an maximum dimensions
        sPanel.setMinimumSize(new Dimension(300, 600));
        sPanel.setMaximumSize(new Dimension(350, 600));
        //add search panel to main frame
        this.add(sPanel);
        //add a rigid area to separe seach panel from right container
        this.add(Box.createRigidArea(new Dimension(5,0)));
        //create a panel to contain SearchListPanel and ConverterPanel
        JPanel right_container = new JPanel();
        //set right_container layout
        right_container.setLayout(new BoxLayout(right_container, BoxLayout.Y_AXIS));
        //set search list panel minimum an maximum dimensions
        slPanel.setMinimumSize(new Dimension(300, 300));
        slPanel.setMaximumSize(new Dimension(1000, 300));
        //add search list panel for right_container
        right_container.add(slPanel);
        //set layout for converter panel
        convPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        //set converter panel minimum an maximum dimensions
        convPanel.setMinimumSize(new Dimension(500, 300));
        convPanel.setMaximumSize(new Dimension(1000, 300));
        //add converter panel to right_container
        right_container.add(convPanel);
        //add right_container to main frame
        this.add(right_container);
        //Display the window
        this.pack();
        this.setVisible(true);
    }

    /**
     * Get panel for search criteria panel
     * @return Search criteria object
     */
    public SearchPanel getSPanel ()
    {
        return sPanel;
    }

    /**
     * Get panel for search list result panel
     * @return Table for results object
     */
    public SearchListPanel getSLPanel ()
    {
        return slPanel;
    }
}
