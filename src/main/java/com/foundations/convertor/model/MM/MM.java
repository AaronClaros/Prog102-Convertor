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
 */
package com.foundations.convertor.model.MM;
/**
 *  Generic multimedia class
 *
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */
public class MM {
    //Field to get/set the duration
    private Double duration;
    //Field to get/set the path file
    private String pathFile;
    //Field to get/set the file name
    private String fileName;
    //Field to get/set the f rate
    private String aCodec;
    //Field to get/set the extension
    private String ext;
    //Field for Size
    private long size;

    //return the duration
    public Double getDuration() {
        return duration;
    }
    //setting the duration
    public void setDuration(Double duration) {
        this.duration = duration;
    }
    //return the path file
    public String getPathFile() {
        return pathFile;
    }
    //setting the path file
    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
    //return the file name
    public String getFileName() {
        return fileName;
    }
    //setting the file name
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    //return audio codec
    public String getAudioCodec() {
        return aCodec;
    }
    //setting the audio codec
    public void setAudioCodec(String aCodec) {
        this.aCodec = aCodec;
    }
    //setting extension
    public void setExt(String ext) {
        this.ext = ext;
    }
    //return extension
    public String getExt() { return ext; }

    /**
     * set multimedia file Size
     * @param size on Bytes
     */
    public void setSize(Long size){this.size = size;}

    /**
     * get the MM file size
     * @return size on Bytes
     */
    public Long getSize (){ return this.size; }
}
