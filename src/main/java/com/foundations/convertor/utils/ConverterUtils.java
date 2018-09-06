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

import java.sql.Timestamp;
import org.apache.commons.lang3.math.Fraction;

/**
 *  ConverterUtils class allows to convert data types
 */
public class ConverterUtils {

    /**
     * Empty constructor
     */
    public ConverterUtils(){
    }

    /**
     * this method allows to convert from miliseconds
     * to a string with the format hh:mm:ss
     * @param time It will be in milliseconds
     * @return it will return the time in the format hh:mm:ss
     */
    public  String timeToString(Long time){

        // this variable allows to convert the number in
        // milliseconds to seconds, minutes and hours
        long seconds;
        long minutes;
        long hours;

        // this variables help to construct the string
        //according to the format hh:mm:ss
        String stringSeconds;
        String stringMinutes;
        String stringHours;

        seconds = time / 1000;
        hours = seconds / 3600;
        seconds -= hours * 3600;

        minutes = seconds / 60;
        seconds -= minutes * 60;

        // this conditions allows to change values
        // from 1 to 01 depending if it is seconds
        // minutes or hours
        if (seconds < 10){
            stringSeconds = "0" + seconds;
        }else{
            stringSeconds = Long.toString(seconds);
        }

        if (minutes < 10){
            stringMinutes = "0" + minutes;
        }else{
            stringMinutes = Long.toString(minutes);
        }

        if (hours < 10){
            stringHours = "0" + hours;
        }else{
            stringHours = Long.toString(hours);
        }

        return stringHours+":"+stringMinutes+":"+stringSeconds;
    }

    /**
     * @param time it will be a string with the format hh:mm:ss
     * @return it will return a timestamp value
     */
    public  Timestamp stringToTime(String time){

        // this variables will contain the equivalent value
        // for seconds, minutes, hours in milliseconds
        long seconds;
        long minutes;
        long hours;

        seconds = Long.parseLong(time.substring(6,8)) * 1000;
        minutes = Long.parseLong(time.substring(3,5)) * 60000;
        hours = Long.parseLong(time.substring(0,2)) * 3600000;

        Timestamp dur = new Timestamp(hours + minutes + seconds);
        return dur;
    }

    /**
     * Convert a double to Time String
     * @param time receive a double time
     * @return time string
     */
    public  String doubleToTimeString(double time){
        double timeReal = time * 1000;
        long longSeconds = (long) timeReal;
        String res = timeToString(longSeconds);
        return res;
    }

    /**
     * Convert two int number to string format extension
     * @param x receive a int
     * @param y receive a int
     * @return
     */
    public String extensionToString(int x, int y){

        return String.valueOf(x) + "X" + String.valueOf(y);
    }

    /**
     * Convert a Fraction to String
     * @param fraction receive
     * @return string fraction
     */
    public String frameRateToString(Fraction fraction){
        return fraction.toString();
    }
}

