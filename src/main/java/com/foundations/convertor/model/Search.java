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
import com.foundations.convertor.model.Multimedia.Audio;
import com.foundations.convertor.model.Multimedia.Multimedia;
import com.foundations.convertor.model.Multimedia.MultimediaFactory;
import com.foundations.convertor.model.Multimedia.Video;
import com.foundations.convertor.utils.ConverterUtils;
import com.foundations.convertor.utils.LoggerManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.probe.FFmpegStream;
import org.apache.commons.io.FilenameUtils;

import static com.foundations.convertor.controller.Controller.criteria;

/**
 *  Search class for java applications, class which search videos
 *
 * @author Kevin Sanchez, Adrian Rojas, Kevin Herrera - AWT-[01].
 * @version 0.1
 */
public class Search implements ISearchVideo, ISearchAudio{
    // Variable to get the metadata
    private FFprobe ffprobe;

    /**
     * Search constructor
     */
    public Search() {
    }

    /**
     * If the file is a video according to the search criteria it is added to the video list
     * search criteria allowed (file name, extension, duration, frame rate, aspect ratio, resolution,
     *                          video codec, audio codec)
     * @param file inside the file list from the path directory
     * @param videoList list to be filled with all the files that are videos and have the criteria selected
     */
    private void fillWithVideos(File file, List<Multimedia> videoList){
        File[] directoryFiles = file.listFiles();
        Video auxVideo;
        for (File elementFile : directoryFiles) {
            //if it is not a file get all video files in the directory: Recursively
            if (elementFile.isDirectory()) {
                File subFile=new File(elementFile.getAbsolutePath());
                fillWithVideos(subFile,videoList);
            }
            //Check if the file is video and convert it to Video object
            else  if(isVideo(elementFile)) {
                auxVideo = convertFileToVideo(elementFile);
                if (auxVideo==null){
                    continue;
                }
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
                //Check Video Codec
                if(!criteria.getVideoCodec().isEmpty()&&!auxVideo.getVideoCodec().equals(criteria.getVideoCodec().toLowerCase())){
                    continue;
                }
                //Check Audio Codec
                if(!criteria.getAudioCodec().isEmpty()&&!auxVideo.getAudioCodec().equals(criteria.getAudioCodec().toLowerCase())){
                    continue;
                }
                videoList.add(auxVideo);
            }
        }
    }

    /**
     * If the file is a Audio according to the search criteria it is added to the audio list
     * search criteria allowed (file name, extension, duration, audio codec, channels, sample rate)
     * @param file inside the file list from the path directory
     * @param audioList list to be filled with all the files that are audios and have the criteria selected
     */
    private void fillWithAudios(File file,List<Multimedia> audioList){
        File[] directoryFiles = file.listFiles();
        Audio auxAudio;
        for (File elementFile : directoryFiles) {
            //if it is not a file get all audio files in the directory: Recursively
            if (elementFile.isDirectory()) {
                File subFile=new File(elementFile.getAbsolutePath());
                fillWithAudios(subFile,audioList);
            }
            //Check if the file is audio and convert it to Multimedia object
            else  if(isAudio(elementFile)) {
                auxAudio = convertFileToAudio(elementFile);
                if (auxAudio == null){
                    continue;
                }
                //Check File Name
                if(auxAudio.getFileName()== null||!criteria.getFileName().isEmpty()&&!auxAudio.getFileName().contains(criteria.getFileName())){
                    continue;
                }
                //Check File extension
                if(!criteria.getExtension().isEmpty()&&!auxAudio.getExt().equals(criteria.getExtension())){
                    continue;
                }
                //Check duration
                if(auxAudio.getDuration()==null||criteria.getDurFrom()>auxAudio.getDuration()||
                        criteria.getDurTo()<=auxAudio.getDuration()){
                    continue;
                }
                //Check Audio Codec
                if(!criteria.getAudioCodec().isEmpty()&&!auxAudio.getAudioCodec().equals(criteria.getAudioCodec().toLowerCase())){
                    continue;
                }
                //Check channel count
                if(criteria.getAudioChannels() != 0 &&criteria.getAudioChannels()!=auxAudio.getChannels()){
                    continue;
                }
                //Check sample rate
                if(criteria.getAudioSampleRate() != 0 && criteria.getAudioSampleRate()!=auxAudio.getSampleRate()){
                    continue;
                }
                //Check bit rate
                if(criteria.getAudioBitRate() != 0 && criteria.getAudioBitRate()!=auxAudio.getBitRate()){
                    continue;
                }
                //Check bit depth rate
                if(!criteria.getAudioBitDepth().isEmpty() && !auxAudio.getBitDepth().equals(criteria.getAudioBitDepth())){
                    continue;
                }
                audioList.add(auxAudio);

            }
        }
    }
    /**
     * Check if a file is a video by the extension
     * @param file which would be compared to a list of supported extensions
     * @return true when file has a valid extension (mp4, avi, flv, mkv, mov, 3gp)
     */
    @Override
    public boolean isVideo(File file){
        String[] supportedExtensions = {"mp4", "avi", "flv", "mkv", "mov","3gp"};
        boolean video = false;
        for (String supportedExtension : supportedExtensions) {
            if (FilenameUtils.getExtension(file.getAbsolutePath()).equals(supportedExtension))
                video = true;
        }
        return video;
    }


    /**
     * Check if a file is an audio by the extension
     * @param file which would be compared to a list of supported extensions
     * @return true when file has a valid extension (mp3, ogg, flac, wav, wma)
     */
    @Override
    public  boolean isAudio(File file){
        String[] supportedExtensions = {"mp3", "ogg", "flac", "wav", "wma"};
        boolean isAudio = false;
        for (String supportedExtension : supportedExtensions) {
            if (FilenameUtils.getExtension(file.getAbsolutePath()).equals(supportedExtension))
                isAudio = true;
        }
        return isAudio;
    }

    /**
     * check if a path is valid and exist
     * @param path string of path to check
     * @return a File object, null if path is invalid or no exist
     */
    private File checkValidDirectotyPath(String path){
        //Check if the path is correct for a file or directory
        if ((path == null) || path.isEmpty()) {
            LoggerManager.getLogger().Log("Error message: There is no path selected", "ERROR");
            return null;
        }
        //Check if the path is for a File type
        File file = new File(path);
        if (!file.exists()) {
            LoggerManager.getLogger().Log("Error message: Search path is not a directory", "ERROR");
            return null;
        } else {
            return file;
        }
    }

    /**
     * search video files with criteria values
     * @param criteria criteria to execute search
     * @return list of video objects instanced as Multimedia objects
     */
    @Override
    public List<Multimedia> searchVideoFiles(Criteria criteria) {
        List<Multimedia> videoList = new ArrayList<Multimedia>();
        fillWithVideos(checkValidDirectotyPath(criteria.getPath()),videoList);
        return videoList;
    }

    /**
     * search audio files with criteria values
     * @param criteria criteria to execute search
     * @return list of audio objects instanced as Multimedia objects
     */
    @Override
    public List<Multimedia> searchAudioFiles(Criteria criteria) {
        List<Multimedia> audioList = new ArrayList<Multimedia>();
        fillWithAudios(checkValidDirectotyPath(criteria.getPath()),audioList);
        return audioList;
    }

    /**
     * convert a file object to Video object, setting data with ffprobe wrapper
     * @param file file to convert
     * @return Video object
     */
    @Override
    public Video convertFileToVideo(File file) {
        Video video = null;
        FFmpegProbeResult probeResult = null;
        FFmpegStream videoStream = null;
        FFmpegStream audioStream = null;
        try{
            if (ffprobe==null) {
                ffprobe = new FFprobe(ConverterUtils.getFFprobeBinPath());
            }
            probeResult = ffprobe.probe(file.getPath());
            videoStream = probeResult.getStreams().get(0);
            audioStream = probeResult.getStreams().get(1);
        }
        //If the file is not a video an exception is send
        catch (Exception ex)
        {
            LoggerManager.getLogger().Log("Error into get stream Video", "ERROR");
        }
        if (videoStream != null && videoStream.codec_type.equals(FFmpegStream.CodecType.VIDEO)){
            String aCodecAux = "";
            if (audioStream!=null) {
                aCodecAux = audioStream.codec_name;
            }
            //set Video object values
            video = (Video) new MultimediaFactory().createVideo(file.getAbsolutePath() ,file.getName(),
                    FilenameUtils.getExtension(file.getAbsolutePath()), aCodecAux, videoStream.duration,
                    file.length(), videoStream.display_aspect_ratio,
                    String.valueOf(videoStream.width) + "X" + String.valueOf(videoStream.height),
                    videoStream.codec_name, (videoStream.avg_frame_rate.doubleValue()*100)/100);
        }
        return video;
    }

    /**
     * convert a file object to Audio object, setting data with ffprobe wrapper
     * @param file file to convert
     * @return Audio object
     */
    @Override
    public Audio convertFileToAudio(File file) {
        Audio audio = null;
        FFmpegProbeResult probeResult = null;
        FFmpegStream audioStream = null;
        FFmpegFormat audioFormat = null;
        try{
            if (ffprobe==null) {
                ffprobe = new FFprobe(ConverterUtils.getFFprobeBinPath());
            }
            probeResult = ffprobe.probe(file.getPath());
            audioStream = probeResult.getStreams().get(0);
            audioFormat = probeResult.getFormat();
        }
        //If the file is not a audio an exception is send
        catch (Exception ex)
        {
            LoggerManager.getLogger().Log("Error into get stream Audio", "ERROR");
        }     
        if (audioStream != null && audioStream.codec_type.equals(FFmpegStream.CodecType.AUDIO)) {
            String songTitle = "";
            String songArtist = "";
            String songAlbum = "";
            if (audioFormat.tags != null) {
                songTitle = audioFormat.tags.get("TITLE");
                songArtist = audioFormat.tags.get("ARTIST");
                songAlbum = audioFormat.tags.get("ALBUM");
            }
            //set Audio object values
            audio = (Audio) new MultimediaFactory().createAudio(file.getAbsolutePath(), file.getName(),
                    FilenameUtils.getExtension(file.getAbsolutePath()), audioStream.codec_name, audioStream.duration,
                    audioFormat.size, audioStream.channels, audioStream.sample_rate, audioFormat.bit_rate,
                    audioStream.sample_fmt, songTitle, songArtist, songAlbum);
        }
        if (audio!=null){
            LoggerManager.getLogger().Log(String.format(
                    "New Audio: %s, sample rate: %d, channels: %d, bit rate: %d, bit depth: %s",
                    audio.getFileName(),
                    audio.getSampleRate(),
                    audio.getChannels(),
                    audio.getBitRate(),
                    audio.getBitDepth()),"INFO");
        }
        return audio;
    }
}

