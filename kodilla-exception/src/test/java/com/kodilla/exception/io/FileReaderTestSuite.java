package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {

    @Test
    void testReadFile() {
        //Given
        FileReader fileReader = new FileReader();
        //When & Then
        assertDoesNotThrow(() -> fileReader.readFile());
    }

    @Test
    void whenFileDosentExistsReadFileShouldThrowException() {
        //Given
        FileReader fileReader = new FileReader();
        String fileName = "nie_ma_takiego_pliku.txt";
        //When & Then
        assertThrows(FileReaderException.class, () -> fileReader.readFile2(fileName));
    }

    @Test
    public void testReadFileWithName() {
        //Given
        FileReader fileReader = new FileReader();
        //When & Then
        assertAll(
        () -> assertThrows(FileReaderException.class, () -> fileReader.readFile2("nie_ma_takiego_pliku.txt")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile2(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFile2("names.txt")));
    }
}
