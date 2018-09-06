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

public class MMVideoFile {
  //Field to get/set the title
  String title;
  //Field to get/set the duration
  String duration;
  //Field to get/set the path file
  String pathFile;
  //Field to get/set the file name
  String fileName;
  //Field to get/set the f rate
  String fRate;
  //Field to get/set the a ratio
  String aRatio;
  //Field to get/set the resolution
  String resolution;
  //Field to get/set the video codec
  String vCodec;
  //Field to get/set the a codec
  String aCodec;
  //Field to get/set the extension
  String ext;

  //return the title
  public String getTitle() {
    return title;
  }
  //setting the title
  public void setTitle(String title) {
    this.title = title;
  }
  //return the duration
  public String getDuration() {
    return duration;
  }
  //setting the duration
  public void setDuration(String duration) {
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
  //return the f rate
  public String getfRate() {
    return fRate;
  }
  //setting the f rate
  public void setfRate(String fRate) {
    this.fRate = fRate;
  }
  //return the a ratio
  public String getaRatio() {
    return aRatio;
  }
  //setting the a ratio
  public void setaRatio(String aRatio) {
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
  //return vide codec format
  public String getvCodec() {
    return vCodec;
  }
  //setting the video codec
  public void setvCodec(String vCodec) {
    this.vCodec = vCodec;
  }
  //return a codec
  public String getaCodec() {
    return aCodec;
  }
  //setting the a codec
  public void setaCodec(String aCodec) {
    this.aCodec = aCodec;
  }
  //setting extension
  public void setExt(String ext) {
    this.ext = ext;
  }
  //return extension
  public String getExt() {
    return ext;
  }
}
