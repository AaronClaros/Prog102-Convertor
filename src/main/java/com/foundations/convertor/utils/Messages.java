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
 * @authors Angelica
 * @version 0.1
 */

package com.foundations.convertor.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Helper messages added icons customized
 */
public class Messages {
    //Frame hold the message
    Frame frame = new Frame();
    //Ico fields
    ImageIcon cancelIcon = StyleUtils.getInstance().createImageIcon("Cancel_26px.png");
    ImageIcon errorIcon = StyleUtils.getInstance().createImageIcon("Error_26px.png");
    ImageIcon warningIcon = StyleUtils.getInstance().createImageIcon("Important_26px.png");
    ImageIcon helpIcon = StyleUtils.getInstance().createImageIcon("Help_26px.png");
    ImageIcon infoIcon = StyleUtils.getInstance().createImageIcon("Info_26px.png");
    ImageIcon mainIcon = StyleUtils.getInstance().createImageIcon("Grasshopper_32.png");

    private static final Messages instance = new Messages();

    // Singleton
    private Messages() {
    }

    public static Messages getInstance() {
        return instance;
    }

    /**
     * Create dialog to question
     * @param message
     * @param title
     */
    public void questionMessage(String message, String title){
        createDialog(message,title,helpIcon);
    }

    /**
     * Create dialog to information
     * @param message
     * @param title
     */
    public void informationMessage(String message, String title){
        createDialog(message,title,infoIcon);
    }

    /**
     * Create dialog to warning
     * @param message
     * @param title
     */
    public void warningMessage(String message, String title){
        createDialog(message,title,warningIcon);
    }

    /**
     * Create dialog to error
     * @param message
     * @param title
     */
    public void errorMessage(String message, String title){
        createDialog(message,title,errorIcon);
    }

    /**
     * Create dialog cancel
     * @param message
     * @param title
     */
    public void cancelMessage(String message, String title){
        createDialog(message,title,cancelIcon);
    }

    /**
     * Create a dialog in general
     * @param message
     * @param title
     * @param imageIcon
     */
    private void createDialog(String message, String title,ImageIcon imageIcon){
        JOptionPane jp = new JOptionPane();
        jp.setIcon(imageIcon);
        jp.setMessage(message);
        JDialog dialog = jp.createDialog(null, title);
        ((Frame)dialog.getParent()).setIconImage(((ImageIcon)mainIcon).getImage());
        dialog.setResizable(true);
        dialog.setVisible(true);
    }
}
