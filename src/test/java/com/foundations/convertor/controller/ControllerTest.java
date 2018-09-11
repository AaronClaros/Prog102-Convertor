package com.foundations.convertor.controller;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ControllerTest {
    @Test
    public void testDoSearch() {
        Controller mockedController = mock(Controller.class);
        mockedController.doSearch();
        verify(mockedController).doSearch();
    }

    @Test
    public void testFillTableData() {
        // auxiliar variable to verify
        File file;
        List<File> fileList = new ArrayList<File>();
        // mockito creation
        Controller mockedController = mock(Controller.class);

        // list of files
        file = new File("C:\\p0\\code.txt");
        fileList.add(file);
        file = new File("C:\\p0\\do.txt");
        fileList.add(file);
        file = new File("C:\\p0\\p1\\docPrueba.txt");
        fileList.add(file);
        file = new File("C:\\p0\\p1\\p2\\p3\\p4\\p5\\file5level.txt");
        fileList.add(file);
        file = new File("C:\\p0\\p1\\p2\\p3\\p4\\p5\\Sample.mp4");
        fileList.add(file);

        //when(mockedController.fillTableData(fileList)).thenReturn();
    }

    @Test
    public void testFillTableVideos() {
        // aux variable to verify
        File file;
        List<File> fileList = new ArrayList<File>();
        // mockito creation
        Controller mockedController = mock(Controller.class);

        // list of files
        file = new File("C:\\p0\\code.txt");
        fileList.add(file);
        file = new File("C:\\p0\\do.txt");
        fileList.add(file);
        file = new File("C:\\p0\\p1\\docPrueba.txt");
        fileList.add(file);
        file = new File("C:\\p0\\p1\\p2\\p3\\p4\\p5\\file5level.txt");
        fileList.add(file);
        file = new File("C:\\p0\\p1\\p2\\p3\\p4\\p5\\Sample.mp4");
        fileList.add(file);

        //when(mockedController.fillTableData(fileList)).thenReturn();
    }
}