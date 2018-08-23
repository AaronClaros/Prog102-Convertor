
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
package main.com.fundations.convertor.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *  Search class for java applications, class which search videos
 *
 * @author Kevin Sanchez - AWT-[01].
 * @version 0.1
 */

public class Search {
    private List<String> lFiles = new ArrayList<String>(); // list of file of the specified path
    private String path; // path that will be received for the search

    public Search(String path) {
        this.path = path;
    }

    /**
     * this method allows to create a list of String with files
     * from the given path, that list is returned to be used
     */
    public List<String> findPath(){
        File dir= new File(path);
        String[] files; // array of string for the files
        files = dir.list();

            /**this "for" send the recuperated data into the list*/
            for (int i = 0; i < files.length; i++) {
                lFiles.add(files[i]);
            }
            return lFiles;
    }
}
