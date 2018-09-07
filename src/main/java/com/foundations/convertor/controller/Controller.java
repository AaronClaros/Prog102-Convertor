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
import com.foundations.convertor.model.Video.Video;
import com.foundations.convertor.utils.ConverterUtils;
import com.foundations.convertor.utils.LoggerManager;
import com.foundations.convertor.view.View;
import com.foundations.convertor.model.Search;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.EventListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *  Controller for use as pattern MVC, here is instanced the view and model classes
 *
 * @authors Kevin Herrera, Kevin Sanchez - AWT-[01].
 * @version 0.1
 */
public class Controller implements ActionListener, EventListener ,ListSelectionListener{

    private View view; // reference to object view
    private Search search; // reference to object search
    private Criteria criteria; // reference to object criteria
    private String pathSelected;

    public Controller(){
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
        view.getSLPanel().getTable().getSelectionModel().addListSelectionListener(this);
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
        criteria.setExtension(view.getSPanel().getBoxFileExt().getSelectedItem().toString());
        criteria.setAspcRatio(view.getSPanel().getCBAspectRatio().getSelectedItem().toString());
        criteria.setAudioCodec(view.getSPanel().getCBVAudioCodec().getSelectedItem().toString());
        criteria.setFrameRate(view.getSPanel().getCBFrameRate().getSelectedItem().toString());
        criteria.setResolution(view.getSPanel().getCBResolution().getSelectedItem().toString());
        criteria.setVideoCodec(view.getSPanel().getCBVideoCodec().getSelectedItem().toString());
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
        /**
         * Calls the method to fill the table using the search methods
         * Only should need to call method
         *
         */
        List<Video> resultsVideoList =  search.getAllVideoFiles(criteria);
        fillTableVideos(resultsVideoList);
    }

    /**
     * Fill table from View with the list of videos from the search results
     * @param resultsVideoList List of videos within the search criteria
     */
    public void fillTableVideos(List<Video> resultsVideoList){
        if(resultsVideoList==null){
            LoggerManager.getLogger().Log("fillTable Videos: Result is null", "INFO");
            return;
        }
        view.getSLPanel().getResultsTable().setNumRows(resultsVideoList.size());
        for (int i=0; i<resultsVideoList.size(); i++){
            // Setting row data of table ("name", "path", Extension", "Resolution","Frame Rate",
            // "Duration","Aspect Ratio","Dimension","Video Codec","Audio Codec")
            Object[] d = {resultsVideoList.get(i).getFileName(),resultsVideoList.get(i).getPathFile(),
                    resultsVideoList.get(i).getExt(),resultsVideoList.get(i).getResolution(),
                    resultsVideoList.get(i).getFrameRate(),resultsVideoList.get(i).getDuration(),
                    resultsVideoList.get(i).getAspectRatio(),resultsVideoList.get(i).getVideoCodec(),
                    resultsVideoList.get(i).getAudioCodec()};
            // cleaning row data
            view.getSLPanel().getResultsTable().removeRow(i);
            // adding new row data
            view.getSLPanel().getResultsTable().insertRow(i,d);
        }
    }
    /**
     * override method for event listener for button search when is pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        doSearch();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
      JTable resultsTable = view.getSLPanel().getTable();
      String pathSelected = resultsTable.getValueAt(resultsTable.getSelectedRow(), 1).toString();
      LoggerManager.getLogger().Log("SELECTED: "+pathSelected, "INFO");
      view.getConvPanel().getTFInputPath().setText(pathSelected);
    }
}
