package com.foundations.convertor.Model.Conversion;

import com.foundations.convertor.common.ConversionVideoCriteria;
import com.foundations.convertor.model.Conversion.VideoConversion;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class VideoConversionTest {

    @Test
    public void testDoConversionException() {
        VideoConversion mockedVideo = mock(VideoConversion.class);
        ConversionVideoCriteria conversionVideoCriteria = new ConversionVideoCriteria();
        mockedVideo.doConversion(conversionVideoCriteria);
        doThrow(new RuntimeException()).when(mockedVideo).doConversion(conversionVideoCriteria);
    }

    @Test
    public void testDoConversion() {
        VideoConversion mockedVideo = mock(VideoConversion.class);
        ConversionVideoCriteria conversionAudioCriteria = new ConversionVideoCriteria();
        mockedVideo.doConversion(conversionAudioCriteria);
        verify(mockedVideo).doConversion(conversionAudioCriteria);
    }
}
