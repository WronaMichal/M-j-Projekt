package main.java;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {
    @Test
    void FileExist() {
        File ENtoPL = new File("/Users/test/internship/dictionaries/PLtoEN.dsv");
        File ENtoIT = new File("/Users/test/internship/dictionaries/PLtoEN.dsv");
        File PLtoIT = new File("/Users/test/internship/dictionaries/PLtoIT.dsv");
        assertTrue(ENtoPL.exists());
        assertTrue(ENtoPL.exists());
        assertTrue(PLtoIT.exists());

    }
}