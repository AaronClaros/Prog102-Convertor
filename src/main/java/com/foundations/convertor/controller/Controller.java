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
import java.util.EventListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
        // this variables help to validate the fields
        String durFrom;
        String durTo;
        double secondsFrom = 0;
        double secondsTo = 0;

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
        // converting the given strings of Duration to search, into doubles
        String [] durFromList = durFrom.split(":");
        secondsFrom = Double.parseDouble(durFromList[0])*3600+ Double.parseDouble(durFromList[1])*60
                + Double.parseDouble(durFromList[2]);
        String [] durToList = durTo.split(":");
        secondsTo = Double.parseDouble(durToList[0])*3600+ Double.parseDouble(durToList[1])*60
                + Double.parseDouble(durToList[2]);
        //Set the criteria to the values entered in the view
        criteria.setDurFrom(secondsFrom);
        criteria.setDurTo(secondsTo);
        // validating duration from always lower than duration to Else the duration fields are reset to their default
        if (criteria.getDurFrom()>criteria.getDurTo()){
            view.getSPanel().setDefaultDuration();
            criteria.setDurFrom(0);
            criteria.setDurTo(359999.0);
        }       /**
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
                    formatFrameRate(resultsVideoList.get(i).getFrameRate()),
                    resultsVideoList.get(i).getDuration(),
                    resultsVideoList.get(i).getAspectRatio(),resultsVideoList.get(i).getVideoCodec(),
                    resultsVideoList.get(i).getAudioCodec()};
            // cleaning row data
            view.getSLPanel().getResultsTable().removeRow(i);
            // adding new row data
            view.getSLPanel().getResultsTable().insertRow(i,d);
        }
    }

    /**
     *
     * @param fr the double for frame rate
     * @return returns a String with the double formatted
     */
    private String formatFrameRate(double fr){
        if((fr*10)%10>0)
        return String.format("%.2f",fr);
        else return String.format("%.0f",fr);
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
