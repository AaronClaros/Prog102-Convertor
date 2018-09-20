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

import com.foundations.convertor.common.ConAudioCrit;
import com.foundations.convertor.common.ConversionCriteria;
import com.foundations.convertor.common.SearchCriteria;
import com.foundations.convertor.model.Conversion.AudioConversion;
import com.foundations.convertor.model.Conversion.VideoConversion;
import com.foundations.convertor.model.Multimedia.Audio;
import com.foundations.convertor.model.Multimedia.Multimedia;
import com.foundations.convertor.model.Multimedia.Video;
import com.foundations.convertor.utils.LoggerManager;
import com.foundations.convertor.view.ProgressBar;
import com.foundations.convertor.view.View;
import com.foundations.convertor.model.Search;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *  Controller for use as pattern MVC, here is instanced the view and model classes
 *
 * @authors Kevin Herrera, Kevin Sanchez, Adrian Rojas, Angelica Lopez - AWT-[01].
 * @version 0.1
 */
public class Controller implements ActionListener, EventListener ,ListSelectionListener {

    private View view; // reference to object view
    private Search search; // reference to object search
    public static SearchCriteria criteria; // reference to object criteria
    private ConversionCriteria conversionCriteria; // reference to object Criteria of conversion
    private String pathToConvert; // reference path to convert
    private Object [] headerAudio ={"File Name","File Path","Duration","Extension","Audio Codec","Sample Rate",
            "Bit Depth","Bit Rate","Channels","Size"};
    private Object[] headerVideo = {"File Name","File Path","Duration","Extension","Frame Rate","Aspect Ratio",
            "Resolution","Video Codec","Audio Codec","Size"};

    private ConAudioCrit conAudioCrit;
    VideoConversion conversion;
    AudioConversion audioConversion;
    ProgressBar progressBar;


    public Controller() {
        //instanceSearchCriteria();
        instanceViewComponent();
        instanceModelComponent();
        instanceConversionCriteria();
    }

    /**
     * instance the view object
     */
    public void instanceViewComponent() {
        view = new View();
        view.getSPanel().getSearchButton().addActionListener(this); // add actionListener for button search
        view.getSLPanel().getTable().getSelectionModel().addListSelectionListener(this);
    }

    /**
     * instance the search object
     */
    public void instanceModelComponent() {
        search = new Search();
    }

    public void instanceSearchCriteria() {
        criteria = new SearchCriteria();
    }

    public void instanceConversionCriteria() {
        view.getConvPanel().getConvertButton().addActionListener(this); // add actionListener for button convert
    }

    /**
     * execute a search
     */
    public void doSearch() {
        // this variables help to validate the fields
        String durFrom;
        String durTo;
        double secondsFrom = 0;
        double secondsTo = 0;
        //Set the criteria to the view fields
        criteria = new SearchCriteria();
        criteria.setPath(view.getSPanel().getBoxPath().getText());
        criteria.setFileName(view.getSPanel().getBoxFileName().getText());
        criteria.setExtension(view.getSPanel().getBoxFileExt().getSelectedItem().toString());
        // converting the given strings of Duration to search, into doubles
        durFrom = view.getSPanel().getBoxDurationFrom().getText();
        durTo = view.getSPanel().getBoxDurationTo().getText();
        String[] durFromList = durFrom.split(":");
        secondsFrom = Double.parseDouble(durFromList[0]) * 3600 + Double.parseDouble(durFromList[1]) * 60
                + Double.parseDouble(durFromList[2]);
        String[] durToList = durTo.split(":");
        secondsTo = Double.parseDouble(durToList[0]) * 3600 + Double.parseDouble(durToList[1]) * 60
                + Double.parseDouble(durToList[2]);
        //Set the criteria to the values entered in the view
        criteria.setDurFrom(secondsFrom);
        criteria.setDurTo(secondsTo);
        // validating duration from always lower than duration to Else the duration fields are reset to their default
        if (criteria.getDurFrom() > criteria.getDurTo()) {
            view.getSPanel().setDefaultDuration();
            criteria.setDurFrom(0);
            criteria.setDurTo(359999.0);
        }
        criteria.setAudioCodec(view.getSPanel().getCBVAudioCodec().getSelectedItem().toString());

        //Depending if the search audio check box is selected set the fields of criteria for audio or video
        if (!view.getSPanel().getToggleAudio().isSelected()) {
            //Validates if frame Rate is entered
            if (!view.getSPanel().getCBFrameRate().getSelectedItem().toString().isEmpty())
                criteria.setFrameRate(Double.parseDouble(view.getSPanel().getCBFrameRate().getSelectedItem().toString()));
            criteria.setResolution(view.getSPanel().getCBResolution().getSelectedItem().toString());
            criteria.setVideoCodec(view.getSPanel().getCBVideoCodec().getSelectedItem().toString());
            criteria.setAspectRatio(view.getSPanel().getCBAspectRatio().getSelectedItem().toString());
            view.getSLPanel().getResultsTable().setColumnIdentifiers(headerVideo);
            List<Multimedia> resultsList = search.searchVideoFiles(criteria);
            fillTable(resultsList);
        } else {

            if (!view.getSPanel().getComBoxbAudioBitRate().getSelectedItem().toString().isEmpty())
                criteria.setAudioBitRate(Integer.parseInt(view.getSPanel().getComBoxbAudioBitRate().
                        getSelectedItem().toString()));
            if (!view.getSPanel().getComBoxAudioSampleRate().getSelectedItem().toString().isEmpty())
                criteria.setAudioSampleRate(Integer.parseInt(view.getSPanel().getComBoxAudioSampleRate().
                        getSelectedItem().toString()));
            if (!view.getSPanel().getComBoxAudioChannels().getSelectedItem().toString().isEmpty())
                criteria.setAudioChannels(Integer.parseInt(view.getSPanel().getComBoxAudioChannels().
                        getSelectedItem().toString()));
            if (!view.getSPanel().getComBoxAudioBitDepth().getSelectedItem().toString().isEmpty())
                criteria.setAudioBitDepth(view.getSPanel().getComBoxAudioBitDepth().
                        getSelectedItem().toString());
            view.getSLPanel().getResultsTable().setColumnIdentifiers(headerAudio);
            List<Multimedia> resultsList = search.searchAudioFiles(criteria);
            fillTable(resultsList);
        }
    }

    /**
     * Fill the UI table with a video information
     *
     * @param video on the list
     * @return return the object with the videos metadata
     */
    private Object[] fillRowVideo(Video video) {
        // Setting row data of table {"File Name","File Path","Duration","Extension","Frame Rate","Aspect Ratio",
        //            "Resolution","Video Codec","Audio Codec","Size"};
        Object[] d = {
                video.getFileName(), video.getPathFile(),
                video.getDuration(), video.getExt(),
                formatFrameRate(video.getFrameRate()), video.getAspectRatio(),
                video.getResolution(), video.getVideoCodec(),
                video.getAudioCodec(), formatSize(video.getSize())};
        return d;
    }

    /**
     * Fill the UI table with a audio information
     *
     * @param audio on the list
     * @return return the object with the audios metadata
     */
    private Object[] fillRowAudio(Audio audio) {
        // Setting row data of table {"File Name","File Path","Duration","Extension"
        //            //            ,"Audio Codec", sample rate, bit depth,bit rate,"Channels","Size"};
        Object[] d = {
                audio.getFileName(), audio.getPathFile(),
                audio.getDuration(), audio.getExt(),
                audio.getAudioCodec(), audio.getSampleRate(), audio.getBitDepth(), audio.getBitRate(), audio.getChannels(),formatSize(audio.getSize())};
        return d;
    }

    /**
     * Fill table from View with the list of videos from the search results
     *
     * @param resultsList List of videos within the search criteria
     */
    private void fillTable(List<? extends Multimedia> resultsList) {
        if (resultsList == null) {
            LoggerManager.getLogger().Log("Table Multimedia: Result is null", "INFO");
            return;
        }
        view.getSLPanel().getResultsTable().setNumRows(resultsList.size());
        for (int i = 0; i < resultsList.size(); i++) {

            Object[] d;
            //TODO
            if (resultsList.get(i) instanceof Video) {
                Video v = (Video) resultsList.get(i);
                d = fillRowVideo(v);
            } else {
                Audio a = (Audio) resultsList.get(i);
                d = fillRowAudio(a);
            }
            // cleaning row data
            view.getSLPanel().getResultsTable().removeRow(i);
            // adding new row data
            view.getSLPanel().getResultsTable().insertRow(i, d);
        }
    }

    /**
     * @param fr the double for frame rate
     * @return returns a String with the double formatted
     */
    private String formatFrameRate(double fr) {
        if ((fr * 10) % 10 > 0)
            return String.format("%.2f", fr);
        else return String.format("%.0f", fr);
    }

    /**
     * @param size formats Size as long to a String for "MB"
     * @return return the size for UI
     */
    private String formatSize(long size) {
        if (size < 1000000)
            return (size / 1000 + " KB");
        else if (size < 1000000000)
            return (size / 1000000 + " MB");
        return (size / 1000000000 + " GB");
    }

    /**
     * Execute a conversion of video
     */
    private void convertVideo() {
        //Instance conversion criteria
        conversionCriteria = new ConversionCriteria();
        //Set conversion criteria fields with converter panel
        conversionCriteria.setPath(pathToConvert);
        conversionCriteria.setResolution(view.getConvPanel().getCmbResolution().getSelectedItem().toString());
        conversionCriteria.setVideoCodec(view.getConvPanel().getCmbVideoCodec().getSelectedItem().toString());
        conversionCriteria.setAudioCodec(view.getConvPanel().getCmbAudioCodec().getSelectedItem().toString());
        conversionCriteria.setExtension(view.getConvPanel().getCmbFormat().getSelectedItem().toString());
        conversionCriteria.setFileName(view.getConvPanel().getTxtName().getText());
        conversionCriteria.setOutputDirectory(view.getConvPanel().getTFOutputPath().getText());
        if (!view.getConvPanel().getCmbFrameRate().getSelectedItem().toString().isEmpty()) {
            conversionCriteria.setFrameRate(Double.parseDouble(view.getConvPanel().getCmbFrameRate().getSelectedItem().toString()));
        }

        conversion = new VideoConversion();
        progressBar = new ProgressBar();
        conversion.getProgressPercentageProperty().addListener(progressBar);
        conversion.doConversion(conversionCriteria);
        // this method clean the fields of converter
        view.getConvPanel().cleanFields();
    }
    /**
     * execute an audio conversion
     */
    public void convertAudio(){
        conAudioCrit = new ConAudioCrit();
        conAudioCrit.setPath(pathToConvert);
        conAudioCrit.setAudioCodec(view.getConvPanel().getCmbAudioCodec().getSelectedItem().toString());
        conAudioCrit.setExtension(view.getConvPanel().getCmbFormat().getSelectedItem().toString());
        conAudioCrit.setFileName(view.getConvPanel().getTxtName().getText());
        conAudioCrit.setOutputDirectory(view.getConvPanel().getTFOutputPath().getText());
        if (view.getConvPanel().getSearchAudioPanel().getcbSampleRate().getSelectedItem()==""){
            conAudioCrit.setSampleRate(0);
        }else {
            conAudioCrit.setSampleRate(Integer.parseInt(view.getConvPanel().getSearchAudioPanel().getcbSampleRate()
                                        .getSelectedItem().toString()));
        }
        if (view.getConvPanel().getSearchAudioPanel().getcbBitRate().getSelectedItem()==""){
            conAudioCrit.setBitRate(0);
        }else {
            conAudioCrit.setBitRate(Long.parseLong(view.getConvPanel().getSearchAudioPanel().getcbBitRate()
                                                    .getSelectedItem().toString()));
        }
        conAudioCrit.setBitDepth(view.getConvPanel().getSearchAudioPanel().getcbBitDepth().getSelectedItem().toString());
        if (view.getConvPanel().getSearchAudioPanel().getcbChannels().getSelectedItem()==""){
            conAudioCrit.setChannels(0);
        }else {
            conAudioCrit.setChannels(Integer.parseInt(view.getConvPanel().getSearchAudioPanel().getcbChannels()
                                                        .getSelectedItem().toString()));
        }

        audioConversion = new AudioConversion();
        progressBar = new ProgressBar();
        audioConversion.getProgressPercentageProperty().addListener(progressBar);
        audioConversion.doConversion(conAudioCrit);
        // this method clean the fields of converter
        view.getConvPanel().cleanFields();
    }

    /**
     * Setting the path to convert
     *
     * @param pathToConvert returns the output path for conversion
     */
    private void setPathToConvert(String pathToConvert) {
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
            if (!view.getSPanel().getBoxPath().getText().isEmpty()) {
                view.getSPanel().setPathRequiredDefault();
                try{
                    doSearch();
                } catch (Exception ex){
                    LoggerManager.getLogger().Log("Error: Path is not valid "+ex,"ERROR");
                    view.errorMessage("Path is not valid");
                }

            } else {
                view.getSPanel().setPathRequiredRed();
                view.errorMessage("Path is a required field");
            }
        }
        if (src == view.getConvPanel().getConvertButton() && view.getConvPanel().getCheckBoxAudio().isSelected()) {
            convertAudio();
        }else{
            convertVideo();
        }
    }

    /**
     * Override method for event list: selected a field in the table setting the path of the file on the converter panel
     *
     * @param e the event of row selected in the result table
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        try {
            String pathSelected = view.getSLPanel().getTable().getValueAt(view.getSLPanel().getTable().getSelectedRow(), 1).toString();
            setPathToConvert(pathSelected);
            LoggerManager.getLogger().Log("SELECTED: " + pathSelected, "INFO");
            view.getConvPanel().getTFInputPath().setText(pathSelected);

        } catch (Exception ex) {
            LoggerManager.getLogger().Log(ex.getMessage(), "Error");
        }
    }
}
