// Austen Rhyce Erickson
// Java 3 Module 5
// 11/15/2024
// Task:
// Write a test program that reads words from a text file and
// displays all non-duplicate words in ascending order
// and then in descending order
// -- the file is to be referenced in the program, not needing to be used as a command line reference
// -- the word-file is to be titled collection_of_words.txt and included in your submission
package com.example.ericksonmodfive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class EricksonModFive {
    public static void main(String[] args) {

//      the collection_of_words file contains a poem by Derek Walcott entitled "Love After Love"

//      use try/catch block for interacting with file data
        try {
//          read poem into a list of one string per line in the file
            List<String> lines = Files.readAllLines(Paths.get("EricksonModFive/src/main/resources/collection_of_words.txt"));

//          Condensed stream with lots of methods

//          filter() ignores the empty lines between the stanzas of the poem

//          map() removes all punctuation to isolate only the words in the poem

//          flatMap() converts each list string into a list of words, resulting in a list of lists,
//          and then flattens the list of lists into one long list

//          map() set all words to lowercase so that "you" and "You" are not counted as separate words

//          distinct() to remove duplicate words. A set of unique words remains (as a list)
            List<String> words = lines.stream()
                    .filter(line -> !line.trim().isEmpty())
                    .map(line -> line.replaceAll("[^a-zA-Z0-9\\s]", ""))
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .map(String::toLowerCase)
                    .distinct()
                    .collect(Collectors.toList());

//          print list of words
            System.out.println(words);
//          sort words in alphabetical order and print
            Collections.sort(words);
            System.out.println(words);
//          sort words into reverse alphabetical order and print
            Collections.sort(words, Collections.reverseOrder());
            System.out.println(words);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
