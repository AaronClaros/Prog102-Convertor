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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class View extends JFrame implements ActionListener {

    private JLabel text;            //non editable label
    private JTextField box;        // box for data insertion
    private JButton button;          // button with action

    public View() {
        super();                    // constructor of father class JFrame
        settings();                 // set the frame
        initComp();                 // Initialize attributes or components
    }

    private void settings() {
        this.setTitle("Convertor V 0.1");                       // Project tittle
        this.setSize(900, 900);                   // Frame size
        this.setLocationRelativeTo(null);                       // Frame centered
        this.setLayout(null);                                   // layout not used, to position components
        this.setResizable(false);                               // Frame not resizable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // All processes are terminated once the frame is closed

    }

    private void initComp() {
        // initialize components
        text = new JLabel();
        box = new JTextField();
        button = new JButton();
        // configure components
        text.setText("Insert message");    // Insert a message to be displayed
        text.setBounds(50, 50, 100, 25);   // text position and size(x, y, width, height)
        box.setBounds(150, 50, 100, 25);   // box position and size (x, y, width, height)
        button.setText("Show message");   // Text for button
        button.setBounds(50, 100, 200, 30);  // button position and size (x, y, width, height)
        button.addActionListener(this);      // button has action and the action is inside this class
        // add components to frame and make them visible
        this.add(text);
        this.add(box);
        this.add(button);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = box.getText();                                 // get message from the box
        JOptionPane.showMessageDialog(this,message);    // show message (frame, message)
    }
}
