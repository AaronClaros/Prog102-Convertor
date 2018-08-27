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
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.EventListener;


public class SearchPanel extends JPanel implements ActionListener, EventListener{

    private JLabel title;               //Panel title:Sear Criteria
    private JTextField boxPath;         // box for path insertion criteria
    private JButton buttonPath;         // button with browse action
    private JLabel titleFileName;       //Title File name
    private JTextField boxFileName;     // box for file name criteria
    private JButton buttonSearch;       // button with search action

    public SearchPanel() {
        super();                    // constructor of father class JPanel
        initComp();                 // Initialize attributes or components
        settings();                 // set the panel
    }

    private void settings() {
        this.setBounds(5,5,300,919);                   // Panel size
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.lightGray);
        this.setLayout(null);                                   // layout not used, to position components
    }

    private void initComp() {
        // initialize components
        title= new JLabel();
        buttonPath = new JButton();
        boxPath = new JTextField();
        boxFileName = new JTextField();
        titleFileName= new JLabel();
        buttonSearch = new JButton();
        // configure components
        title.setBounds(10,20,100,20);
        title.setText("Search Criteria");
        buttonPath.setText("Path");    // Insert a message to be displayed
        buttonPath.setBounds(220, 50, 60, 25);   // text position and size(x, y, width, height)
        boxPath.setBounds(10, 50, 200, 25);   // box position and size (x, y, width, height)
        titleFileName.setText("File Name");
        titleFileName.setBounds(10,90,80,25);
        boxFileName.setBounds(90, 90, 200, 25);   // box position and size (x, y, width, height)
        buttonSearch.setText("Search");   // Text for button
        buttonSearch.setBounds(50, 800, 200, 30);  // button position and size (x, y, width, height)
        buttonPath.addActionListener(this);      // box has action and the action is inside this class
        // add components to frame and make them visible
        this.add(title);
        this.add(buttonPath);
        this.add(boxPath);
        this.add(titleFileName);
        this.add(boxFileName);
        this.add(buttonSearch);
        this.setVisible(true);
    }

    public JButton getSearchButton(){        //getter of the search button
        return this.buttonSearch;
    }
    public JTextField getBoxPath(){        //getter of the search path box
        return this.boxPath;
    }
    public JTextField getBoxFileName(){     //getter for file name
        return this.boxFileName;
    }
    @Override
    public void actionPerformed(ActionEvent e) {        //Obtain path for Search
        //File chooser for path
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new java.io.File(".")); // start at application current directory
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  //Only can select directories
        int returnVal = fc.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File yourFolder = fc.getSelectedFile();
        }
        boxPath.setText(fc.getSelectedFile().getAbsolutePath());    //Copy selected path to the text box
    }
}
