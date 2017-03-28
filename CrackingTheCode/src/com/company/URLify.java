package com.company;

/**
 * Created by loujo06 on 2017-03-27.
 * Question 1.3 in CTCI
 */
public class URLify {
    /*
     * No analysis on this algorithm.
     */
    public static String replaceWS(String url, int urlLength) {
        StringBuilder wsFreeURL = new StringBuilder();
        String wsReplacement = "%20";
        for (int i = 0; i < urlLength; i++) {
            if (url.charAt(i) == ' ') {
                wsFreeURL.append(wsReplacement);
            } else {
                wsFreeURL.append(url.charAt(i));
            }
        }
        return wsFreeURL.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceWS("Mr John Smith       ", 13));
    }
}