/* * @(#)Main.java
 *
 *  Copyright (c) 2018 Jala Foundation.
 *
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved. * * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 *
 * */

package com.foundations.convertor;
/**
 *  Main class for java applications, here start the application
 *
 * @author Kevin Herrera - AWT-[01].
 * @version 0.1
 */

import com.foundations.convertor.controller.Controller;
import com.foundations.convertor.utils.LoggerManager;

public class Main {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        LoggerManager.getLogger().Log("Starting Main", "INFO");
        Controller controller = new Controller();
    }
}
