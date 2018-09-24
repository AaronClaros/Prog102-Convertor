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
 * @authors Angelica
 * @version 0.1
 */
package com.foundations.convertor.utils;

import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

/**
 * Test class to verify the static values
 */
public class MetadataFormatsTest {

    //video formats
    public static String[] videoExtensionsTestExpected =    {"","mp4","avi","flv","mkv","mov","3gp"};
    public static String[] videoFrameRatesTestExpected =    {"","24","25","29","29.7","30","60"};
    public static String[] videoAspectRatiosTestExpected =  {"","16:9","16:10","0:1","4:3","40:23"};
    public static String[] videoResolutionsTestExpected =    {"","1920X1080","1280X720","640X480","640X368","480X270","320X240","256X240","176X144"};
    public static String[] videoCodecsTestExpected =        {"","h264","h263","vp6f","indeo4","mpeg4","flv","avi"};

    //audio formats
    public static String[] audioExtensionsTestExpected =    {"","mp3","wma","wav","ogg","flac"};
    public static String[] audioCodecsTestExpected =        {"","mp3","pcm_u8","wmav2","ogg","flac","aac"};
    public static String[] audioBitDepthTestExpected =      {"","u8","s16","s16p","fltp"};
    public static String[] audioSampleRatesTestExpected =   {"","11025","22050","44100","48000"};
    public static String[] audioBitRateTestExpected =   {"","24000","32000","48000","64000","96000","127999","128000","129737","176456","838371"};
    public static String[] audioChannelsTestExpected =   {"","1","2"};

    /**
     * Test method to retrieve the formats
     */
    @Test
    public void verifyFormats() {

        MetadataFormats mockedMetadataFormats = mock(MetadataFormats.class, Mockito.CALLS_REAL_METHODS);

        mockedMetadataFormats.videoExtensions.equals(videoExtensionsTestExpected);
        mockedMetadataFormats.videoFrameRates.equals(videoFrameRatesTestExpected);
        mockedMetadataFormats.videoAspectRatios.equals(videoAspectRatiosTestExpected);
        mockedMetadataFormats.videoResolutions.equals(videoResolutionsTestExpected);
        mockedMetadataFormats.videoCodecs.equals(videoCodecsTestExpected);
        mockedMetadataFormats.audioExtensions.equals(audioExtensionsTestExpected);
        mockedMetadataFormats.audioCodecs.equals(audioCodecsTestExpected);
        mockedMetadataFormats.audioBitDepth.equals(audioBitDepthTestExpected);
        mockedMetadataFormats.audioSampleRates.equals(audioSampleRatesTestExpected);
        mockedMetadataFormats.audioBitRate.equals(audioBitRateTestExpected);
        mockedMetadataFormats.audioChannels.equals(audioChannelsTestExpected);
    }
}
