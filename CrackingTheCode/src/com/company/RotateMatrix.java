package com.company;

import java.util.Arrays;

/**
 * Created by loujo06 on 2017-04-03.
 * Question 1.7 in CTCI
 */
public class RotateMatrix {
    /*
     * The number of iterations in the outer most loop is O(Sqrt(n)/2)
     * The number of iterations in the inner most loop is O(Sqrt(n))
     * The runtime of this solution is O(n)
     */
    public static void rotate(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
        for(int k = 0; k < matrix[0].length/2; k++) {
            int start = 0+k;
            int end = matrix[0].length-1-k;
            int top = start;
            int left = start;
            int bottom = end;
            int right = end;
            for (int i = start; i < end; i++){
                int firstValue = matrix[top][i];
                matrix[top][i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[i][right];
                matrix[i][right] = firstValue;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String args[]) {
        int[][] matrix_one = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotate(matrix_one);
        int[][] matrix_two = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix_two);
        int[][] matrix_three = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9 ,10},
            {11, 12 ,13 ,14 ,15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24 ,25}
        };
        rotate(matrix_three);
    }
}
