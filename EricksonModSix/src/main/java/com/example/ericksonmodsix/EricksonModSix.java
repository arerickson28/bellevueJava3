// Austen Rhyce Erickson
// Java 3 Module 6
// 11/22/2024
// Task:
// Write a program with the two following generic methods using a bubble sort.
// The first method sorts the elements using the Comparable interface,
// and the second use the Comparator interface.
package com.example.ericksonmodsix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class EricksonModSix {
    public static void main(String[] args) {

//      get lists for testing
        Integer[] myList = getList().toArray(new Integer[0]);
        Integer[] yourList = getList().toArray(new Integer[0]);

//      print list before sort
        System.out.println("List for Comparable Bubble Sort: ");
        System.out.println(Arrays.toString(myList));

//      print list after sort
        System.out.println("Comparable Interface Bubble Sort Result:");

        bubbleSort(myList);

        System.out.println(Arrays.toString(myList));

        System.out.println("---------------------------------------");

//      print other list before sort
        System.out.println("List for Comparator Bubble Sort: ");
        System.out.println(Arrays.toString(yourList));

//      print other list after sort
        System.out.println("Comparator Interface Bubble Sort Result:");
        bubbleSort(yourList, (a, b) -> a.compareTo(b));

        System.out.println(Arrays.toString(yourList));

//      note that both the Comparator technique and the Comparable technique
//      sort their respective lists successfully
    }

//  method to generate a list of integers to sort
    static ArrayList<Integer> getList() {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i< 25; i++) {
//          add random integer to list
            list.add(rand.nextInt(100) + 1);
        }
        return list;
    }

//  bubble sort using the Comparable interface
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        int n = list.length;

//      outer loop to pass through list multiple times
        for (int i = 0; i < n - 1; i++) {
//          set swap status to false for each iteration
            boolean swapped = false;
//          inner loop compares adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
//              if the current element is greater than the next, swap them
                if (list[j].compareTo(list[j + 1]) > 0) {
                    // Swap the elements
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

//                  indicate that a swap has occurred
                    swapped = true;
                }
            }
//          if no elements were swapped during the inner loop iterations,
//          the list has finished being sorted
            if (!swapped) {
                break;
            }
        }
    }

//  bubble sort using Comparator
    public static <E> void bubbleSort(E[] list, Comparator<?super E> comparator) {
        int n = list.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

//          this bubble sort works the same way as the above bubble sort
//          except a comparator is being used instead of the extended compareTo() Comparable method
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
