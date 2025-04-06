package org.example.Arrays.ArrEasy;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDArrayLinear {

    public static void main(String[] args) {

        //
        Scanner sc = new Scanner(System.in);

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
        };

        int[][] arr2 = {
                {56, 75, 99},
                {4, 23 , 1},
        };

        int[][] arr3 = new int[3][];
        //index of a 2 d array is 1 dimensional, can be stored in 1 d array
        int target = sc.nextInt();
        int[] result = linearSearch(arr, target);
        System.out.println(Arrays.toString(result));

        int maxValue = linearSearchMax(arr3);
        System.out.println(maxValue);
    }

    static int[] linearSearch(int[][] arr, int target) {

        int row;
        int col;
        if (arr.equals(null)) {
            return null;
        }
        for (row = 0; row < arr.length; row++) {
            for (col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    //Max value search
    static int linearSearchMax(int[][] arr) {
        int row;
        int col;
        int max = Integer.MIN_VALUE;
//You're using arr.length instead of arr[row].length in the second condition,
//which seems to be a mistake. arr.length always refers to the number of rows in the 2D array, while arr[row].length refers to the number of columns in the current row.

        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (row = 0; row < arr.length; row++) {

            //check if the row is null
            if(arr[row] ==null || arr.length == 0){
                System.out.println("No elements in the array");
                return -1;
            }

            for (col = 0; col < arr[row].length; col++) {
                if (arr[row][col] > max) {
                    max = arr[row][col];
                }
            }
        }
        return max;
    }
}



