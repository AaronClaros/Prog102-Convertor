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
package com.foundations.convertor.view;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Test to class Messages View dialog
 */
public class MessagesTest {


    /**
     * Test method to create the message question
     */
    @Test
    public void questionMessage() {
        Messages mockedMessage = mock(Messages.class);
        mockedMessage.questionMessage("Test message question","Message Test Dialog");
        verify(mockedMessage).questionMessage("Test message question","Message Test Dialog");
    }

    /**
     * Test method to create the information message
     */
    @Test
    public void informationMessage() {
        Messages mockedMessage = mock(Messages.class);
        mockedMessage.informationMessage("Test message information","Message Test Dialog");
        verify(mockedMessage).informationMessage("Test message information","Message Test Dialog");
    }

    /**
     * Test method to create the warning message
     */
    @Test
    public void warningMessage() {
        Messages mockedMessage = mock(Messages.class);
        mockedMessage.warningMessage("Test message warning","Message Test Dialog");
        verify(mockedMessage).warningMessage("Test message warning","Message Test Dialog");
    }

    /**
     * Test method to create the error message
     */
    @Test
    public void errorMessage() {
        Messages mockedMessage = mock(Messages.class);
        mockedMessage.errorMessage("Test message error","Message Test Dialog");
        verify(mockedMessage).errorMessage("Test message error","Message Test Dialog");
    }

    /**
     * Test method to create the cancel message
     */
    @Test
    public void cancelMessage() {
        Messages mockedMessage = mock(Messages.class);
        mockedMessage.cancelMessage("Test message cancel","Message Test Dialog");
        verify(mockedMessage).cancelMessage("Test message cancel","Message Test Dialog");
    }
}