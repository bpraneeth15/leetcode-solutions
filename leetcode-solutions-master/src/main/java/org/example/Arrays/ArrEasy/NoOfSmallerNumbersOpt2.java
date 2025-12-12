package org.example.Arrays.ArrEasy;

import java.util.Arrays;

public class NoOfSmallerNumbersOpt2 {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        System.out.println((smallerNumbersThanCurrent(nums)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        //Build a freequency array
        int[] freq = new int[101];

        //now mark the values that are present in the given array
        for(int i = 0; i < nums.length; i++){
           freq[nums[i]] ++;
            //freq[0]
            //for every value present in the nums array we have to mark at the values position in the frequency array
        }
        System.out.println("freq array : " + Arrays.toString(freq));

//        int n = nums.length;
        //prefix sum
        for(int i = 1; i < freq.length; i++){
            freq[i] = freq[i] + freq[i-1];
            //sum of the prefix sum at each i.
        }
        System.out.println("prefixSummed frequency array : " +Arrays.toString(freq) );

        int[] result = new int[9];

//        //for each position i in result we have to insert no of nums[j] < nums[i]
//        //brute force:
//
//        for(int i = 0; i < n; i++){
//            int count = 0;
//            for(int j = 0; j < n; j++){
//                if(i != j && nums[j] < nums[i]) {
//                    count++;
//                }
//            }
//            result[i] = count;
//        }

        return result;//returns a new array of the numbers
    }
}
