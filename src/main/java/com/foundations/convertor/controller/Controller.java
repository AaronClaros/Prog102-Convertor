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

import com.foundations.convertor.common.ConversionCriteria;
import com.foundations.convertor.common.Criteria;
import com.foundations.convertor.model.Conversion.VideoConversion;
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
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */
public class Controller implements ActionListener, EventListener ,ListSelectionListener{

    private View view; // reference to object view
    private Search search; // reference to object search
    public static Criteria criteria; // reference to object criteria
    private ConversionCriteria conversionCriteria; // reference to object Criteria of conversion
    private String pathToConvert; // reference path to convert

    public Controller(){
        instanceCriteria();
        instanceViewComponent();
        instanceModelComponent();
        instanceConversionCriteria();
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

    public void instanceConversionCriteria() {
        view.getConvPanel().getConvertButton().addActionListener(this); // add actionListener for button convert
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
        if(resultsVideoList == null){
            LoggerManager.getLogger().Log("fillTable Videos: Result is null", "INFO");
            return;
        }
        view.getSLPanel().getResultsTable().setNumRows(resultsVideoList.size());
        for (int i=0; i<resultsVideoList.size(); i++){
            // Setting row data of table {"File Name","File Path","Duration","Extension","Frame Rate","Aspect Ratio",
            //            "Resolution","Video Codec","Audio Codec","Size"};
            Object[] d = {
                    resultsVideoList.get(i).getFileName(),resultsVideoList.get(i).getPathFile(),
                    resultsVideoList.get(i).getDuration(),resultsVideoList.get(i).getExt(),
                    formatFrameRate(resultsVideoList.get(i).getFrameRate()),resultsVideoList.get(i).getAspectRatio(),
                    resultsVideoList.get(i).getResolution(),resultsVideoList.get(i).getVideoCodec(),
                    resultsVideoList.get(i).getAudioCodec(),formatSize(resultsVideoList.get(i).getSize())};
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
     *
     * @param size formats Size as long to a String for "MB"
     * @return
     */
    private String formatSize(long size){
     if(size < 1000000)
        return (size/1000+" KB");
     else if(size < 1000000000)
         return (size/1000000+" MB");
         return (size/1000000000+" GB");
    }

    /**
     *
     * Execute a conversion of video
     */
    public void convertVideo(){
        ConverterUtils converterUtils=new ConverterUtils();
        conversionCriteria = new ConversionCriteria(pathToConvert);

        String resolution = view.getConvPanel().getCmbResolution().getSelectedItem().toString();
        conversionCriteria.setResolution(converterUtils.intExtensionWidth(resolution),converterUtils.intExtensionHeight(resolution));
        String frameRatio = view.getConvPanel().getCmbFrameRate().getSelectedItem().toString();
        conversionCriteria.setFramesPerSecond(converterUtils.stringToDouble(frameRatio));
        conversionCriteria.setVideoCodec(view.getConvPanel().getCmbVideoCodec().getSelectedItem().toString());
        conversionCriteria.setAudioCodec(view.getConvPanel().getCmbAudioCodec().getSelectedItem().toString());
        conversionCriteria.setOutputFormat(view.getConvPanel().getCmbFormat().getSelectedItem().toString());
        String newName = view.getConvPanel().getTxtName().getText();
        conversionCriteria.setOutputName(newName);
        String textOutPath = view.getConvPanel().getTFOutputPath().getText();
        conversionCriteria.setOutputDirectory(textOutPath);

        VideoConversion conversion = new VideoConversion();
        conversion.doConversion(conversionCriteria);

        // this method clean the fields of converter
        view.getConvPanel().cleanFields();
    }

    /**
     * Get the path to convert
     * @return path string
     */
    public String getPathToConvert() {
        return pathToConvert;
    }

    /**
     * Setting the path to convert
     * @param pathToConvert
     */
    public void setPathToConvert(String pathToConvert) {
        this.pathToConvert = pathToConvert;
    }

    /**
     * override method for event listener for button search when is pressed
     * and for button convert
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == view.getSPanel().getSearchButton()) {
            doSearch();
        }
        else if (src == view.getConvPanel().getConvertButton()) {
            convertVideo();
        }
    }

    /**
     * Override method for event list selected
     * @param e the event of row selected in the result table
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
      JTable resultsTable = view.getSLPanel().getTable();

      try {
          String pathSelected = resultsTable.getValueAt(resultsTable.getSelectedRow(), 1).toString();
          setPathToConvert(pathSelected);
          LoggerManager.getLogger().Log("SELECTED: "+pathSelected, "INFO");
          view.getConvPanel().getTFInputPath().setText(pathSelected);

      } catch (Exception ex){
          LoggerManager.getLogger().Log( ex.getMessage(), "Error");
        }
    }
}
