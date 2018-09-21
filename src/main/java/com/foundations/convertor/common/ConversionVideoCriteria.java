/*
 *
 *  Copyright (c) 2018 Jala Foundation.
 *  2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of
 *  Jala Foundation, ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jala Foundation.
 *
 */

package com.foundations.convertor.common;

import org.apache.commons.io.FilenameUtils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * Contains the criteria to do video files conversions
 *
 * @author kevinherrera - AWT-[01].
 * @version 0.1
 */
public class ConversionVideoCriteria extends Criteria {
    private String outputFolder;

    /**
     * Constructor class, set default data
     */
    public void ConversionCriteria(){
        outputFolder = "";
        setFileName("");
        setExtension("");
        setFrameRate(0.0);
        setResolution("-1X-1");
        setVideoCodec("");
        setAudioCodec("");
    }
    public void setOutputDirectory(String folderPath){
        outputFolder = folderPath;
    }
    public String getOutputPath() {
        if (outputFolder.isEmpty()){
            outputFolder = FilenameUtils.getFullPath(getPath());
        }
        if (getFileName().isEmpty()) {
            //save current date as date time format
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            //set current date as default output name
            setFileName(FilenameUtils.getBaseName(getPath())+"-"+dtf.format(now));
        }
        if (getExtension().isEmpty()){
            setExtension(FilenameUtils.getExtension(getPath()));
        }
        return outputFolder+"\\"+getFileName()+"."+getExtension();
    }

}
