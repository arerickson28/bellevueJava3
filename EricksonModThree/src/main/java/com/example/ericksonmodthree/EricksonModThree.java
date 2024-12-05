// Austen Rhyce Erickson
// Java 3 Module 3
// 11/02/2024
// Task:
// Write a test program that contains a static method that returns a new ArrayList
// - The new ArrayList returned will contain all original values with no duplicates from
//   the original ArrayList
// - Fill the original ArrayList with 50 random values from 1 to 20
// public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
// Test the code to ensure the code functions

package com.example.ericksonmodthree;

import java.util.ArrayList;
import java.util.Random;

public class EricksonModThree {
    public static void main(String[] args) {

        ArrayList<Integer> randomInts = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i<50; i++) {
            randomInts.add(rand.nextInt(20) + 1);
        }

        ArrayList<Integer> randomIntsUnique = removeDuplicates(randomInts);

        System.out.println("Original List: \n" + randomInts);
        System.out.println("Unique List: \n" + randomIntsUnique);
    }

    public static <E>ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> noDuplicatesList = new ArrayList<>();
        for (E e : list) {
            if (!noDuplicatesList.contains(e)) {
                noDuplicatesList.add(e);
            }
        }
        return noDuplicatesList;
    }
}
