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

package com.foundations.convertor.common;

/**
 *  Criteria class where the search attributes will be passed
 *
 * @author Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class Criteria {

    // path to search
    private String path;

    // file name to search
    private String fileName;

    // extension of the file to search
    private String extension;
  
    /**
     * Empty constructor
     */
    public Criteria() {
    }

    /**
     * @return  It returns the given path to search
     */
    public String getPath() {
        return path;
    }

    /**
    * @return It returns the given file to search
    */
    public String getFileName() {
        return fileName;
    }

    /**
     * @return file's extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param path It will set the path for the search
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @param fileName It will set the file name for the search
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @param extension sets the extension of the file to search
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }
}
