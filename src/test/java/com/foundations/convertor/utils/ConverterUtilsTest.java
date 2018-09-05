package com.foundations.convertor.utils;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Timestamp;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    public void doubleToTimeString(){
        ConverterUtils mockedConverter = mock(ConverterUtils.class);
        double time = 5.28;
        when(mockedConverter.doubleToTimeString(time)).thenReturn("00:00:05");
        System.out.println(mockedConverter.doubleToTimeString(time));
    }

    @Test
    public void extension(){
        ConverterUtils mockedConverter = mock(ConverterUtils.class);
        when(mockedConverter.extension(4,5)).thenReturn("4X5");
        System.out.println(mockedConverter.extension(4,5));
    }
}