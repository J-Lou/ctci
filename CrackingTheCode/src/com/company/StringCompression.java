package com.company;

/**
 * Created by loujo06 on 2017-03-30.
 * Question 1.6 in CTCI
 */
public class StringCompression {
    /*
     * The runtime for this solution is O(n)
     * One loop for n times and each operation will cost O(1)
     */
    public static String compressString(String input) {
        char lastChar = ' ';
        int characterStreak = 0;
        StringBuilder compressedString = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i == 0) {
                lastChar = input.charAt(i);
                compressedString.append(lastChar);
            }
            if (input.charAt(i) != lastChar) {
                lastChar = input.charAt(i);
                compressedString.append(characterStreak);
                compressedString.append(lastChar);
                characterStreak = 1;
            } else if (input.charAt(i) == lastChar) {
                characterStreak++;
            }
            if (i == input.length() - 1) {
                compressedString.append(characterStreak);
            }
        }
        String resultingString = compressedString.toString();
        if (input.length() > resultingString.length()) {
            return compressedString.toString();
        } else {
            return input;
        }
    }
    public static void main(String args[]) {
        String[] inputs = {"alllll", "aabcccccaaa", "true"};
        System.out.println(compressString(inputs[0]));
        System.out.println(compressString(inputs[1]));
        System.out.println(compressString(inputs[2]));
    }
}
