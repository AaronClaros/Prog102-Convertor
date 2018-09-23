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
 * @authors Angelica
 * @version 0.1
 */
package com.foundations.convertor.utils;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Test Class to StyleUtils
 */
public class StyleUtilsTest {

    /**
     * Test method to create a image icon
     */
    @Test
    public void createImageIcon() {
        StyleUtils mockedUtils = mock(StyleUtils.class);
        String nameIco = "Error_26px.png";
        mockedUtils.createImageIcon(nameIco);
        verify(mockedUtils).createImageIcon(nameIco);
    }
}