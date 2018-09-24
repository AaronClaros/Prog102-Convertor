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
 * @author Kevin Sanchez - AWT-[01].
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */
package com.foundations.convertor.utils;

import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;
import java.sql.Timestamp;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * ConverterUtilsTest class allows to test the convert data types
 */
public class ConverterUtilsTest {

    /**
     * this method validates the method stringToTime from ConverterUtils class
     */
    @Test
    public void testStringToTime() {

        // validation variable
        Timestamp timestamp;
        // mockito creation
        ConverterUtils mockedConverter = mock(ConverterUtils.class);
        timestamp = new Timestamp(32760000L);
        when(mockedConverter.stringToTime("00:09:06.58")).thenReturn(timestamp);
        // it shows the answer for the process made
        System.out.println(mockedConverter.stringToTime("00:09:06.58").getTime());
    }

    /**
     * this method validates the method timeToString from ConverterUtils class
     */
    @Test
    public void testTimeToString() {
        ConverterUtils mockedConverter = mock(ConverterUtils.class);
        when(mockedConverter.timeToString(32760000L)).thenReturn("00:09:06.58");
        System.out.println(mockedConverter.timeToString(32760000L));
    }

    /**
     * this method validates the method doubleToTimeString from ConverterUtils class
     */
    @Test
    public void doubleToTimeString(){
        ConverterUtils mockedConverter = mock(ConverterUtils.class);
        double time = 5.28;
        when(mockedConverter.doubleToTimeString(time)).thenReturn("00:00:05");
        System.out.println(mockedConverter.doubleToTimeString(time));
    }

    /**
     * this method validates the method extensionToString from ConverterUtils class
     */
    @Test
    public void extensionToString(){
        ConverterUtils mockedConverter = mock(ConverterUtils.class);
        when(mockedConverter.extensionToString(4,5)).thenReturn("4X5");
        System.out.println(mockedConverter.extensionToString(4,5));
    }

    /**
     * this method validates the method frameRateToString from ConverterUtils class
     */
    @Test
    public void frameRateToString(){
        Fraction fraction = Fraction.getFraction(25,1);
        ConverterUtils mockedConverter = mock(ConverterUtils.class);
        when(mockedConverter.frameRateToString(fraction)).thenReturn("25/1");
        System.out.println(mockedConverter.frameRateToString(fraction));
    }

    /**
     * This test verify the split by regex X -> 1920X1080
     */
    @Test
    public void SplitString(){
        ConverterUtils mockedConverter = mock(ConverterUtils.class);
        String[]resultExpected = {"1920","1080"};
        when(mockedConverter.splitString("1920X1080")).thenReturn(resultExpected);
        System.out.println(mockedConverter.splitString("1920X1080").length);
    }
}
