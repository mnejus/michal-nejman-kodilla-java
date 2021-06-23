package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void saveLog() {
        logger = Logger.INSTANCE;
        logger.log("2021-06-23 20:24:04.523");
    }

    @Test
    void testGetLastLog() {
        //Given
        //When
        String log = logger.getLastLog();
        System.out.println("Last login: " + log);
        //Then
        assertEquals("2021-06-23 20:24:04.523", log);
    }
}
