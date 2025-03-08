package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Tmatrix {

    public static void main(String[] args) {

        //Scanner class for inputting
        Scanner sc = new Scanner(System.in);

        int input = 0;

        //creating and declaring a multi dim array
        int[][] array1 = new int[3][4];

//        System.out.println(array1.length);


        //for loop for inputting the values in the multi dim array
        for (int row = 0; row < array1.length; row++) {

            for (int col = 0; col < array1[row].length; col++) {

                input = sc.nextInt();
                array1[row][col] = input;
                System.out.print(array1[row][col] + " ");
            }

        }
        System.out.println();

        System.out.println(Arrays.toString(new int[array1.length][array1[0].length]));

    }

//    public static int[][] transpose(int[][] matrix) {
//
//        int row = matrix.length;//contains the length of the 2d matrix or no of rows of the 2d matrix
//
//        int[][] transposeMatrix = new int[][];
//
//        for(int i = 0; i < row; i++){
//            int[] row = new int[matrix[i].length];
//        }
//        for(int row = 0; row < transpose.length; row++){
//
////this length keeps updating as row changes
//            for(int col = 0; col < matrix[row].length; col++){
//
//                transposeMatrix[col][row] = matrix[row][col];
//            }
//        }
//
//        return transposeMatrix;
//    }

}
