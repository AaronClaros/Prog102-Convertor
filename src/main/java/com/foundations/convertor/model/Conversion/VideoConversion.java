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
import net.bramp.ffmpeg.probe.FFmpegError;
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

    //private FFmpeg fmWrapper;
    //private FFprobe fpWrapper;

    private DoubleProperty progressPercentage;
    private FFmpegJob conversionJob;
    private Progress progress;

    public VideoConversion(){
        progressPercentage = new SimpleDoubleProperty();
        setProgressPercentage(0);
        getProgressPercentageProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue o, Object oldVal, Object newVal) {

                LoggerManager.getLogger().Log(
                        String.format("Conversion Progress:[%.0f%%] status:%s frame:%d time:%s ms fps:%.0f speed:%.2fx",
                            getProgressPercentage() * 100,
                            progress.status,
                            progress.frame,
                            FFmpegUtils.toTimecode(progress.out_time_ns, TimeUnit.NANOSECONDS),
                            progress.fps.doubleValue(),
                            progress.speed
                        ),"DEBUG");
                //TODO register new listener with slider value to this property
            }
        });
        //Usage example, test this code on main method to convert at app execution start
        /*
        ConversionCriteria con = new ConversionCriteria("C:\\Users\\kevinherrera\\Videos\\doll_sample.avi");
        //con.setOutputDirectory("C:\\Users\\kevinherrera\\Videos\\");
        con.setOutputName("test_50fps");
        con.setOutputFormat("mp4");
        con.setFramesPerSecond(50);
        //con.setResolution(1280,720);
        //con.setVideoCodec("vp9");
        //con.setAudioCodec("acc");
        VideoConversion conversion = new VideoConversion();
        LoggerManager.getLogger().Log("Raw criteria: fps:"+con.getFramesPerSecond()+" Format: "+con.getOutputFormat()+" resolution:"+con.getResolutionWidth()+"x"+con.getResolutionHeight()
                            +" VideoCodec: "+con.getVideoCodec()+" AudioCodec: "+con.getAudioCodec(),"INFO");
        conversion.doConversion(con);
        */
    }

    public void doConversion(ConversionCriteria criteria){
        String separator = System.getProperty("file.separator");
        try{
            String ffProbePath = new File(".").getCanonicalFile() + separator + "src" + separator +"main" + separator +"resources" + separator +"thirdparty"+separator+ "ffprobe.exe";
            String ffMpegPath = new File(".").getCanonicalFile() + separator + "src" + separator +"main" + separator +"resources" + separator +"thirdparty"+separator+ "ffmpeg.exe";

            FFprobe fpWrapper = new FFprobe(ffProbePath );
            FFmpeg fmWrapper = new FFmpeg(ffMpegPath);

            FFmpegProbeResult in = fpWrapper.probe(criteria.getPath());

            String out = criteria.getOutputPath();
            double fps = criteria.getFrameRate() <=0 ?
                    in.getStreams().get(0).r_frame_rate.getNumerator(): criteria.getFrameRate();
            String reso[]=criteria.getResolution().split("X");
            int resWidth = Integer.parseInt(reso[0]) <=0 ? in.getStreams().get(0).width: Integer.parseInt(reso[0]);
            int resHeight = Integer.parseInt(reso[1]) <=0 ? in.getStreams().get(0).height : Integer.parseInt(reso[0]);
            String vCodec = criteria.getVideoCodec().isEmpty() ? in.getStreams().get(0).codec_name : criteria.getVideoCodec();

            String auxACodec;
            if (in.getStreams().size()>=2){
                auxACodec = in.getStreams().get(1).codec_name;
            } else {
                auxACodec = "mp3";
            }
            String aCodec = criteria.getAudioCodec().isEmpty() ? auxACodec:criteria.getVideoCodec();

            LoggerManager.getLogger().Log("verified criteria, FPS: "+fps+" Resolution:"+resWidth+"x"+resHeight+" VideoCodec: "+vCodec+" AudioCodec: "+aCodec, "INFO");

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
                    /*
                    // Print out interesting information about the progress
                    System.out.println(String.format(
                            "[%.0f%%] status:%s frame:%d time:%s ms fps:%.0f speed:%.2fx",
                            getProgressPercentage() * 100,
                            progress.status,
                            progress.frame,
                            FFmpegUtils.toTimecode(progress.out_time_ns, TimeUnit.NANOSECONDS),
                            progress.fps.doubleValue(),
                            progress.speed
                    ));
                    */
                }
            });
            LoggerManager.getLogger().Log("Starting conversion: input: "+criteria.getPath(),"INFO");
            conversionJob.run();
            LoggerManager.getLogger().Log("Finishing conversion: output: "+criteria.getOutputPath(),"INFO");
            conversionJob.wait();
            // Or run a two-pass encode (which is better quality at the cost of being slower)
            // IMPORTANT: Target size, or video bitrate must be specified when using two-pass Job
            //executor.createTwoPassJob(builder).run();
        }catch (Exception e){
            LoggerManager.getLogger().Log("Error: "+ VideoConversion.class.getName()+" "+e.getMessage(), "ERROR");
        }
    }
    private void setProgressPercentage(double value) {
        progressPercentage.set(value);
    }
    public double getProgressPercentage() {
        return progressPercentage.get();
    }
    public DoubleProperty getProgressPercentageProperty() {
        return progressPercentage;
    }
    public boolean processIsRunning(){
        if (conversionJob == null)
            return false;
        return conversionJob.getState().equals(FFmpegJob.State.RUNNING);
    }

    private FFmpegBuilder ffSetBuild(FFmpegProbeResult input, String outputPath, double frameRate,
                                      int resWidth, int resHeight, String videoCodec, String audioCodec){
        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(input)     // Filename, or a FFmpegProbeResult
                .overrideOutputFiles(true) // Override the output if it exists
                .addOutput(outputPath)   // Filename for the destination
                .setVideoFrameRate(frameRate)
                .setVideoResolution(resWidth, resHeight)
                .setVideoCodec(videoCodec)
                .setAudioCodec(audioCodec)
                .done();
        return builder;
    }

}
