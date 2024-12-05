package com.example.scratch;

import java.util.*;

public class ForEach {

    public static void main(String[] args) {

        List<Integer> listIntegers = new ArrayList<>();
        listIntegers.add(10);
        listIntegers.add(30);
        listIntegers.add(20);
        listIntegers.add(50);
        listIntegers.add(40);

        List<String> listStrings = new ArrayList<>();
        listStrings.add("Apple");
        listStrings.add("Banana");
        listStrings.add("Cherry");
        listStrings.add("Mango");
        listStrings.add("Peach");

        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);

//      ---- FOR EACH ---
//      using forEach to traverse the List
        listStrings.forEach(item -> System.out.println(item));

//      using forEach to traverse the Map
        map.forEach((key, value) -> System.out.println(key + " is " + value + " years old"));


//      --- SORTING ---
//      ascending
        Collections.sort(listIntegers);
        Collections.sort(listStrings);
//      descending
        Collections.sort(listIntegers, Comparator.reverseOrder());
        Collections.sort(listStrings, Comparator.reverseOrder());
//      --- SEARCHING ---
//      sorting the list (required for binary search)
        Collections.sort(listIntegers);
//      searching for an element using binarySearch
        int index = Collections.binarySearch(listIntegers, 30);
        System.out.println("Element found at index: " + index);
//      checking for presence of element
        System.out.println("listIntegers contains 5: " + listIntegers.contains(5));
        System.out.println("listStrings contains 'Apple': " + listStrings.contains("Apple"));
//     --- SHUFFLING ---
        Collections.shuffle(listIntegers);
        Collections.shuffle(listStrings);
//     --- MAX / MIN ---
//      finding the largest element (Integer)
        int maxInteger = Collections.max(listIntegers);
//      finding the smallest element (Integer)
        int minInteger = Collections.min(listIntegers);
        System.out.println("Largest element: " + maxInteger);
        System.out.println("Smallest element: " + minInteger);
//      finding the largest (max) string
        String maxString = Collections.max(listStrings);
//       finding the smallest (min) string
        String minString = Collections.min(listStrings);
        System.out.println("Largest string: " + maxString);
        System.out.println("Smallest string: " + minString);
    }

}
