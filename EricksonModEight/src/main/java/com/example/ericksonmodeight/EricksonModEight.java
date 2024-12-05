// Austen Rhyce Erickson
// Java 3 Module 8
// 11/30/2024
// Task:
// Use three threads to output three types of characters to a
// text area for display
// - thread 1: output random letters
// - thread 2: output random digits
// - thread 3: output random special chars
// Display at minimum 10,000 of each of the three sets

package com.example.ericksonmodeight;

public class EricksonModEight {
    public static void main(String[] args) {

//      define types of arrays of characters
        String[] letters = {
                "a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p",
                "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z"
        };

        String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        String[] special = {"!", "@", "#", "$", "%", "^", "&", "*", "?", "<"};

//      created the final string to be displayed
//      each thread will contribute to this string
        StringBuffer sharedString = new StringBuffer();

//      create threads
        AustenThreeThreads lettersThread = new AustenThreeThreads(letters, sharedString);
        AustenThreeThreads digitsThread = new AustenThreeThreads(digits, sharedString);
        AustenThreeThreads specialThread = new AustenThreeThreads(special, sharedString);

//      start threads
        lettersThread.start();
        digitsThread.start();
        specialThread.start();

        try {
//          wait for all threads to finish
            lettersThread.join();
            digitsThread.join();
            specialThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

//      display result
        System.out.println(sharedString);

//      NOTE:
//      result will look like this: 6h*d0*2x$w2!1l#2$p1$g$m6%c5%o6r*2s@7l#3n#3z*9^m25o<o1<j4*7x^1o*2j!<4t9%x@3p^5o3@k5@w@0e
//      may take up to 5 min to run
    }
}
