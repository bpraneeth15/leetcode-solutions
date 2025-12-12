package org.example.Arrays.ArrEasy;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysTopic {

    public static void main(String[] args) {

        //creating an array

        int[] arr1 = new int[10];

        Scanner sc = new Scanner(System.in);

        int[] arr2 = new int[arr1.length];//creating an array with the same size of arr1.


        int sumOfArray = 0;
        int lastIndexOfArr1 = arr1.length - 1  ;
//        int lastIndexOfArr2 = arr2.length - 1 ;

        for(int i = 0; i <= lastIndexOfArr1; i++){

            //Ensuring that the entered input is a valid integer, if not it simply returns the arraylist with the previously entered elements
            if(sc.hasNextInt()) {
                arr1[i] = sc.nextInt();
                sumOfArray += arr1[i];

                arr2[lastIndexOfArr1 - i] = arr1[i]; //last index of the arr2 takes the input from the arr1's last index
                }

            else{
                System.out.println("Invalid input ! stopping the loop...");
                break;
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(sumOfArray);
        System.out.println(Arrays.toString(arr2));
    }
}
