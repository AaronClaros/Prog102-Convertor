package com.foundations.convertor.Model.Conversion;
import com.foundations.convertor.common.ConversionAudioCriteria;
import com.foundations.convertor.model.Conversion.AudioConversion;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class AudioConversionTest {
    @Test
    public void testDoConversion() {
        AudioConversion mockedAudio = mock(AudioConversion.class);
        ConversionAudioCriteria conversionAudioCriteria = new ConversionAudioCriteria();
        mockedAudio.doConversion(conversionAudioCriteria);
        verify(mockedAudio).doConversion(conversionAudioCriteria);
    }
}
