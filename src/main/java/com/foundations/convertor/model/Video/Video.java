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
 *
 * This wrapper to fill the Video Information
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */
package com.foundations.convertor.model.Video;

public class Video {
  //Field to get/set the duration
  private Double duration;
  //Field to get/set the path file
  private String pathFile;
  //Field to get/set the file name
  private String fileName;
  //Field to get/set the f rate
  private Double fRate;
  //Field to get/set the a ratio
  private String aRatio;
  //Field to get/set the resolution
  private String resolution;
  //Field to get/set the video codec
  private String vCodec;
  //Field to get/set the a codec
  private String aCodec;
  //Field to get/set the extension
  private String ext;
  //Field for Size
  private long size;

  //return the duration
  public Double getDuration() {
    return duration;
  }
  //setting the duration
  public void setDuration(Double duration) {
    this.duration = duration;
  }
  //return the path file
  public String getPathFile() {
    return pathFile;
  }
  //setting the path file
  public void setPathFile(String pathFile) {
    this.pathFile = pathFile;
  }
  //return the file name
  public String getFileName() {
    return fileName;
  }
  //setting the file name
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }
  //return the frame rate
  public double getFrameRate() { return fRate; }
  //setting the frame rate
  public void setFrameRate(double fRate) {
    this.fRate = fRate;
  }
  //return the audio ratio
  public String getAspectRatio() {
    return aRatio;
  }
  //setting the audio ratio
  public void setAspectRatio(String aRatio) {
    this.aRatio = aRatio;
  }
  //return the resolution
  public String getResolution() {
    return resolution;
  }
  //setting the resolution
  public void setResolution(String resolution) {
    this.resolution = resolution;
  }
  //return video codec format
  public String getVideoCodec() {
    return vCodec;
  }
  //setting the video codec
  public void setVideoCodec(String vCodec) {
    this.vCodec = vCodec;
  }
  //return audio codec
  public String getAudioCodec() {
    return aCodec;
  }
  //setting the audio codec
  public void setAudioCodec(String aCodec) {
    this.aCodec = aCodec;
  }
  //setting extension
  public void setExt(String ext) {
    this.ext = ext;
  }
  //return extension
  public String getExt() { return ext; }
  public void setSize(Long size){this.size = size;}
  public Long getSize (){ return this.size; }
}
