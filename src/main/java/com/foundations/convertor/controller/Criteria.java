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

package com.foundations.convertor.controller;

/**
 *  Criteria class where the search attributes will be passed
 *
 * @author Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class Criteria {
    private String path;
    private String fileName;

    //Empty constructor
    public Criteria() {
    }

    public String getPath() {
        return path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
