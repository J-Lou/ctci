package com.company;

/**
 * Created by loujo06 on 2017-03-23.
 * Question 1.1 in CTCI
 */
/*
 * ASCII has a total of 128 characters, and 256 in the extended set
 * Unicode is a superset of ASCII. Unicode is any set of characters less than 2^21
 */
public class IsUnique {
    /*
     * Solution proposed by CTCI
     */
    /*
     * Personal note
     * Integers are 2 bytes & utilizing bit operators will compare them at a bit level
     * This solution is very interesting and clever. Utilizes bits as a boolean array essentially to
     * contain a value to determine if a character has occurred
     * Solution is O(n) with a space complexity of O(1)
     */
    public static boolean isUniqueBinarySolution(String string) {
        int checker = 0;
        for (int i = 0; i < string.length(); i++) {
            int value = 1 << string.charAt(i);
            if ((checker & value) > 0) {
                return false;
            }
            checker = checker | value;
        }
        return true;
    }

    /*
     * Solution is O(n) with a space complexity of O(1)
     */
    public static boolean isUnique(String string) {
        // Assuming extended ASCII
        int[] characterSet = new int[256];
        for (int i = 0; i < string.length(); i++) {
            int charValue =  string.charAt(i);
            if (characterSet[charValue] > 0) {
                return false;
            }
            characterSet[charValue] = 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("heLlo~~"));
        System.out.println(isUniqueBinarySolution("heLlo"));
    }
}