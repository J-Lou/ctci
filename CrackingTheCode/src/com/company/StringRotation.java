package com.company;

/**
 * Created by loujo06 on 2017-04-05.
 * Question 1.8 in CTCI
 */
public class StringRotation {
    public static boolean isSubstring(String stringOne, String stringTwo) {
        return stringOne.contains(stringTwo);
    }

    public static boolean isRotation(String stringOne, String stringTwo) {
        String doubleStringOne = stringOne + stringOne;
        return isSubstring(doubleStringOne, stringTwo);
    }

    public static void main(String args[]) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
        System.out.println(isRotation("waterbottle", "erbottlewata"));
        System.out.println(isRotation("waterbottl", "erbottlewata"));
    }
}
