package com.foundations.convertor;/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import com.foundations.convertor.Main;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void testAppHasAGreeting() {
        Main classUnderTest = new Main();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}