// Austen Rhyce Erickson
// Java 3 Module 1
// 10/26/2024
// Task:
// -Write a program that stores:
//   -- an array of five random integers
//   -- a Date object instance using the current date
//   -- an array of five random double values
// -Serialize data to file titled ericksonDatafile.dat
// -Write a second program that deserializes, reads, and displays the data

package com.example.ericksonmodone;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.io.FileOutputStream;
import java.io.IOException;

public class EricksonModOneWrite {
    public static void main(String[] args) {

//      retrieve and save current data
        Date currentDate = new Date();
//      prepare arrays for random numbers
        ArrayList<Integer> randomInts = new ArrayList<>();
        ArrayList<Double> randomDoubles = new ArrayList<>();

//      5 times, add a random integer and a random double to their corresponding arrays
        Random rand = new Random();
        for (int i = 0; i<5; i++) {
            randomInts.add(rand.nextInt(101));
            randomDoubles.add(rand.nextDouble(101.0));
        }

//      display contents of data to be saved
        System.out.println(randomInts);
        System.out.println(currentDate);
        System.out.println(randomDoubles);

//      open streams
        try (FileOutputStream fos = new FileOutputStream("ericksonDatafile.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
//          write data to file
            oos.writeObject(randomInts);
            oos.writeObject(currentDate);
            oos.writeObject(randomDoubles);

//          close streams
            oos.close();
            fos.close();

            System.out.println("Data has been serialized to ericksonDatafile.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
