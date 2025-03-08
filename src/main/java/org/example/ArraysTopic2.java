package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysTopic2 {

    public static void main(String[] args) {

        //Scanner class for inputting
        Scanner sc = new Scanner(System.in);

        int input = 0;

        //creating and declaring a multi dim array
        int[][] array1 = new int[3][4];

//        System.out.println(array1.length);


        //for loop for inputting the values in the multi dim array
        for(int row = 0; row < array1.length; row++) {

            for(int col = 0; col < array1[row].length; col++) {

                input = sc.nextInt();
                array1[row][col] = input;
                System.out.print(array1[row][col] + " ");
            }
            System.out.println();
//using Arrays.toString() for a 2D array, you will see memory addresses of the inner arrays instead of the actual elements.
//            System.out.println(Arrays.toString(array1));
        }
       //for loop for outputting values
        for (int[] rows : array1) {
                System.out.println(Arrays.toString(rows) + " ");
            }

        sc.close();
    }
}
