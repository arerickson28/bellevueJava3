// Austen Rhyce Erickson
// Java 3 Module 2
// 11/02/2024
// Task:
// Create a program using a recursive method that returns the sum of the following type inputs
// m(i) = 1/2 + 2/3 + 3/4 + 4/5 + 5/6 … i/(i + 1)
// Replace "m" with the method name you use.
// Use three different input finishing values, testing to ensure it runs correctly
// Example: m(4), m(9), m(14)

package com.example.ericksonmodtwo;

import java.util.ArrayList;

public class EricksonModTwo {
    public static void main(String[] args){

//      gather list of test integers
        ArrayList<Integer> testIntegers = new ArrayList<>();
        testIntegers.add(5);
        testIntegers.add(7);
        testIntegers.add(9);

//      test each integer
        for (int n : testIntegers) {
            double result = recursiveSummation(n);
            System.out.printf("The sum recursiveSummation(%d) = %.4f\n", n, result);
        }
    }

//  for this summation, we'll add backwards until we reach i = 1
    public static double recursiveSummation(int i) {
//      this is the base case
//      if i == 1, the summation is simply (i / (i + 1)
//      which is the same as (1 / 2 )
        if (i == 1) {
            return 1.0 / 2;
        } else {
//          the addition contribution for this round of recursion
            double currentAddition = (double) i / (i + 1);
//          run method again, adding the current addition to the accumulation
            return recursiveSummation(i - 1) + currentAddition;
        }
    }
}
