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
 *  Panel for the Convertor search list result
 *
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import java.awt.Color;

public class SearchListPanel extends JPanel {

    private JTable resultsTable;         // Results table to be displayed based on the search criteria
    private String[] columnNames = {"File Name", "File Path", "Extension", "Frame Rate", "Duration"};
    private Object [][] data = {{"Name", "Path", "Extension", "Frame Rate", "Duration"}};
    private JScrollPane scrollPane;

    public SearchListPanel() {
        super();                    // constructor of father class JPanel
        initComp();                 // Initialize attributes or components
        settings();                 // set the panel
    }

    private void settings() {                                                 //Set the frame and ots components
        this.setBounds(310,5,960,519);                   // Panel size and location
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.gray);
        this.setLayout(null);                                   // layout not used, to position components

    }

    private void initComp() {                                       // initialize components
        resultsTable = new JTable(data,columnNames);               // configure components
        resultsTable.setBounds(5,5,900,500);
        scrollPane = new JScrollPane(resultsTable);
        scrollPane.setBounds(5,5,905,500);
        // add components to frame and make them visible
        this.add(scrollPane);
        this.setVisible(true);
    }

    public JTable getResultsTable(){    //getter for the search results
        return this.resultsTable;
    }



}
