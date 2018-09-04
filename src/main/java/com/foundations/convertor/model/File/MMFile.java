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
 * This class define the basic characteristics of a multimedia file
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */

package com.foundations.convertor.model.File;
import com.foundations.convertor.common.Criteria;
import com.sun.istack.internal.NotNull;

public abstract class MMFile {
    //fileName is the variable to set and get the name
    private String fileName;
    //filePath is the variable to set and get the path
    private String filePath;

    public MMFile(@NotNull Criteria criteria){
        setFileName(criteria.getFileName());
        setFilePath(criteria.getPath());
    }

    //get the MM name
    public String getFileName() {
        return fileName;
    }

    //set the MM name
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    //get the MM path
    public String getFilePath() {
        return filePath;
    }

    //set the MM path
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
