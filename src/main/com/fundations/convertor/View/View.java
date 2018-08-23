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

package main.com.fundations.convertor.View;
/**
 *  View class for UI
 *
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */

import javax.swing.*;

public class View extends JFrame {

    private SearchPanel sPanel;            // search criteria selection panel
    private SearchListPanel slPanel;            // search list display panel

    public View() {
        super();                    // constructor of father class JFrame
        settings();                 // set the frame
        initComp();                 // Initialize attributes or components
    }

    private void settings() {
        this.setTitle("Convertor V 0.1");                       // Project tittle
        this.setSize(1280, 924);                   // Frame size
        this.setLocationRelativeTo(null);                       // Frame centered
        this.setLayout(null);                                   // layout not used, to position components
        this.setResizable(false);                               // Frame not resizable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // All processes are terminated once the frame is closed

    }

    private void initComp() {
        // initialize components
        sPanel = new SearchPanel();
        slPanel = new SearchListPanel();
        this.add(sPanel);
        this.add(slPanel);

        //Display the window

        this.setVisible(true);


    }

    public void showMessage(String m)
    {
        JOptionPane.showMessageDialog(this,m);
    }
}
