package com.company;

import java.util.Hashtable;

/**
 * Created by loujo06 on 2017-03-27.
 * Question 1.4 in CTCI
 */
public class PalindromePermutation {
    /*
     * The amortized runtime for this solution is O(n).
     * Analysis of first loop.
     * Space complexity is O(n) for the Hashtable.
     * Searching and inserting in a Hashtable costs only O(1).
     * The loop will run n times therefore it will only be O(n).
     * Analysis of second loop.
     * Assuming O(n) to pull all values from Hashtable.
     * The loop will run n times (length of the number of values in Hashtable) therefore it will only be O(n).
     */
    public static boolean isPalindrome(String input) {
        Hashtable<Character, Integer> characterOccurences = new Hashtable();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = Character.toLowerCase(input.charAt(i));
            if (currentChar != ' ') {
                if (characterOccurences.containsKey(currentChar)) {
                    int currentCharCount = characterOccurences.get(currentChar);
                    characterOccurences.put(currentChar, ++currentCharCount);
                } else {
                    characterOccurences.put(currentChar, 1);
                }
            }
        }
        int oddNumbers = 0;
        int trueInputLength = 0;
        /*
         * Assuming O(n). Will check again.
         */
        for (Integer value : characterOccurences.values()) {
            if ((value % 2) == 1) {
                oddNumbers++;
            }
            trueInputLength += value;
        }
        if (((trueInputLength % 2) == 1) & (oddNumbers == 1)) {
            return true;
        } else if (((trueInputLength % 2) == 0) & (oddNumbers == 0)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("taco cat"));
        System.out.println(isPalindrome("acto cta"));
        System.out.println(isPalindrome("Tact Coa"));
        System.out.println(isPalindrome("AAA"));
        System.out.println(isPalindrome("ABC"));
        System.out.println(isPalindrome("DSAD"));
    }
}