package com.foundations.convertor.Model.Conversion;
import com.foundations.convertor.common.ConAudioCrit;
import com.foundations.convertor.model.Conversion.AudioConversion;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AudioConversionTest {
    @Test
    public void testDoConversion() {
        AudioConversion mockedAudio = mock(AudioConversion.class);
        ConAudioCrit conAudioCrit = new ConAudioCrit();
        mockedAudio.doConversion(conAudioCrit);
        verify(mockedAudio).doConversion(conAudioCrit);
    }
}
