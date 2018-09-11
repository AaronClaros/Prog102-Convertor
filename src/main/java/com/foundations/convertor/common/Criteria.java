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
    // frame Rate to search
    private Double frameRate;
    // Initial time to search
    private double durFrom;
    // Final time to search
    private double durTo;
    // aspect ratio to search
    private String aspcRatio;
    // resolution to search
    private String resolution;
    //video codec to search
    private String videoCodec;
    // audio codec to search
    private String audioCodec;

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
     * @return It returns the given frame rate to search
     */
    public Double getFrameRate() {
        return frameRate;
    }

    /**
     * @return It returns the given initial time to search
     */
    public double getDurFrom() {
        return durFrom;
    }

    /**
     * @return It returns the given final time to search
     */
    public double getDurTo() {
        return durTo;
    }

    /**
     * @return It returns the given aspect ratio to search
     */
    public String getAspcRatio() {
        return aspcRatio;
    }

    /**
     * @return It returns the given resolution to search
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * @return It returns the given video codec to search
     */
    public String getVideoCodec() {
        return videoCodec;
    }

    /**
     * @return It returns the given audio codec to search
     */
    public String getAudioCodec() {
        return audioCodec;
    }

    /**
     * @return file's extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param path It will set the path to search
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @param fileName It will set the file name to search
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

    /**
     * @param frameRate It will set the frame rate to search
     */
    public void setFrameRate(Double frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * @param durFrom It will set the initial time to search
     */
    public void setDurFrom(double durFrom) {
        this.durFrom = durFrom;
    }

    /**
     * @param durTo It will set the final time to search
     */
    public void setDurTo(double durTo) {
        this.durTo = durTo;
    }

    /**
     * @param aspcRatio It will set the aspect ratio to search
     */
    public void setAspcRatio(String aspcRatio) {
        this.aspcRatio = aspcRatio;
    }

    /**
     * @param resolution It will set the resolution to search
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     * @param videoCodec It will set the video codec to search
     */
    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    /**
     * @param audioCodec It will set the audio codec to search
     */
    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }
}
