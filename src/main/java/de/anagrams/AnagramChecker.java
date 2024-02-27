package de.anagrams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AnagramChecker {
    public static void main(String... args) {
        boolean isAnagram = args.length == 2 && isAnagram(args[0], args[1]);
        System.out.println("Given String Arguments are" + (isAnagram ? "" : " NOT") + " an anagram of each other!");
    }

    protected static boolean isAnagram(String string1, String string2) {
        return sort(string1.toLowerCase()).equals(sort(string2.toLowerCase()));
    }

    private static String sort(String string) {
        return Arrays.stream(string.toLowerCase().split("")).sorted().collect(Collectors.joining());
    }

    protected static boolean isAnagramIgnoringWhitespaces(String string1, String string2) {
        return isAnagram(removeWhitespaces(string1), removeWhitespaces(string2));
    }

    private static String removeWhitespaces(String string) {
        return string.replaceAll("\\s", "");
    }

    protected static boolean isAnagramIgnoringSpecialCharacters(String string1, String string2) {
        return isAnagram(removeSpecialCharacters(string1), removeSpecialCharacters(string2));
    }

    private static String removeSpecialCharacters(String string) {
        return string.replaceAll("[^A-Za-z0-9]", "");
    }
}
