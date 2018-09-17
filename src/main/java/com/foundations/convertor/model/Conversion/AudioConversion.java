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

import com.foundations.convertor.common.ConAudioCrit;
import com.foundations.convertor.common.ConversionCriteria;
import com.foundations.convertor.utils.LoggerManager;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.job.FFmpegJob;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.progress.Progress;
import net.bramp.ffmpeg.progress.ProgressListener;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * this class has the methods to convert
 * a audio file into other with some
 * characteristics given
 * @author kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class AudioConversion {
    //double property to save progress percentage and add listeners to this value
    private DoubleProperty progressPercentage;
    //reference to ffmpegjob
    private FFmpegJob conversionJob;
    //reference to progress property from progress listener
    private Progress progress;

        /**
         *  Constructor of class
         */
    public AudioConversion(){
            progressPercentage = new SimpleDoubleProperty();
            setProgressPercentage(0);
        }
        /**
         * Prepare criteria parameters to make audio conversion
         * @param criteria conversion criteria parameters
         */
        public void doConversion(ConAudioCrit criteria){
            String separator = System.getProperty("file.separator");
            FFmpegProbeResult in;
            String out;
            long bitRate;
            int channels;
            int sampleRate;
            String audioCodec;
            try{
                String ffProbePath = new File(".").getCanonicalFile() + separator + "src" + separator +"main" + separator +"resources" + separator +"thirdparty"+separator+ "ffprobe.exe";
                String ffMpegPath = new File(".").getCanonicalFile() + separator + "src" + separator +"main" + separator +"resources" + separator +"thirdparty"+separator+ "ffmpeg.exe";
                FFprobe fpWrapper = new FFprobe(ffProbePath );
                FFmpeg fmWrapper = new FFmpeg(ffMpegPath);
                //convert input path into FFmpeg result
                in = fpWrapper.probe(criteria.getPath());
                out = criteria.getOutputPath();
                if (criteria.getBitRate()== 0){
                    bitRate = in.getStreams().get(0).bit_rate;
                }else{
                    bitRate = criteria.getBitRate();
                }

                if (criteria.getChannels() == 0){
                    channels = in.getStreams().get(0).channels;
                }else{
                    channels = criteria.getChannels();
                }

                if (criteria.getSampleRate() == 0){
                    sampleRate = in.getStreams().get(0).sample_rate;
                }else{
                    sampleRate = criteria.getSampleRate();
                }

                if (criteria.getAudioCodec() == null){
                    audioCodec = in.getStreams().get(0).codec_name;
                }else{
                    audioCodec = criteria.getAudioCodec();
                }

                LoggerManager.getLogger().Log("verified criteria, BitRate: "+bitRate+" Channels: "+channels+" Sample Rate: "+sampleRate+" AudioCodec: "+audioCodec, "INFO");
                //execute method to run conversion
                FFmpegBuilder builder = ffSetBuild(in, out, bitRate, channels, sampleRate,audioCodec);
                FFmpegExecutor executor = new FFmpegExecutor(fmWrapper, fpWrapper);
                // Run a one-pass encode
                conversionJob = executor.createJob(builder, new ProgressListener() {
                    // Using the FFmpegProbeResult determine the duration of the input
                    final double duration_ns = in.getFormat().duration * TimeUnit.SECONDS.toNanos(1);
                    @Override
                    public void progress(Progress prog) {
                        progress = prog;
                        setProgressPercentage(prog.out_time_ns / duration_ns);
                    }
                });
                LoggerManager.getLogger().Log("Starting conversion: input: "+criteria.getPath(),"INFO");
                conversionJob.run();
                LoggerManager.getLogger().Log("Finishing conversion: output: "+criteria.getOutputPath(),"INFO");
                //set progress percentage to 0 after finish conversion
                setProgressPercentage(0);
            }catch (Exception e){
                LoggerManager.getLogger().Log("Error: "+ AudioConversion.class.getName()+":"+e.getStackTrace()+" "+
                        e.getMessage(), "ERROR");
            }
        }
        /**
         * Instance a FFmpegBuilder using a parameters of conversion
         * @param input FFmpegProbeResult created with audio input path
         * @param outputPath output path for audio to converted
         * @param bitRate bit rate for the audio file
         * @param channels number of channels for the audio file
         * @param sampleRate sample rate for the audio file
         * @param audioCodec audiocodec for the audio file
         * @return object FFmpegBuilder
         */
        private FFmpegBuilder ffSetBuild(FFmpegProbeResult input, String outputPath, long bitRate, int channels,
                                         int sampleRate,String audioCodec){
            FFmpegBuilder builder = new FFmpegBuilder()
                    //input video ffprobe
                    .setInput(input)
                    //set override outpath file if exists
                    .overrideOutputFiles(true)
                    //set output path
                    .addOutput(outputPath)
                    .setAudioBitRate(bitRate)
                    .setAudioChannels(channels)
                    .setAudioSampleRate(sampleRate)
                    .setAudioCodec(audioCodec)
                    .done();
            return builder;
        }

        /**
         *  setter value for progress percentage
         * @param value new double value for progress
         */
        private void setProgressPercentage(double value) {
            progressPercentage.set(value);
        }

        /**
         * getter for progress percentage value
         * @return percentage value as double
         */
        public double getProgressPercentage() {
            return progressPercentage.get();
        }

        /**
         *  getter for progress percentage property
         * @return object DoubleProperty
         */
        public DoubleProperty getProgressPercentageProperty() {
            return progressPercentage;
        }

        /**
         *  check if conversion job is running task
         * @return true if conversion job state is equal to RUNNING
         */
        public boolean processIsRunning(){
            if (conversionJob == null)
                return false;
            return conversionJob.getState().equals(FFmpegJob.State.RUNNING);
        }
}
