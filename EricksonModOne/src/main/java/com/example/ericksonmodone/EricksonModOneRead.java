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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;

public class EricksonModOneRead {
    public static void main(String[] args) {

//      prepare objects to receive data
        ArrayList<Integer> randomInts;
        ArrayList<Double> randomDoubles;
        Date theDate;

//      open streams
        try (FileInputStream fis = new FileInputStream("ericksonDatafile.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
//          read data and save to variables
            randomInts = readArrayList(ois);
            theDate = (Date) ois.readObject();
            randomDoubles = readArrayList(ois);

//          close streams
            ois.close();
            fis.close();

//          display data retrieved from file
            System.out.println("Data has been deserialized from ericksonData.dat");
            System.out.println(randomInts);
            System.out.println("The date: " + theDate);
            System.out.println(randomDoubles);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//  helper method for reading to an array
    @SuppressWarnings("unchecked")
    private static <T> ArrayList<T> readArrayList(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        return (ArrayList<T>) ois.readObject();
    }
}
