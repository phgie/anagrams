package de.anagrams;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static de.anagrams.AnagramChecker.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AnagramCheckerTest {
    
    @ParameterizedTest
    @MethodSource("getAnagrams")
    void isAnagramTest(String string1, String string2) {
        assertTrue(isAnagram(string1, string2));
    }

    @ParameterizedTest
    @MethodSource("getAnagramsWithWhitespaces")
    void isAnagramIgnoringWhitespacesTest(String string1, String string2) {
        assertTrue(isAnagramIgnoringWhitespaces(string1, string2));
    }

    @ParameterizedTest
    @MethodSource("getAnagramsWithSpecialCharacters")
    void isAnagramIgnoringSpecialCharactersTest(String string1, String string2) {
        assertTrue(isAnagramIgnoringSpecialCharacters(string1, string2));
    }

    private static Stream<Arguments> getAnagrams() {
        return Stream.of(
                // same string length, same characters
                arguments("coronavirus", "carnivorous"),
                arguments("evil", "vile"),
                arguments("a gentleman", "elegant man"),
                arguments("silent", "listen"),
                arguments("restful", "fluster"),
                arguments("cheater", "teacher"),
                arguments("Santa", "Satan"),
                arguments("Madam Curie", "Radium came")
        );
    }

    private static Stream<Arguments> getAnagramsWithWhitespaces() {
        return Stream.of(
                // addition/removal of spaces
                arguments("New York Times", "monkeys write"),
                arguments("McDonald's restaurants", "Uncle Sam's standard rot"),
                arguments("funeral", "real fun"),
                arguments("adultery", "true lady"),
                arguments("forty five", "over fifty"),
                arguments("William Shakespeare", "I am a weakish speller"),
                arguments("George Bush", "He bugs Gore"),
                arguments("Tom Marvolo Riddle", "I am Lord Voldemort"),
                arguments("Anagrams", "Ars magna")
        );
    }

    private static Stream<Arguments> getAnagramsWithSpecialCharacters() {
        return Stream.of(
                // addition/removal of non-alphanumeric characters
                arguments("Church of Scientology", "rich-chosen goofy cult"),
                arguments("She Sells Sanctuary", "Santa; shy, less cruel"),
                arguments("Satan; cruel, less shy", "She Sells Sanctuary")
        );
    }
}