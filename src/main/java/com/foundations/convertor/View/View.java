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

package com.foundations.convertor.View;
/**
 *  View class for UI
 *
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */

import javax.swing.JFrame;


public class View extends JFrame {

    private SearchPanel sPanel;            // search criteria selection panel
    private SearchListPanel slPanel;            // search list display panel

    public View() {
        super();                    // constructor of father class JFrame
        settings();                 // set the frame
        initComp();                 // Initialize attributes or components
    }

    private void settings() {                                   //Set frames
        this.setTitle("Convertor V 0.1");                       // Project tittle
        this.setSize(1280, 924);                   // Frame size
        this.setLocationRelativeTo(null);                       // Frame centered
        this.setLayout(null);                                   // layout not used, to position components
        this.setResizable(false);                               // Frame not resizable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // All processes are terminated once the frame is closed
    }

    private void initComp() {               // initialize components
        sPanel = new SearchPanel();         //Instanciar el frame con los criterios de busqueda
        slPanel = new SearchListPanel();    //Instanciar el frame con la tabla del resultado de busqueda
        this.add(sPanel);
        this.add(slPanel);
        this.setVisible(true);        //Display the window
    }
    public SearchPanel getSPanel ()
    {
        return sPanel;
    }
    public SearchListPanel getSLPanel ()
    {
        return slPanel;
    }
}
