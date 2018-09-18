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

/**
 *
 * Contains the criteria to do audio files conversions
 *
 * @author Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class ConAudioCrit extends ConversionCriteria {
    private long bitRate;
    private int channels;
    private int sampleRate;
    private String bitDepth;

    /**
     * Empty constructor
     */
    public ConAudioCrit(){
    }

    /**
     * getter for bitrate
     * @return bitrate
     */
    public long getBitRate() {
        return bitRate;
    }

    /**
     * getter for number of channles
     * @return number of channels
     */
    public int getChannels() {
        return channels;
    }

    /**
     * getter for sampleRate
     * @return sampleRate
     */
    public int getSampleRate() {
        return sampleRate;
    }

    /**
     * getter for bitdepth
     */
    public String getBitDepth() {
        return bitDepth;
    }

    /**
     * setter number of channels
     * @param channels
     */
    public void setChannels(int channels) {
        this.channels = channels;
    }

    /**
     * setter for sample rate
     * @param sampleRate
     */
    public void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }

    /**
     * setter for bitdepth
     * @param bitDepth
     */
    public void setBitDepth(String bitDepth) {
        this.bitDepth = bitDepth;
    }

    /**
     * setter for bitrate field
     * @param bitRate
     */
    public void setBitRate(long bitRate) {
        this.bitRate = bitRate;
    }
}
