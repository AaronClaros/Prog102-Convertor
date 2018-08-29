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

import com.foundations.convertor.view.View;
import com.foundations.convertor.model.Search;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.EventListener;
import java.util.List;

/**
 *  Controller for use as pattern MVC, here is instanced the view and model classes
 *
 * @author Kevin Herrera - AWT-[01].
 * @version 0.1
 */
public class Controller implements ActionListener, EventListener {

    private View view; // reference to object view
    private Search search; // reference to object search
    private String search_path;

    public Controller(){
        System.out.println("creating object controller");
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
        //search = new Search(search_path);
        search = new Search();
    }

    /**
     * execute a search
     */
    public void doSearch(){
        search_path = view.getSPanel().getBoxPath().getText(); // storing reference for search path
        String name = view.getSPanel().getBoxFileName().getText();
        if (name == ""){
            fillTableData(search.getAllFilesOnPath(search_path));
        } else {
            fillTableData(search.getAllFilesByName(search_path, name ));
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
        String[] columnNames = {"File Name", "File Path", "Extension", "Frame Rate", "Duration", "Aspect Ratio",
                                "Dimension","Video Codec","Audio Codec"}; // names of columns for table
        Object[][] new_data = new Object[s_result_list.size()][columnNames.length]; //  data for table

        view.getSLPanel().getResultsTable().removeRow(0);
        for (int i=0; i<s_result_list.size(); i++){
            Object[] d = {s_result_list.get(i).getName(),s_result_list.get(i).getAbsolutePath(),"","","","","","",""}; // setting row data of table
            view.getSLPanel().getResultsTable().addRow(d); //creating row data
        }
        //DefaultTableModel model = new DefaultTableModel(new_data, columnNames);

    }

    /**
     * override method for event listener, here is listen button search when is pressed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        doSearch();
    }
}
