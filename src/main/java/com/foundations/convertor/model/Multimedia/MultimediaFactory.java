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

package com.foundations.convertor.model.Multimedia;

/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class MultimediaFactory implements IVideoFactory, IAudioFactory {
    @Override
    public Multimedia createVideo(String filePath, String fileName, String fileExt, String audioCodec, double duration,
                             long size, String aspectRatio, String resolution, String videoCodec, double frameRate) {
        Video video = new Video();
        video.setPathFile(filePath);
        video.setFileName(fileName);
        video.setExt(fileExt);
        video.setAudioCodec(audioCodec);
        video.setDuration(duration);
        video.setSize(size);
        video.setAspectRatio(aspectRatio);
        video.setResolution(resolution);
        video.setVideoCodec(videoCodec);
        video.setFrameRate(frameRate);
        return video;
    }

    @Override
    public Multimedia createAudio(String filePath, String fileName, String fileExt, String audioCodec, double duration,
                             long size, int channels, int sampleRate, long bitRate, String bitDepth, String songName,
                             String songArtist, String songAlbum) {
        Audio audio = new Audio();
        audio.setPathFile(filePath);
        audio.setFileName(fileName);
        audio.setExt(fileExt);
        audio.setAudioCodec(audioCodec);
        audio.setDuration(duration);
        audio.setSize(size);
        audio.setChannels(channels);
        audio.setSampleRate(sampleRate);
        audio.setBitRate(bitRate);
        audio.setBitDepth(bitDepth);
        audio.setSongName(songName);
        audio.setSongArtist(songArtist);
        audio.setSongAlbum(songAlbum);
        return audio;
    }
}
