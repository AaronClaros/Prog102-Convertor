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
 *
 * This class implements log4j using Singleton
 * @author Angelica Lopez - AWT-[01].
 * @version 0.1
 */
package com.foundations.convertor.utils;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Test class to Log Manager
 */
public class LoggerManagerTest {

    /**
     * Test method to return the log created
     */
    @Test
    public void log() {
        LoggerManager mockedLoggerManager = mock(LoggerManager.class);
        mockedLoggerManager.Log("Test Log Message","INFO");
        verify(mockedLoggerManager).Log("Test Log Message","INFO");
    }
}
