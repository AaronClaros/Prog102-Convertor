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

package com.foundations.convertor.model.Conversion;

import com.foundations.convertor.common.ConversionCriteria;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;

import java.io.File;

/**
 * this class has the methods to convert
 * a audio file into other with some
 * characteristics given
 * @author kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class AudioConversion {
    public AudioConversion(ConversionCriteria criteria) {
        String separator = System.getProperty("file.separator");
        try{
            String ffProbePath = new File(".").getCanonicalFile() + separator + "src" + separator +"main" + separator +"resources" + separator +"thirdparty"+separator+ "ffprobe.exe";
            String ffMpegPath = new File(".").getCanonicalFile() + separator + "src" + separator +"main" + separator +"resources" + separator +"thirdparty"+separator+ "ffmpeg.exe";

            FFmpeg fmWrapper = new FFmpeg(ffMpegPath);
            FFprobe fpWrapper = new FFprobe(ffProbePath);
            String ruta=criteria.getPath();
            FFmpegProbeResult in = fpWrapper.probe(ruta);
            FFmpegBuilder builder = ffSetBuild(in,criteria.getOutputPath(), 48000,1,4800);
            FFmpegExecutor executor = new FFmpegExecutor(fmWrapper, fpWrapper);
            executor.createTwoPassJob(builder).run();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public FFmpegBuilder ffSetBuild(FFmpegProbeResult input, String outputPath,long bitRate,int chanels, int sampleRate){
        FFmpegBuilder builder = new FFmpegBuilder()
                //input video ffprobe
                .setInput(input)
                //set override outpath file if exists
                .overrideOutputFiles(true)
                .addOutput(outputPath)
                .setFormat("mp3")
                .setAudioBitRate(bitRate)
                .setTargetSize(25000)
                .setAudioChannels(chanels)
                .setAudioSampleRate(sampleRate)
                .setAudioCodec("acc")
                .done();
        return builder;
    }/* conversionCriteria = new ConversionCriteria();

            conversionCriteria.setPath("C:\\Users\\KevinSanchez\\Downloads\\exampleA.mp3");
            conversionCriteria.setExtension("mp3");
            String newName = view.getConvPanel().getTxtName().getText();
            conversionCriteria.setFileName(newName);
            String textOutPath = view.getConvPanel().getTFOutputPath().getText();
            conversionCriteria.setOutputDirectory(textOutPath);
            AudioConversion audioConversion=new AudioConversion(conversionCriteria);*/
}
