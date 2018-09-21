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
 * @authors Angelica
 * @version 0.1
 */
package com.foundations.convertor.utils;
import javax.swing.ImageIcon;
import java.io.File;
/**
 *  Class Util to find the path image
 */
public class StyleUtils {
    private static final StyleUtils instance = new StyleUtils();

  // Singleton
    private StyleUtils() {
    }

    public static StyleUtils getInstance() {
      return instance;
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    public ImageIcon createImageIcon(String file) {
      String separator = System.getProperty("file.separator");
      String imagesPath = "";

      try {
        imagesPath = new File(".").getCanonicalFile() + separator + "resources" + separator + "images"+separator+ file;
      }
      catch (Exception e){
        LoggerManager.getLogger().Log("Error to create Image Icon","ERROR");
      }
      if (imagesPath != null) {
        return new ImageIcon(imagesPath);
      } else {
        LoggerManager.getLogger().Log("Couldn't find file: " + imagesPath,"ERROR");
        return null;
      }
    }
}
