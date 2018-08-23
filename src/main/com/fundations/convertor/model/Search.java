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
    private List<String> lFicheros=new ArrayList<String>();
    private String ruta;
    public Search(String ruta) {
        this.ruta = ruta;
    }
    public List<String> Found(){
        File dir= new File(ruta);
        String[] ficheros=dir.list();
            for(int x=0;x<ficheros.length;x++)
                lFicheros.add(ficheros[x]);
            return lFicheros;
    }
}
