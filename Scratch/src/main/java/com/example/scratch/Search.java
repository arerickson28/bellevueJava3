package com.example.scratch;

import java.util.ArrayList;
import java.util.Arrays;

public class Search {

    public static void main(String[] args) {
        // Create array list to search
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15));

        // Determine element to be found
        int target = 7;

        // call binary search method
        int result = binarySearch(list, 0, list.size() - 1, target);

        // display result
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the list.");
        }
    }

    // Recursive method for binary search using ArrayList
    public static int binarySearch(ArrayList<Integer> list, int left, int right, int target) {

        // Base case: if the left index exceeds the right index, the target is not found
        if (left > right) {
            return -1; // element not found
        }

        // Calculate the middle index
        int mid = left + (right - left) / 2;

        // Base case: the target element is found
        // Check if the target is present at mid
        if (list.get(mid) == target) {
            return mid; // Target found
        }

        // If the target is smaller than the mid-element, search the left sub-array
        if (target < list.get(mid)) {
            return binarySearch(list, left, mid - 1, target);
        }

        // If the target is larger than the mid-element, search the right sub-array
        return binarySearch(list, mid + 1, right, target);
    }
}
