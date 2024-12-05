package com.example.ericksonmodeight;

import java.util.Random;

public class AustenThreeThreads extends Thread {
    @Override
    public void run() {
//      add random characters from the array to the shared string
        for (int i = 0; i < 10000; i++) {
            sharedString.append(getRand(threadArray));
            try {
//              sleep to give space for other threads to run
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

//  the array for this instance
    private final String[] threadArray;

//  the string to be used in this instance
    private final StringBuffer sharedString;

//  thread object constructor
    public AustenThreeThreads(String[] array, StringBuffer sharedStringBuffer) {
        this.threadArray = array;
        this.sharedString = sharedStringBuffer;
    }

//  method to randomly select an element from a given array
    private static String getRand(String[] array) {
        Random rand = new Random();
        return array[rand.nextInt(array.length)];
    }
}
