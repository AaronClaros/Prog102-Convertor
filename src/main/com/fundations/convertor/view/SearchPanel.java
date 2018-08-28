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
 *  Panel for the convertor search criteria
 *
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.EventListener;

/**
 * UI: Search panel with the criteria options for the search
 */
public class SearchPanel extends JPanel implements ActionListener, EventListener{
    //Panel title:Search Criteria
    private JLabel title;
    // box for path insertion criteria
    private JTextField boxPath;
    // button with browse action
    private JButton buttonPath;
    //Title File name
    private JLabel titleFileName;
    // box for file name criteria
    private JTextField boxFileName;
    // button with search action
    private JButton buttonSearch;

    /**
     * Constructor of father class JPanel
     * @param fWidth main frame width
     * @param fHeight main frame height
     */
    public SearchPanel(int fWidth, int fHeight) {
        super();
        // Initialize attributes or components
        initComp();
        // set the panel
        settings(fWidth,fHeight);
    }

    /**
     * Search panel settings
     * @param w main frame width
     * @param h main frame height
     */
    private void settings(int w,int h) {
        // Panel size: main frame/4 for width
        this.setBounds(5,5,w/4-10,h-40);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.lightGray);
        // layout not used, to position components
        this.setLayout(null);
    }

    /**
     * Initialize components
     */
    private void initComp() {
        title= new JLabel();
        buttonPath = new JButton();
        boxPath = new JTextField();
        boxFileName = new JTextField();
        titleFileName= new JLabel();
        buttonSearch = new JButton();
        // Panel title
        title.setText("Search Criteria");
        //button title
        buttonPath.setText("Path");
        //Field title
        titleFileName.setText("File Name");
        // Text for button
        buttonSearch.setText("Search");
        // box is listening for the path button to fill
        buttonPath.addActionListener(this);
        //Elements positions and sizes
        title.setBounds(10,20,100,20);
        buttonPath.setBounds(220, 50, 60, 25);
        boxPath.setBounds(10, 50, 200, 25);
        buttonSearch.setBounds(50, 800, 200, 30);
        titleFileName.setBounds(10,90,80,25);
        boxFileName.setBounds(90, 90, 200, 25);
        // add components to frame and make them visible
        this.add(title);
        this.add(buttonPath);
        this.add(boxPath);
        this.add(titleFileName);
        this.add(boxFileName);
        this.add(buttonSearch);
        this.setVisible(true);
    }

    /**
     * Getter of the search button
     * @return the button
     */
    public JButton getSearchButton(){
        return this.buttonSearch;
    }

    /**
     * Getter of the search path box
     * @return path string
     */
    public JTextField getBoxPath(){
        return this.boxPath;
    }

    /**
     * Getter for the file name box
     * @return file name string
     */
    public JTextField getBoxFileName(){
        return this.boxFileName;
    }

    /**
     * Obtain path for Search
     * @param e event of path button choosing directory
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //File chooser for path
        JFileChooser fc = new JFileChooser();
        // start at application current directory
        fc.setCurrentDirectory(new java.io.File("."));
        //Only can select directories
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File yourFolder = fc.getSelectedFile();
        }
        //Copy selected path to the text box
        boxPath.setText(fc.getSelectedFile().getAbsolutePath());
    }
}
