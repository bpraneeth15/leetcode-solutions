package org.example.Arrays.ArrEasy;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {

        //two pointer method for reversing an array

        int[] arr = {1,3,4,6,7,8,12};

        int[] arr2 = {2,6,12,13,5,4,16};

        //reverseArr(arr, 0, arr.length-1);
        reverseArr(arr);
        reverseArr(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr));

    }

    private static void reverseArr(int[] arr) {

        //two pointer method:
        //initialize variables that represent both points for ex i and j
        int start = 0;
        int end = arr.length-1;
        for( start = 0; start <= end; start++){

            //we swap the elements at these indexes
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            end--;
        }
    }

    private static void reverseArr(int[] arr, int start, int end) {

        //two pointer method:
        //initialize variables that represent both points for ex i and j
        for( start = 0; start <= end; start++){

            //we swap the elements at these indexes
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            end--;
        }
    }
}
