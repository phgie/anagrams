package de.anagrams;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static de.anagrams.AnagramChecker.isAnagram;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AnagramCheckerTest {
    
    @ParameterizedTest
    @MethodSource("getAnagrams")
    void isAnagramTest(String string1, String string2) {
        assertTrue(isAnagram(string1, string2));
    }

    private static Stream<Arguments> getAnagrams() {
        return Stream.of(
                arguments("New York Times", "monkeys write"),
                arguments("Church of Scientology", "rich-chosen goofy cult"),
                arguments("McDonald's restaurants", "Uncle Sam's standard rot"),
                arguments("coronavirus", "carnivorous"),
                arguments("She Sells Sanctuary", "Santa; shy, less cruel"),
                arguments("She Sells Sanctuary", "Satan; cruel, less shy"),
                arguments("evil", "vile"),
                arguments("a gentleman", "elegant man"),
                arguments("silent", "listen"),
                arguments("restful", "fluster"),
                arguments("cheater", "teacher"),
                arguments("funeral", "real fun"),
                arguments("adultery", "true lady"),
                arguments("forty five", "over fifty"),
                arguments("Santa", "Satan"),
                arguments("William Shakespeare", "I am a weakish speller"),
                arguments("Madam Curie", "Radium came"),
                arguments("George Bush", "He bugs Gore"),
                arguments("Tom Marvolo Riddle", "I am Lord Voldemort"),
                arguments("Anagrams", "Ars magna")
        );
    }
}