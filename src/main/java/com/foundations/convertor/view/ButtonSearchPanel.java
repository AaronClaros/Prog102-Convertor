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
 *  Panel for the convertor search criteria
 *
 * @authors Angelica Lopez - AWT-[01].
 * @version 0.1
 */

import com.foundations.convertor.utils.StyleUtils;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class ButtonSearchPanel extends JPanel{

  // button with search action
  private JButton buttonSearch;
  // this variable helps to set objects of
  // the search panel
  private GridBagConstraints bagConstraints;

  /**
   * Constructor of father class JPanel
   */
  public ButtonSearchPanel() {
    super();
    // set the panel
    settings();
    // Initialize attributes or components
    initComp();
  }

  /**
   * Search panel settings
   */
  private void settings() {
    //set background color of panel
    this.setBackground(UIManager.getColor ( "Panel.background" ));
    // type of layout for the panel
    this.setLayout(new GridBagLayout());
    bagConstraints = new GridBagConstraints();
  }

  /**
   * This method initialize the search button fields
   */
  private void initCompBtnSearch(){

    // setting constrains of buttonSearch
    bagConstraints.gridx = 2;
    bagConstraints.gridy = 0;
    bagConstraints.gridwidth = 2;
    bagConstraints.gridheight = 1;
    bagConstraints.weightx = 1.0;
    bagConstraints.weighty = 0.1;
    bagConstraints.fill = GridBagConstraints.HORIZONTAL;
    //Added Icon to button
    ImageIcon searchIcon = StyleUtils.getInstance().createImageIcon("Search.png");
    buttonSearch = new JButton(searchIcon);
    this.add(buttonSearch,bagConstraints);
  }

  /**
   * Initialize components
   */
  private void initComp() {
    initCompBtnSearch();
    //initCompFields();
    // set visible the search panel
    this.setVisible(true);
  }

  /**
   * Getter of the search button
   * @return the search button object
   */
  public JButton getSearchButton(){
    return this.buttonSearch;
  }
}
