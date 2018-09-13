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
 */
package com.foundations.convertor.model.Multimedia;
/**
 *  Video type class
 *
 * @author Angelica Lopez, Adrian Rojas - AWT-[01].
 * @version 0.1
 */
public class Video extends Multimedia {
  //Field to get/set the f rate
  private Double fRate;
  //Field to get/set the a ratio
  private String aRatio;
  //Field to get/set the resolution
  private String resolution;
  //Field to get/set the video codec
  private String vCodec;

    /**
     * get video frame rate
     * @return frame rate
     */
  public double getFrameRate() { return fRate; }

    /**
     * set Frame rate of video
     * @param fRate of video
     */
  public void setFrameRate(double fRate) {
    this.fRate = fRate;
  }

    /**
     * get video aspect ratio
     * @return the aspect ratio
     */
  public String getAspectRatio() {
    return aRatio;
  }

    /**
     * set video aspect ratio
     * @param aRatio of video
     */
  public void setAspectRatio(String aRatio) {
    this.aRatio = aRatio;
  }

    /**
     * get video resolution as hXw
     * @return resolution of video
     */
  public String getResolution() {
    return resolution;
  }

    /**
     * Set resolution
     * @param resolution of video
     */
  public void setResolution(String resolution) {
    this.resolution = resolution;
  }

    /**
     * get the video coded
     * @return video codec of the video
     */
  public String getVideoCodec() {
    return vCodec;
  }

    /**
     * Set the video Coded
     * @param vCodec of the video
     */
  public void setVideoCodec(String vCodec) {
    this.vCodec = vCodec;
  }
}
