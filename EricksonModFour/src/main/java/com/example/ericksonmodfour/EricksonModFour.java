// Austen Rhyce Erickson
// Java 3 Module 4
// 11/04/2024
// Task:
// Write a program that stores 50,000 integers in LinkedList and test the time to traverse the list using an
// iterator vs. using the get(index) method
// Then, test your program storing 500,000 integers
// After completing this program and having tested both values, in your comments, explain the
// results and discuss the time taken using both values and their difference with the get(index) approach.
// Ensure the code functions correctly
package com.example.ericksonmodfour;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class EricksonModFour {
    public static void main(String[] args) {
//      create 50,000 and 500,0000 sized lists for code testing
        LinkedList<Integer> fiftyThouList = getThouList(Size.FIFTY_THOUSAND);
        LinkedList<Integer> fiveHundredThouList = getThouList(Size.FIVE_HUNDRED_THOUSAND);

//      run execution time measurement on the 50,000 size list
        testStrategyDuration(fiftyThouList, 6788);
        System.out.println("---------------------");
//      run execution time measurement on the 500,000 size list
        testStrategyDuration(fiveHundredThouList, 66788);
    }

//  method to get a list of thousands of random integers of specified length/size
    static LinkedList<Integer> getThouList(Size size) {
        LinkedList<Integer> thouList = new LinkedList<>();
        Random rand = new Random();
        for (int i = 0; i<size.value; i++) {
//          add random integer to list
            thouList.add(rand.nextInt(100) + 1);
        }
        return thouList;
    }

//  method to traverse the list using an iterator up to a specified index
//  (does not return anything because we don't need to use the result,
//   we're just interested in how long it takes)
    public static void traverseUsingIterator(LinkedList<Integer> list, int stopIndex) {
        Iterator<Integer> iterator = list.iterator();
        int currentIndex = 0;
        while (iterator.hasNext() && currentIndex < stopIndex) {
            // move to the next element
            iterator.next();
            // increment the index
            currentIndex++;
        }
    }

//  method to traverse the list to a specified index using get(index)
//  (does not return anything because we don't need to use the result,
//   we're just interested in how long it takes)
    public static void traverseUsingGetMethod(LinkedList<Integer> list, int stopIndex) {
        for (int i = 0; i < stopIndex; i++) {
            list.get(i); // Access the element at index i (slow for LinkedList)
        }
    }

//  method to report the relative speeds of traversal of iterator vs. get(index) strategies
    public static void testStrategyDuration(LinkedList<Integer> theList, int stopIndex) {

//      helper object to format decimals and longs
        DecimalFormat df = new DecimalFormat("#.00");  // 2 decimal places

//      measure time for traversal using an Iterator up to stopIndex
        double startTime = System.nanoTime();
        traverseUsingIterator(theList, stopIndex);
        double endTime = System.nanoTime();
//      convert the time elapsed to milliseconds
        double iteratorTime = Double.parseDouble(df.format((endTime - startTime) / 1000000));

//      measure time for traversal using the get(index) method up to stopIndex
        startTime = System.nanoTime();
        traverseUsingGetMethod(theList, stopIndex);
        endTime = System.nanoTime();
//      convert the time elapsed to milliseconds
        double getMethodTime = Double.parseDouble(df.format((endTime - startTime) / 1000000));

//      determine the difference in time elapsed between two strategies
        double difference = Double.parseDouble(df.format(Math.abs(iteratorTime - getMethodTime)));

//      the strategy with the smallest time elapsed is the faster strategy
        String fasterStrategy;
        if (iteratorTime < getMethodTime) {
            fasterStrategy = "iterator";
        } else {
            fasterStrategy = "get(index) method";
        }

//      print out a report of experiment results
        System.out.println(
                "List size: " + theList.size() + "\n" +
                "Desired Index: " + stopIndex + "\n" +
                "Iterator time (ms): " + iteratorTime + "\n" +
                "Get method time (ms): " + getMethodTime + "\n" +
                "Faster Strategy: " + fasterStrategy + "\n" +
                "Time difference (ms): " + difference
        );
    }
}

// ---- COMMENTS -----

// EXAMPLE RESULT
// List size: 50000
// Desired Index: 6788
// Iterator time (ms): 0.49
// Get method time (ms): 38.76
// Faster Strategy: iterator
// Time difference (ms): 38.27
//  ---------------------
// List size: 500000
// Desired Index: 66788
// Iterator time (ms): 2.02
// Get method time (ms): 3543.04
// Faster Strategy: iterator
// Time difference (ms): 3541.02

// The results for the two test cases indicate that using an iterator is a faster
// way to traverse a list. It appears this difference gets compounded as the list size grows.
// The bigger the list, the greater the difference in time required for each strategy.
