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

public class LoggerManager {

    //public enum LogLevel {DEBUG, INFO, WARNING, ERROR, FATAL};

    private static LoggerManager obj;
    private Logger oLog;

    private LoggerManager(){
        /*
         * Config.xml: file path used to configure log4j
         */
        DOMConfigurator.configure("Config.xml");
    }

    public LoggerManager(Logger logger) {
        this();
        setLogger(logger);
    }

    private void setLogger(Logger _oLog)
    {
        oLog = _oLog;
    }

    public static LoggerManager getLogger(){
        if (obj == null)
            obj = new LoggerManager(Logger.getLogger(LoggerManager.class));

        return obj;
    }

   /* public void Log(String _sMsg, LoggerManager.LogLevel _eLogLevel){
        switch(_eLogLevel){
            case DEBUG:
                oLog.debug(_sMsg);
                break;
            case INFO:
                oLog.info(_sMsg);
                break;
            case WARNING:
                oLog.warn(_sMsg);
                break;
            case ERROR:
                oLog.error(_sMsg);
                break;
            case FATAL:
                oLog.fatal(_sMsg);
                break;
            default:
        }
    }*/
}

