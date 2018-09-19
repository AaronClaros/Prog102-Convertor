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

    private static final Messages instance = new Messages();

    // Singleton
    private Messages() {
    }

    public static Messages getInstance() {
        return instance;
    }

    public void questionMessage(String message, String title){
        JOptionPane.showMessageDialog(frame,
                message,
                title,
                JOptionPane.QUESTION_MESSAGE,
                helpIcon);
    }

    public void informationMessage(String message, String title){
        JOptionPane.showMessageDialog(frame,
                message,
                title,
                JOptionPane.INFORMATION_MESSAGE,
                infoIcon);
    }

    public void warningMessage(String message, String title){
        //custom title, warning icon
        JOptionPane.showMessageDialog(frame,
                message,
                title,
                JOptionPane.WARNING_MESSAGE,
                warningIcon
                );
    }

    public void errorMessage(String message, String title){
        //custom title, warning icon
        JOptionPane.showMessageDialog(frame,
                message,
                title,
                JOptionPane.ERROR_MESSAGE,
                errorIcon);
    }

    public void cancelMessage(String message, String title){
        //custom title, warning icon
        JOptionPane.showMessageDialog(frame,
                message,
                title,
                JOptionPane.CANCEL_OPTION,
                cancelIcon);
    }
}
