package org.example.Arrays.ArrEasy;

import java.util.Scanner;

public class LinearSearch {

    /*The idea is to search/touch each and every index one after the other, be it from the start or from the last
     * The time increases in the O(n) time complexity*/

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5};//this is one way of creating and initializing ann array

        int[] arr1 = {7,5,4,3,2,1,0,10};
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int targetIndex = linearSearch(arr, target);
        System.out.println(targetIndex);

        int result = linearSearchMaxVal(arr1);
        System.out.println("Max value : " + result);

        int result2 = linearSearchMaxVal(arr1, 1, 4);
        System.out.println("Max value within the given range " + result2 );

        String str= sc.next();
        char strTarget = 'u';
        int index = linearSearchString(str, strTarget);
        int index2 = linearSearchString(str, 'u');

        System.out.println(index);
        System.out.println(index2);
    }

    //searching a string
    static int  linearSearchString(String string, char target) {
        int start = 0;
        int end = string.length();
        if(string.isEmpty()) {
            return -1;
        }
        while (start < end) {

            if(string.charAt(start) == target){
                return start;
            }
            //move on to the next index if the current index has an empty char or space char
            else if(string.charAt(start) == ' '){
                start++;
            }
            else {
                start++;
            }
        }
        return -1;//if the char is not present inside the string
    }

    //searching the target value using linear search
    public static int linearSearch(int[] arr, int target) {

        //chekc if array is valid(has elements)
        if(arr == null || arr.length == 0){
            return -1;
        }
        //start checking at the index, search through entire array
        int start = 0;
        int end = arr.length - 1;
        for (start = 0; start <= end; start++) {
            if (arr[start] == target) {
                return start;
            }
            }
        return -1;
        }

        //searching the max value using linear search
     static int linearSearchMaxVal(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int max = arr[start];//assign the max value as Max.Interger....or start value
         while(start <=end){
             if(arr[start] > max){
                 max = arr[start];
                 start++;
             }
             else{
                 start++;
             }
         }
         return max;
     }

     static int linearSearchMaxVal(int[] arr, int start, int end){

        if (arr == null || arr.length == 0){
            return -1;
        }
        int max = Integer.MIN_VALUE;//initializing it to some min integer constant
        while(start <= end){
            if(arr[start] > max){
                max = arr[start];
                start++;
            }
            else{
                start++;
            }
        }
        return max;
     }

    }

