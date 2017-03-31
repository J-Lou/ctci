package com.company;

import java.awt.*;
import java.util.Hashtable;

/**
 * Created by loujo06 on 2017-03-28.
 * Question 1.5 in CTCI
 */
public class OneAway {
    /*
     * The runtime for this solution is O(n)
     * All loops depend on the length of the inputs and each operation costs O(1)
     */
    public static boolean isOneAway(String inputOne, String inputTwo) {
        if (Math.abs(inputOne.length() - inputTwo.length()) > 1) {
            return false;
        } else {

        }
        Hashtable<Character, Integer> inputOneCharOccurrences = new Hashtable();
        for (int i = 0; i < inputOne.length(); i++) {
            if (inputOneCharOccurrences.containsKey(inputOne.charAt(i))) {
                inputOneCharOccurrences.put(inputOne.charAt(i), inputOneCharOccurrences.get(inputOne.charAt(i)) + 1);
            } else {
                inputOneCharOccurrences.put(inputOne.charAt(i), 1);
            }
        }
        int numberOfErrors = 0;
        for (int i = 0; i < inputTwo.length(); i++) {
            if (inputOneCharOccurrences.containsKey(inputTwo.charAt(i))) {
                inputOneCharOccurrences.put(inputTwo.charAt(i), inputOneCharOccurrences.get(inputTwo.charAt(i)) - 1);
            }
        }
        for (Integer value : inputOneCharOccurrences.values()) {
            numberOfErrors += value;
        }
        if (numberOfErrors > 1) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(isOneAway("pale", "ple")); // true
        System.out.println(isOneAway("pales", "pale")); // true
        System.out.println(isOneAway("pale", "bale")); // true
        System.out.println(isOneAway("pale", "bake")); // false
        System.out.println(isOneAway("apple", "ale")); // false
        System.out.println(isOneAway("ale", "apple")); // false
        System.out.println(isOneAway("ae", "apple")); // false
        System.out.println(isOneAway("apple", "asle")); // false
        System.out.println(isOneAway("asple", "apple")); // true
    }
}
