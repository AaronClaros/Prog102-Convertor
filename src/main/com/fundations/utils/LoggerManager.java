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
 *
 * This class implements log4j using Singleton
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */

package main.com.fundations.utils;

import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;

import java.net.URL;

public class LoggerManager {

    static final String DEBUG_LEVEL = "DEBUG";
    static final String INFO_LEVEL = "INFO";
    static final String WARNING_LEVEL = "WARNING";
    static final String ERROR_LEVEL = "ERROR";
    static final String FATAL_LEVEL = "FATAL";

    private static LoggerManager obj;
    private Logger oLog;

    private LoggerManager(){
        /*
         * Config.xml: file path used to configure log4j
         */
        final URL log4jFile=LoggerManager.class.getResource("Config.xml");
        DOMConfigurator.configure(log4jFile);
    }

    public LoggerManager(Logger logger) {
        this();
        setLogger(logger);
    }

    private void setLogger(Logger oLog)
    {
        this.oLog = oLog;
    }

    public static LoggerManager getLogger(){
        if (obj == null)
            obj = new LoggerManager(Logger.getLogger(LoggerManager.class));

        return obj;
    }

    public void Log(String msg, String level){
        if (DEBUG_LEVEL.equals(level)) {
            oLog.debug(msg);

        } else if (INFO_LEVEL.equals(level)) {
            oLog.info(msg);

        } else if (WARNING_LEVEL.equals(level)) {
            oLog.warn(msg);

        } else if (ERROR_LEVEL.equals(level)) {
            oLog.error(msg);

        } else if (FATAL_LEVEL.equals(level)) {
            oLog.fatal(msg);
        }
    }
}
