package com.company;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * Created by loujo06 on 2017-04-04.
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 column are set to O.
 */
public class ZeroMatrix {
    public static void clearRowAndColumns(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                for (int k = 0; k < columns.length; k++) {
                    matrix[i][k] = 0;
                }
            }
        }
        for (int i = 0; i < columns.length; i++) {
            if (columns[i]) {
                for (int k = 0; k < rows.length; k++) {
                    matrix[k][i] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
    public static void main(String args[]) {
        int[][] matrixOne = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        clearRowAndColumns(matrixOne);
        int[][] matrixTwo = {
                {0, 0, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        clearRowAndColumns(matrixTwo);
        int[][] matrixThree = {
                {0, 1, 0},
                {3, 4, 5},
        };
        clearRowAndColumns(matrixThree);
    }
}
