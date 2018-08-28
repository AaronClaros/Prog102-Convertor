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
 *  Panel for the Convertor search list result
 *
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * UI: Search list results table
 */
public class SearchListPanel extends JPanel {
    // Results table to be displayed based on the search criteria
    private JTable resultsTable;
    private DefaultTableModel model;
    private String[] columnNames = {"File Name", "File Path", "Extension", "Frame Rate", "Duration",
                                    "Aspect Ratio","Dimension","Video Codec","Audio Codec"};
    private JScrollPane scrollPane;

    /**
     * // constructor of father class JPanel
     * @param fWidth main frame width
     * @param fHeight main frame height
     */
    public SearchListPanel(int fWidth, int fHeight) {
        super();
        // Initialize attributes or components
        initComp();
        // set the panel
        settings(fWidth,fHeight);
    }

    /**
     * configure components
     * @param w main frame width
     * @param h main frame height
     */
    private void settings(int w, int h) {
        // Panel size and location
        this.setSize(3*w/4-20,(h-40)/2);
        this.setBounds(w/4+5,5,3*w/4-20,(h-40)/2);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.gray);
        // layout not used, to position components

    }

    /**
     * Initialize components
     */
    private void initComp() {
        model = new DefaultTableModel(columnNames,1);
        resultsTable = new JTable(model);
        scrollPane = new JScrollPane(resultsTable);
        //fill the frame with the table
        this.setLayout(new CardLayout());
        // add components to frame and make them visible
        this.add(scrollPane);
        this.setVisible(true);
    }

    /**
     * Get the search results table as a DefaultTableModel object
     * @return return the content table object
     */
    public DefaultTableModel getResultsTable(){
        return this.model;
    }



}
