package com.company;

import java.util.Hashtable;

/**
 * Created by loujo06 on 2017-03-23.
 * Question 1.2 in CTCI
 */
public class CheckPermutation {
    /*
     * The amortized runtime for this solution is O(n). Time complexity will depend on size of the largest string.
     * The worst case runtime for this solution is O(n^2).
     * The amortized runtime for inserting into a Hashtable is O(1), however if there many collisions (rare), it will
     * be O(n). This occurs when all entries are in the same hash bucket or linked list.
     */
    public static boolean checkPermutation(String firstInput, String secondInput) {
        Hashtable characterOccurrences = new Hashtable<>();
        if (firstInput.length() != secondInput.length()) {
            return false;
        }
        for (int i = 0; i < firstInput.length(); i++) {
            characterOccurrences.put(firstInput.charAt(i), true);
        }
        for (int i = 0; i < secondInput.length(); i++) {
            if (!characterOccurrences.containsKey(secondInput.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPermutation("HeL~lo", "HeLa~lo"));
    }
}
