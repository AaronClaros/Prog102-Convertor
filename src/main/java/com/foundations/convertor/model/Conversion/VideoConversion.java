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
import com.foundations.convertor.utils.LoggerManager;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFmpegUtils;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.job.FFmpegJob;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.progress.Progress;
import net.bramp.ffmpeg.progress.ProgressListener;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author kevin herrera - AWT-[01].
 * @version 0.1
 */
public class VideoConversion {
    //double property to save progress percentage and add listeners to this value
    private DoubleProperty progressPercentage;
    //reference to ffmpegjob
    private FFmpegJob conversionJob;
    //reference to progress property from progress listener
    private Progress progress;

    /**
     *  Constructor of class
     */
    public VideoConversion(){
        progressPercentage = new SimpleDoubleProperty();
        setProgressPercentage(0);
    }
    /**
     * Prepare criteria parameters to make a video conversion
     * @param criteria conversion criteria parameters
     */
    public void doConversion(ConversionCriteria criteria){
        String separator = System.getProperty("file.separator");
        try{
            String ffProbePath = new File(".").getCanonicalFile() + separator + "src" + separator +"main" + separator +"resources" + separator +"thirdparty"+separator+ "ffprobe.exe";
            String ffMpegPath = new File(".").getCanonicalFile() + separator + "src" + separator +"main" + separator +"resources" + separator +"thirdparty"+separator+ "ffmpeg.exe";
            FFprobe fpWrapper = new FFprobe(ffProbePath );
            FFmpeg fmWrapper = new FFmpeg(ffMpegPath);
            //convert input path into FFmpeg result
            FFmpegProbeResult in = fpWrapper.probe(criteria.getPath());
            String out = criteria.getOutputPath();
            //Validate Frame Rate to convert to
            double fps;
            if(criteria.getFrameRate() == null) {
                fps = in.getStreams().get(0).r_frame_rate.getNumerator();
            } else {
                fps = criteria.getFrameRate();
            }
            //Validate resolution to convert to
            int resWidth;
            int resHeight;
            if(criteria.getResolution().isEmpty()) {
                resWidth  = in.getStreams().get(0).width;
                resHeight = in.getStreams().get(0).height;
            } else {
                String resolution[] = criteria.getResolution().split("X");
                resWidth = Integer.parseInt(resolution[0]);
                resHeight = Integer.parseInt(resolution[1]);
            }
            //validate video codec
            String vCodec = criteria.getVideoCodec().isEmpty() ? in.getStreams().get(0).codec_name : criteria.getVideoCodec();
            //validate audio codec
            String auxACodec;
            if (in.getStreams().size()>=2){
                auxACodec = in.getStreams().get(1).codec_name;
            } else {
                auxACodec = "mp3";
            }
            String aCodec = criteria.getAudioCodec().isEmpty() ? auxACodec:criteria.getVideoCodec();
            LoggerManager.getLogger().Log("verified criteria, FPS: "+fps+" Resolution:"+resWidth+"x"+resHeight+" VideoCodec: "+vCodec+" AudioCodec: "+aCodec, "INFO");
            //execute method to run conversion
            FFmpegBuilder builder = ffSetBuild(in, out, fps, resWidth, resHeight, vCodec, aCodec);
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
            // Or run a two-pass encode (which is better quality at the cost of being slower)
            // IMPORTANT: Target size, or video bitrate must be specified when using two-pass Job
            //executor.createTwoPassJob(builder).run();
        }catch (Exception e){
            LoggerManager.getLogger().Log("Error: "+ VideoConversion.class.getName()+":"+e.getStackTrace()+" "+
                                        e.getMessage(), "ERROR");
            throw new RuntimeException(e.getMessage());
        }
    }
    /**
     * Instance a FFmpegBuilder using a parameters of conversion
     * @param input FFmpegProbeResult created with video input path
     * @param outputPath output path for video to converted
     * @param frameRate frame rate for video to converted
     * @param resWidth resolution width for video to convert
     * @param resHeight resolution height for video to convert
     * @param videoCodec video codec for video to convert
     * @param audioCodec audio codec for video to coer
     * @return object FFmpegBuilder
     */
    private FFmpegBuilder ffSetBuild(FFmpegProbeResult input, String outputPath, double frameRate,
                                     int resWidth, int resHeight, String videoCodec, String audioCodec){
        FFmpegBuilder builder = new FFmpegBuilder()
                //input video ffprobe
                .setInput(input)
                //set override outpath file if exists
                .overrideOutputFiles(true)
                //set output path
                .addOutput(outputPath)
                //set output video frame rate
                .setVideoFrameRate(frameRate)
                //set output video resolution
                .setVideoResolution(resWidth, resHeight)
                //set output video codec
                .setVideoCodec(videoCodec)
                //set output audio code
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
