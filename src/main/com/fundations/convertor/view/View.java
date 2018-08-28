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

package main.com.fundations.convertor.view;

/**
 *  View class for UI
 *
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * main Frame for UI Convertor project
 */
public class View extends JFrame {  //
    // search criteria selection panel
    private SearchPanel sPanel;
    // search list display panel
    private SearchListPanel slPanel;
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
         this.setSize(screenSize.width, screenSize.height-50);
        // Frame centered
        this.setLocationRelativeTo(null);
        // layout not used, to position components
        this.setLayout(null);
        // Frame resizable
        this.setResizable(false);
        // All processes are terminated once the frame is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Initialize components
     */
    private void initComp() {
        //Instance frame with search criteria
        sPanel = new SearchPanel(this.getWidth(),this.getHeight());
        //Instance frame with result table panel
        slPanel = new SearchListPanel(this.getWidth(),this.getHeight());
        //add Search criteria selection panel to main frame
        this.add(sPanel);
        //add Search list results panel to main frame
        this.add(slPanel);
        //Display the window
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
