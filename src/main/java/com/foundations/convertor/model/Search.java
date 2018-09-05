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
import com.foundations.convertor.model.Video.Video;
import com.foundations.convertor.utils.LoggerManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegStream;
import org.apache.commons.io.FilenameUtils;

/**
 *  Search class for java applications, class which search videos
 *
 * @author Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class Search {
    // list of file of the specified path
    private List<File> lFiles = new ArrayList<File>();
    // Variable to get the metadata
    private FFprobe ffprobe;
    //Variable to build the path
    private static final String SEPARATOR = System.getProperty("file.separator");

    public Search() {
    }

    /**
     *
     * @param criteria retrieved from GUI with all the search criteria
     * @return list of Video Files
     */
    public List<Video> getAllVideoFiles(Criteria criteria) {
        //Check if the path is correct for a file or directory
        if ((criteria.getPath() == null) || criteria.getPath().isEmpty()) {
            System.out.println("Error message: There is no path selected");
            return null;
        }
        //Check if the path is for a File type
        File file = new File(criteria.getPath());
        if (!file.exists()) {
            System.out.println("Error message: Search path is not a directory");
            return null;
        }

        List<Video> videoList = new ArrayList<Video>();
        File[] directoryFiles = file.listFiles();
        Video auxVideo = new Video();

        //Go through every file in the path
        for (File elementFile : directoryFiles) {
            //if it is not a file get all video files in the directory
            if (elementFile.isDirectory()) {
                //TODO Implement recursively: ready
                //Criteria subCriteria = new Criteria();
                //subCriteria = criteria;
                //subCriteria.setPath(fileDirectory.getPath());
                //getAllVideoFiles(criteria);
            }
            else  if(isVideo(elementFile)) {
                auxVideo=getStreamVideo(criteria,elementFile);
                //Check File Name
                if(!criteria.getFileName().isEmpty()&&!auxVideo.getFileName().contains(criteria.getFileName())){
                    continue;
                }
                //Check File extension
                if(!criteria.getExtension().isEmpty()&&!auxVideo.getExt().equals(criteria.getExtension())){
                    continue;
                }/*
                //Check duration
                if(!criteria.getDurTo()==criteria.getDurFrom()){
                    continue;
                }
                //Check Frame rate
                if(criteria.getFrameRate()!=null&&auxVideo.getFrameRate()!=criteria.getFrameRate()){
                    System.out.println(criteria.getFrameRate());
                    System.out.println(auxVideo.getFrameRate());
                    System.out.println(!auxVideo.getFrameRate().equals(criteria.getFrameRate()));
                    continue;
                }
                //Check Aspect ratio
                if(criteria.getAspcRatio()!=null&&!auxVideo.getAspectRatio().equals(criteria.getAspcRatio())){
                    continue;
                }/*
                //Check Resolution
                if(!criteria.getResolution().isEmpty()&&!auxVideo.getResolution().equals(criteria.getResolution())){
                    continue;
                }
                //Check Video Codec
                if(!criteria.getVideoCodec().isEmpty()&&!auxVideo.getVideoCodec().equals(criteria.getVideoCodec())){
                    continue;
                }
                //Check Audio Codec
                if(!criteria.getAudioCodec().isEmpty()&&!auxVideo.getAudioCodec().equals(criteria.getAudioCodec())){
                    continue;
                }
*/
                videoList.add(auxVideo);
            }
        }
        return videoList;
    }

    /**
     * Check if a file is a video by the extension
     * @param file which would be compared to a list of supported extensions
     * @return
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
     * this method allows to create a list of String with files
     * from the given path, that list is returned to be used
     *
     * @param path is the path where the search begin
     * @return a list of found files with the given path
     */
    public List<File> getAllFilesOnPath(String path){
        File dir = new File(path);

        // is declared to help prove if it is a file o folder
        File auxFile;

        // array of string for the files
        String[] files;
        files = dir.list();
        if(!dir.exists()){
            System.out.println("Error message: Search path is not a directory");
            return null;
        }
            // this "for" send the recuperated data into the list
            for (int i = 0; i < files.length; i++) {

                // File class need a path to create an instance the
                // path given is the construction of de actual path
                // and the file we want to check
                auxFile = new File(path+"\\"+files[i]);

                //this part check if the given path is a file if It
                // is a file It will be add to the list else It will
                // be check for the same method again
                if (auxFile.isFile()) {
                    lFiles.add(auxFile);
                }else{
                    getAllFilesOnPath(path+"\\"+files[i]);
                }
            }
            return lFiles;
    }

    /**
     * this method allows to create a list of String with files
     * from the given path and it filters that list with the name
     *
     * @param path the path where the search begin
     * @param name the name which be used to search the file
     * @return a list
     */
    public List<File> getAllFilesByName(String path, String name){

        // list of files of the specified path
        List<File> newListFiles = new ArrayList<File>();

        // auxiliar list of files rececived to filter
        List<File> aFiles = new ArrayList<File>();

        // Size of the non-filter list
        int sizeList;

        // it will clean the list just in case that some information keeps on it
        lFiles.clear();
        sizeList = getAllFilesOnPath(path).size();
        aFiles = getAllFilesOnPath(path);

        for (int i = 0; i < sizeList; i++){

            //this condition will filter the auxiliar list
            // with the file name and it will be returned
            if (aFiles.get(i).getName().contains(name)){
                newListFiles.add(aFiles.get(i));
            }
        }
        return newListFiles;
    }

    /**
     * This method allows to create a list of File with
     * the criteria extension
     * @param criteria contains the information of searching
     * @return List of Files
     */
    public List<File> getFilesByExtension (Criteria criteria){
        List<File> files = new ArrayList<File>();
        String directory = criteria.getPath();
        String extension = criteria.getExtension();

        File file = new File(directory);

        if (file.exists()){
            File[] directoryFiles = file.listFiles();

            for(File path: directoryFiles) {
                String name = path.getName();
                if (!name.isEmpty() && name.indexOf(extension)!= -1){
                    files.add(path);
                }
            }
        }

        return  files;
    }


    /**
     * This method fill all the stream for a video file media
     * @param criteria to search
     * @return a Multi media video File
     */
    public Video getStreamVideo(Criteria criteria, File file) {

      Video video = new Video();
      try{
        String ffProbePath = new File(".").getCanonicalFile() + SEPARATOR + "src" + SEPARATOR +"main" + SEPARATOR +"resources" + SEPARATOR +"thirdparty"+SEPARATOR+ "ffprobe.exe";

         ffprobe = new FFprobe(ffProbePath);
         FFmpegStream videoStream = ffprobe.probe(file.getPath()).getStreams().get(0);
         String extFile = FilenameUtils.getExtension(file.getAbsolutePath());
         video.setFileName(file.getName());
         video.setPathFile(file.getAbsolutePath());
         video.setVideoCodec(videoStream.codec_name);
         video.setAudioCodec(videoStream.codec_type.name());
         video.setFrameRate(videoStream.avg_frame_rate.toString());
         video.setDuration(new Double(videoStream.duration).toString());
         video.setAspectRatio(videoStream.display_aspect_ratio);
         String resolution=(String.valueOf(videoStream.width) + "X" + String.valueOf(videoStream.height));
         video.setResolution(resolution);
         video.setExt(extFile);
       }
       catch (Exception ex)
       {
           LoggerManager.getLogger().Log("Error into get stream Video", "ERROR");
       }
        return video;
    }
    

}


