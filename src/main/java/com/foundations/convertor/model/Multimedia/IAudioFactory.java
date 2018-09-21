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

public interface IAudioFactory {
    public Multimedia createAudio(String filePath, String fileName, String fileExt, String audioCodec, double duration,
                             long size, int channels, int sampleRate, long bitRate, String bitDepth, String songTitle,
                             String songArtist, String songAlbum);
}
