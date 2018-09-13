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
 */
package com.foundations.convertor.model;

import com.foundations.convertor.common.Criteria;
import com.foundations.convertor.model.Multimedia.Video;
import com.foundations.convertor.utils.LoggerManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegStream;
import org.apache.commons.io.FilenameUtils;

import static com.foundations.convertor.controller.Controller.criteria;

/**
 *  Search class for java applications, class which search videos
 *
 * @author Kevin Sanchez, Adrian Rojas - AWT-[01].
 * @version 0.1
 */
public class Search {
    // list of file of the specified path
    private List<File> lFiles = new ArrayList<File>();
    // Variable to get the metadata
    private FFprobe ffprobe;
    //Variable to build the path
    private static final String SEPARATOR = System.getProperty("file.separator");
    /**
     * Search constructor
     */
    public Search() {
    }

    /**
     * All the video files in the path directory are added to the video list
     * @param criteria retrieved from GUI with all the search criteria
     * @return list of Multimedia Files
     */
    public List<Video> getAllVideoFiles(Criteria criteria) {
        //Check if the path is correct for a file or directory
        if ((criteria.getPath() == null) || criteria.getPath().isEmpty()) {
            LoggerManager.getLogger().Log("Error message: There is no path selected", "INFO");
            return null;
        }
        //Check if the path is for a File type
        File file = new File(criteria.getPath());
        if (!file.exists()) {
            LoggerManager.getLogger().Log("Error message: Search path is not a directory", "INFO");
            return null;
        }
        List<Video> videoList = new ArrayList<Video>();
        //Go through every file in the path
        fillWithCriteria(file,videoList);
        return videoList;
    }

    /**
     * If the file is a video according to the search criteria it is added to the video list
     * @param file inside the file list from the path directory
     * @param videoList list to be filled with all the files that are videos and have the criteria selected
     */
    private void fillWithCriteria(File file,List<Video> videoList){
        File[] directoryFiles = file.listFiles();
        Video auxVideo;
        for (File elementFile : directoryFiles) {
            //if it is not a file get all video files in the directory: Recursively
            if (elementFile.isDirectory()) {
                File subFile=new File(elementFile.getAbsolutePath());
                fillWithCriteria(subFile,videoList);
            }
            //Check if the file is video and convert it to Multimedia object
            else  if(isVideo(elementFile)) {
                auxVideo = getStreamVideo(elementFile);
                //Check File Name
                if(auxVideo.getFileName()==null||!criteria.getFileName().isEmpty()&&!auxVideo.getFileName().contains(criteria.getFileName())){
                    continue;
                }
                //Check File extension
                if(!criteria.getExtension().isEmpty()&&!auxVideo.getExt().equals(criteria.getExtension())){
                    continue;
                }
                //Check duration
                if(auxVideo.getDuration()==null||criteria.getDurFrom()>auxVideo.getDuration()||
                        criteria.getDurTo()<=auxVideo.getDuration()){
                    continue;
                }
                //Check Frame rate
                if(criteria.getFrameRate()!=null&&Math.round(auxVideo.getFrameRate())!= Math.round(criteria.getFrameRate())){
                    continue;
                }
                //Check Aspect ratio
                if(!criteria.getAspectRatio().isEmpty()&&!auxVideo.getAspectRatio().equals(criteria.getAspectRatio())){
                    continue;
                }
                //Check Resolution
                if(!criteria.getResolution().isEmpty()&&!auxVideo.getResolution().equals(criteria.getResolution())){
                    continue;
                }
                //Check Multimedia Codec
                if(!criteria.getVideoCodec().isEmpty()&&!auxVideo.getVideoCodec().equals(criteria.getVideoCodec())){
                    continue;
                }
                //Check Audio Codec
                if(!criteria.getAudioCodec().isEmpty()&&!auxVideo.getAudioCodec().equals(criteria.getAudioCodec())){
                    continue;
                }
                videoList.add(auxVideo);
            }
        }
    }
    /**
     * Check if a file is a video by the extension
     * @param file which would be compared to a list of supported extensions
     * @return Multimedia verified
     */
    private boolean isVideo(File file){
        String[] supportedExtensions = {"mp4", "avi", "flv", "mkv", "mov","3gp"};
        boolean video = false;
        for (String supportedExtension : supportedExtensions) {
            if (FilenameUtils.getExtension(file.getAbsolutePath()).equals(supportedExtension))
                video = true;
        }
        return video;
    }
    /**
     * This method fill all the stream for a video file media
     * @param file to convert to video object
     * @return a Multi media video File
     */
    public Video getStreamVideo(File file) {
        Video video = new Video();
        try{
            String ffProbePath = new File(".").getCanonicalFile() + SEPARATOR + "src" + SEPARATOR +"main" + SEPARATOR +"resources" + SEPARATOR +"thirdparty"+SEPARATOR+ "ffprobe.exe";

            ffprobe = new FFprobe(ffProbePath);
            FFmpegStream videoStream = ffprobe.probe(file.getPath()).getStreams().get(0);
            video.setExt(FilenameUtils.getExtension(file.getAbsolutePath()));
            video.setFileName(file.getName());
            video.setPathFile(file.getAbsolutePath());
            video.setVideoCodec(videoStream.codec_name);
            video.setAudioCodec(videoStream.codec_type.name());
            video.setFrameRate((videoStream.avg_frame_rate.doubleValue()*100)/100);
            video.setDuration(videoStream.duration);
            video.setAspectRatio(videoStream.display_aspect_ratio);
            video.setResolution(String.valueOf(videoStream.width) + "X" + String.valueOf(videoStream.height));
            video.setSize(file.length());
        }
        //If the file is not a video an exception is send
        catch (Exception ex)
        {
            LoggerManager.getLogger().Log("Error into get stream Multimedia", "ERROR");
        }
        return video;
    }


}


