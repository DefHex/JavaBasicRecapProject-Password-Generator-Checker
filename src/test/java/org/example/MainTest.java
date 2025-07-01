package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void checkIfPasswordIsLongerThanEightChar() {
        assertTrue(Main.checkIfPasswordIsLongerThanEightChar("MorethanEightChar123!"));
    }

    @Test
    void checkIfNumsAreIncluded() {
        assertTrue(Main.checkIfNumsAreIncluded("MorethanEightChar123!"));
    }

    @Test
    void checkBigAndSmallChar() {
        assertTrue(Main.checkBigAndSmallChar("MorethanEightChar123!"));
    }

    @ParameterizedTest
    @CsvSource({
            "Passwort1 , true",
            "Aa345678 , true",
            "UniquePass!123 , false"
    })
    void commonPassword(String password,boolean check) {
        assertEquals(Main.commonPassword(password),check);
    }

    @ParameterizedTest
    @CsvSource({
            "Passwort1! , true",
            "Aa345678@ , true",
            "UniquePass123 , false"
    })
    void specialChar(String password,boolean check) {
        assertEquals(Main.specialChar(password),check);
    }

    @ParameterizedTest
    @CsvSource({
            "Pass wort1! , true",
            "Aa345678@ , true",
            "UniquePass123 , false"
    })
    void spaceNewLineTab(String password, boolean check) {
        assertEquals(Main.spaceNewLineTab(password),check);
    }
}