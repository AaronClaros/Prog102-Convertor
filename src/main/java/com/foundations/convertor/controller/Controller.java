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

package com.foundations.convertor.controller;

import com.foundations.convertor.common.Criteria;
import com.foundations.convertor.utils.ConverterUtils;
import com.foundations.convertor.view.View;
import com.foundations.convertor.model.Search;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Timestamp;
import java.util.EventListener;
import java.util.List;

/**
 *  Controller for use as pattern MVC, here is instanced the view and model classes
 *
 * @authors Kevin Herrera, Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class Controller implements ActionListener, EventListener {

    private View view; // reference to object view
    private Search search; // reference to object search
    private Criteria criteria; // reference to object criteria

    public Controller(){
        System.out.println("creating object controller");
        instanceCriteria();
        instanceViewComponent();
        instanceModelComponent();
    }

    /**
     * instance the view object
     */
    public void instanceViewComponent(){
        view = new View();
        view.getSPanel().getSearchButton().addActionListener(this); // add actionListener for button search
    }

    /**
     *  instance the search object
     */
    public void instanceModelComponent(){
        search = new Search();
    }

    public void instanceCriteria(){
        criteria = new Criteria();
    }

    /**
     * execute a search
     */
    public void doSearch(){
        ConverterUtils converterUtils=new ConverterUtils();

        // this variables help to validate the fields
        String durFrom;
        String durTo;
        Timestamp timeFrom;
        Timestamp timeTo;
        Timestamp timeAux;

        criteria.setPath(view.getSPanel().getBoxPath().getText());
        criteria.setFileName(view.getSPanel().getBoxFileName().getText());
        criteria.setExtension(view.getSPanel().getBoxFileExt().getText());
        durFrom = view.getSPanel().getBoxDurationFrom().getText();
        durTo = view.getSPanel().getBoxDurationTo().getText();

        // converting the given string to search into timestamp
        timeFrom = converterUtils.stringToTime(durFrom);
        timeTo = converterUtils.stringToTime(durTo);

        // validating duration from always lower than duration to
        if (timeFrom.getTime() >timeTo.getTime()){
            timeAux = timeFrom;
            timeFrom = timeTo;
            timeTo = timeAux;
        }

        // validating the time will be in a range to search
        if (timeFrom.getTime() == timeTo.getTime()){
            timeTo.setTime(timeTo.getTime()+3600000);
        }

        criteria.setDurFrom(timeFrom);
        criteria.setDurTo(timeTo);

        if (criteria.getFileName() == ""){
            fillTableData(search.getAllFilesOnPath(criteria.getPath()));
        } else {
            fillTableData(search.getAllFilesByName(criteria.getPath(), criteria.getFileName()));
        }
    }

    /**
     * fill table on view with search results
     * @param s_result_list list of results of search
     */
    public void fillTableData(List<File> s_result_list){
        if (s_result_list==null){
            System.out.println("results list null");
            return;
        }
        view.getSLPanel().getResultsTable().setNumRows(s_result_list.size());
        for (int i=0; i<s_result_list.size(); i++){
            // setting row data of table ("name", "path", Extension", "Frame Rate", "Duration",
            //                            "Aspect Ratio","Dimension","Video Codec","Audio Codec")
            Object[] d = {s_result_list.get(i).getName(),s_result_list.get(i).getAbsolutePath(),"","","","","","",""};
            // cleaning row data
            view.getSLPanel().getResultsTable().removeRow(i);
            // adding new row data
            view.getSLPanel().getResultsTable().insertRow(i,d);
        }
    }

    /**
     * override method for event listener, here is listen button search when is pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        doSearch();
    }
}
