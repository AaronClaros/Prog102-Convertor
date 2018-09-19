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
 *  Panel for the Convertor search list result
 *
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */
import com.foundations.convertor.utils.LoggerManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * UI: Search list results table
 */
public class SearchListPanel extends JPanel {
    // Results table to be displayed based on the search criteria
    private JTable resultsTable;
    private DefaultTableModel model;
    private String[] columnNames = {"File Name","File Path","Duration","Extension","Frame Rate","Aspect Ratio",
            "Resolution","Video Codec","Audio Codec","Size"};
    private JScrollPane scrollPane;

    /**
     * constructor of father class JPanel
     */
    public SearchListPanel() {
        super();
        // Initialize attributes or components
        initComp();
        // set the panel
        settings();
    }

    /**
     * configure components
     */
    private void settings() {
        //set border for search list panel
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //set background color
        this.setBackground(UIManager.getColor ( "Panel.background" ));
    }

    /**
     * Initialize components
     */
    private void initComp() {
        //instance default table model
        model = new DefaultTableModel(columnNames,1){
            public boolean isCellEditable(int rowIndex, int mColIndex) {
                return false;
            }
        };
        //instance results table
        resultsTable = new JTable(model);
        resultsTable.setBackground(new java.awt.Color(233, 233, 233));
        JTableHeader header = resultsTable.getTableHeader();
        resultsTable.getTableHeader().setReorderingAllowed(false);
        //Header Style
        header.setBackground(new java.awt.Color(255,204,51));
        header.setFont(new Font("Default",Font.BOLD,12));
        //instance scroll panel container for results table
        scrollPane = new JScrollPane(resultsTable);
        //Add action listener for double click over table
        resultsTable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if (e.getClickCount() == 2){
                    LoggerManager.getLogger().Log("Did Double Click to play video", "INFO");
                    playVideo();
                }
            }
        } );

        //set layout of panel as Border Layout
        this.setLayout(new BorderLayout());
        //add components to panel and center to layout
        this.add(scrollPane, BorderLayout.CENTER);
        //make panel components visible
        this.setVisible(true);
    }

    /**
     * Return the table result
     * @return result table
     */
    public JTable getTable(){return  resultsTable;}

    /**
     * Get the search results table as a DefaultTableModel object
     * @return return the content table object
     */
    public DefaultTableModel getResultsTable(){
        return this.model;
    }
    /**
     * Method to call the video player
     */
    public void playVideo() {

        //Set table to get data
        String selectedData = null;
        resultsTable.setCellSelectionEnabled(true);
        int selectedRow = resultsTable.getSelectedRow();
        resultsTable.getSelectedRow();
        selectedData = (String) resultsTable.getValueAt(selectedRow,1);

        //Only creates the video player frame if the path for the cell selection is not null
        if(selectedData!=null) {
            LoggerManager.getLogger().Log( "Selected row to play: " + selectedData, "INFO");
            MultimediaPlayer player = MultimediaPlayer.getInstance();
            try {
                player.start(selectedData);
            } catch (Exception e) {
                LoggerManager.getLogger().Log( e.getMessage(), "Error");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, resultsTable.getValueAt(selectedRow,0)+": Extension not supported", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
