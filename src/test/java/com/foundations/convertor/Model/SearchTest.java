/*
 *
 *  Copyright (c) 2018 Jala Foundation.
 *  2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of
 *  Jala Foundation, ("Confidential Information").  You shall not
 *  disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Jala Foundation.
 *
 */

package com.foundations.convertor.Model;

import com.foundations.convertor.common.SearchCriteria;
import com.foundations.convertor.model.Search;
import org.junit.Test;

import java.io.File;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author KevinHerrera - AWT-[01].
 * @version 0.1
 */
public class SearchTest {
    @Test
    public void testSearchAudioFiles() {
        Search mockedSearch = mock(Search.class);
        SearchCriteria criteria = new SearchCriteria();
        criteria.setPath("C:\\Projects Intellij\\Prog102-Convertor\\samples");
        mockedSearch.searchAudioFiles(criteria);
        verify(mockedSearch).searchAudioFiles(criteria);
    }

    @Test
    public void testSearchVideoFiles() {
        Search mockedSearch = mock(Search.class);
        SearchCriteria criteria = new SearchCriteria();
        criteria.setPath("C:\\Projects Intellij\\Prog102-Convertor\\samples");
        mockedSearch.searchVideoFiles(criteria);
        verify(mockedSearch).searchVideoFiles(criteria);
    }

    @Test
    public void testIsVideo() {
        Search mockedSearch = mock(Search.class);
        File file = new File("C:\\Projects Intellij\\Prog102-Convertor\\samples\\Sample.mp4");
        when(mockedSearch.isVideo(file)).thenReturn(true);
    }

    @Test
    public void testIsAudio() {
        Search mockedSearch = mock(Search.class);
        File file = new File("C:\\Projects Intellij\\Prog102-Convertor\\samples\\audio_files\\30Hz.flac");
        when(mockedSearch.isAudio(file)).thenReturn(true);
    }


}
