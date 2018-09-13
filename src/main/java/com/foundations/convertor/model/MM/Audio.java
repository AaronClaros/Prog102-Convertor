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
 *  Audio type class
 *
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */
public class Audio extends MM{

    private String channels;
    private String songName;
    private String songArtist;
    private String songAlbum;
    private int bitRate;
    private long sampleRate;

    /**
     * get Audio channels
     * @return audio channels
     */
    public String getChannels() {
        return channels;
    }

    /**
     * Set the audio channels
     * @param channels of the audio
     */
    public void setChannels(String channels) {
        this.channels = channels;
    }

    /**
     * get song name
     * @return song name
     */
    public String getSongName() {
        return songName;
    }

    /**
     * Set the song name
     * @param songName of the audio
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * get song name
     * @return song name
     */
    public String getSongArtist() {
        return songArtist;
    }

    /**
     * Set the song Artist
     * @param songArtist of the audio
     */
    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    /**
     * get song album
     * @return song album
     */
    public String getSongAlbum() {
        return songAlbum;
    }

    /**
     * Set the song album
     * @param songAlbum of the audio
     */
    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }

    /**
     * get song bit rate
     * @return bit rate
     */
    public int getBitRate() {
        return bitRate;
    }

    /**
     * Set the song bit rate
     * @param bitRate of the audio
     */
    public void setBitRate(int bitRate) {
        this.bitRate = bitRate;
    }

    /**
     * get sample rate
     * @return sample rate
     */
    public long getSampleRate() {
        return sampleRate;
    }

    /**
     * Set the sample rate
     * @param sampleRate of audio
     */
    public void setSampleRate(long sampleRate) {
        this.sampleRate = sampleRate;
    }
}
