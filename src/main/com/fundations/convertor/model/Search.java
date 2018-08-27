
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Search class for java applications, class which search videos
 *
 * @author Kevin Sanchez - AWT-[01].
 * @version 0.4
 */

public class Search {
    private List<File> lFiles = new ArrayList<File>(); // list of file of the specified path

    public Search() {
    }

    /**
     * this method allows to create a list of String with files
     * from the given path, that list is returned to be used
     */
    public List<File> getAllFilesOnPath(String path){
        File dir = new File(path);
        File auxFile; // is declared to help prove if it is a file o folder
        String[] files; // array of string for the files
        files = dir.list();

            /**this "for" send the recuperated data into the list*/
            for (int i = 0; i < files.length; i++) {

                /**
                 * File class need a path to create an instance
                 * the path given is the construction of de actual
                 * path and the file we want to check
                 */
                auxFile = new File(path+"\\"+files[i]);

                /**this part check if the given path is a file
                 * if It is a file It will be add to the list
                 * else It will be check for the same method again
                 */
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
     */
    public List<File> getAllFilesByName(String path, String name){
        List<File> newListFiles = new ArrayList<File>(); // list of files of the specified path
        List<File> aFiles = new ArrayList<File>(); // auxiliar list of files rececived to filter
        int sizeList; // Size of the non-filter list
        lFiles.clear(); // it will clean the list just in case that some information keeps on it
        sizeList = getAllFilesOnPath(path).size();
        aFiles = getAllFilesOnPath(path);

        for (int i = 0; i < sizeList; i++){

            /**this condition will filter the auxiliar list
             * with the file name and it will be returned
            */
            if (aFiles.get(i).getName().contains(name)){

                newListFiles.add(aFiles.get(i));
            }
        }
        return newListFiles;
    }
}
