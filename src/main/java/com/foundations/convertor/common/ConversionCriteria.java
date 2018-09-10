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
//TODO make this class heritage from Criteria
public class ConversionCriteria {
    private String inputPath;
    private String outputFolder;
    private String outputName;
    private String outputFormat;
    private double framesPerSecond;
    private int resolutionWidth;
    private int resolutionHeight;
    private String videoCodec;
    private String audioCodec;
    //private String outputPath;
    //private String inputName;
    //private String inputFormat;

    /**
     * Constructor class, set default data
     * @param input absolute path of input video file
     */
    public ConversionCriteria(String input){
        inputPath = input;
        outputFolder = "";
        outputName = "";
        outputFormat = "";
        framesPerSecond = 0;
        resolutionWidth = -1;
        resolutionHeight = -1;
        videoCodec = "";
        audioCodec = "";
        /*
        try {
            String separator = System.getProperty("file.separator");
            String ffProbePath = new File(".").getCanonicalFile() + separator + "src" + separator +"main" + separator +"resources" + separator +"thirdparty"+separator+ "ffprobe.exe";
            String inputDebug = "C:\\Users\\kevinherrera\\Videos\\doll_sample.avi";
            String outputDebug = "doll_29fps.avi";
            FFprobe fpWrapper = new FFprobe(ffProbePath );
            FFmpegProbeResult in = fpWrapper.probe(input);

        }catch (Exception e){
            LoggerManager.getLogger().Log("ERROR FFPROBE ON CRITERIA: "+e.getMessage(),"ERROR");
        }
        */
    }

    public void setInputPath(String path){
        inputPath = path;
    }
    public String getInputPath(){
        return  inputPath;
    }
    public void setOutputDirectory(String folderPath){
        outputFolder = folderPath;
    }
    public void setOutputName(String path){
        outputName = path;
    }
    public void setOutputFormat(String path){
        outputFormat = path;
    }
    public String getOutputPath() {
        if (outputFolder.isEmpty()){
            outputFolder = FilenameUtils.getFullPath(inputPath);
        }
        if (outputName.isEmpty()) {
            //save current date as date time format
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime now = LocalDateTime.now();
            //set current date as default output name
            outputName = FilenameUtils.getBaseName(inputPath)+"-"+dtf.format(now);
        }
        if (outputFormat.isEmpty()){
            outputFormat = FilenameUtils.getExtension(inputPath);
        }
        return outputFolder+outputName+"."+outputFormat;
    }

    public void setFramesPerSecond(double framesPerSecond){
        this.framesPerSecond = framesPerSecond;
    }

    public double getFramesPerSecond(){
        return  framesPerSecond;
    }

    public void setResolution(int width, int height){
        resolutionWidth = width;
        resolutionHeight = height;
    }

    public int getResolutionWidth(){
        return resolutionWidth;
    }

    public int getResolutionHeight(){
        return resolutionHeight;
    }

    public void setVideoCodec(String codec){
        videoCodec = codec;
    }

    public String getVideoCodec(){
        return videoCodec;
    }


    public void setAudioCodec(String codec){
        audioCodec = codec;
    }

    public String getAudioCodec(){
        return audioCodec;
    }

    public String getOutputFormat(){
        return outputFormat;
    }
}
