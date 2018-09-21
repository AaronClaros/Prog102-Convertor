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
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */
public class SearchCriteria extends Criteria {

    //Minimal duration criteria
    private Double durFrom;
    //Maximum duration criteria
    private Double durTo;
    //Only for video* aspect ratio
    private String aspectRatio;
    //Only for audio channels
    private int audioChannels;
    //Only for audio sample rate
    private int audioSampleRate;
    //Only for audio sample rate
    private int audioBitRate;
    //Only for audio bit depth
    private String audioBitDepth = "";

    /**
     * Empty constructor
     */
    public SearchCriteria() {
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
    public String getAspectRatio() {
        return aspectRatio;
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
     * @param aspectRatio It will set the aspect ratio to search
     */
    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    /**
     * @return number of audio channels
     */
    public int getAudioChannels() {
        return audioChannels;
    }

    /**
     * @param audioChannels number of audio channels
     */
    public void setAudioChannels(int audioChannels) {
        this.audioChannels = audioChannels;
    }

    /**
     *
     * @return value of audio sample rate
     */
    public int getAudioSampleRate() {
        return audioSampleRate;
    }

    /**
     *
     * @param audioSampleRate value of audio sample rate
     */
    public void setAudioSampleRate(int audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }
    public void setAudioBitRate(int audioBitRate){this.audioBitRate= audioBitRate;}
    public void setAudioBitDepth(String audioBitDepth){this.audioBitDepth= audioBitDepth;}
    public int getAudioBitRate(){return audioBitRate;}
    public String getAudioBitDepth(){return audioBitDepth;}

}
