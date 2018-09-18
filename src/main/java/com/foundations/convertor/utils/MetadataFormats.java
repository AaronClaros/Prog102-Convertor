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

package com.foundations.convertor.utils;

/**
 * contains data about multimedia metadata formats
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public abstract class MetadataFormats {
    //video formats
    public static String[] videoExtensions =    {"","mp4","avi","flv","mkv","mov","3gp"};
    public static String[] videoFrameRates =    {"","24","25","29","29.7","30","60"};
    public static String[] videoAspectRatios =  {"","16:9","16:10","0:1","4:3","40:23"};
    public static String[] videoResolutions =    {"","1920X1080","1280X720","640X480","640X368","480X270","320X240","256X240","176X144"};
    public static String[] videoCodecs =        {"","h264","h263","vp6f","indeo4","mpeg4","flv","avi"};

    //audio formats
    public static String[] audioExtensions =    {"","mp3","wma","wav","ogg","flac"};
    public static String[] audioCodecs =        {"","mp3","pcm_u8","wmav2","ogg","flac","acc"};
    public static String[] audioBitDepth =      {"","u8","s16","s16p","fltp"};
    public static String[] audioSampleRates =   {"","11025","22050","44100","48000"};
}
