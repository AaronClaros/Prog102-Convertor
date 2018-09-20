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
package com.foundations.convertor.view;
/**
 *  Test Multimedia Player methods
 *
 * @authors Adrian Rojas - AWT-[01].
 * @version 0.1
 */

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MultimediaPlayerTest {

    @Test
    public void testStartWithVideo() {
        MultimediaPlayer mockedMultimediaPlayer = mock(MultimediaPlayer.class);
        mockedMultimediaPlayer.start("Samples/Sample 2.mp4");
        verify(mockedMultimediaPlayer).start("Samples/Sample 2.mp4");
    }
    @Test
    public void testStartWithAudio() {
        MultimediaPlayer mockedMultimediaPlayer = mock(MultimediaPlayer.class);
        mockedMultimediaPlayer.start("Samples/audio_files.sample.wav");
        verify(mockedMultimediaPlayer).start("Samples/audio_files.sample.wav");
    }

}