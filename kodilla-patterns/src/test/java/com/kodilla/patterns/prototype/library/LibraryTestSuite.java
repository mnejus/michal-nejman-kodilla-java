package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library nationalLibrary = new Library("National Library");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> nationalLibrary.getBooks().add(new Book("Book" + n, "Author" + n, LocalDate.now())));
        //Making shallow copy of object Library
        Library clonedLibrary = null;
        try {
            clonedLibrary = nationalLibrary.shallowCopy();
            clonedLibrary.setName("National Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //Making a deep copy of object Library
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = nationalLibrary.deepCopy();
            deepClonedLibrary.setName("National Library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When
        nationalLibrary.getBooks().clear();
        //Then
        System.out.println(nationalLibrary);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(0, nationalLibrary.getBooks().size());
        assertEquals(clonedLibrary.getBooks().size(), nationalLibrary.getBooks().size());
        assertNotEquals(deepClonedLibrary.getBooks().size(), clonedLibrary.getBooks().size());

    }
}
