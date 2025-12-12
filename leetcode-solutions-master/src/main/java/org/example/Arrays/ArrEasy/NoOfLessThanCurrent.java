package org.example.Arrays.ArrEasy;

import java.util.Arrays;

public class NoOfLessThanCurrent {

    public static void main(String[] args) {

        int[] nums = {6,5,4,8};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        //for each position i in result we have to insert no of nums[j] < nums[i]
        //brute force:

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(i != j && nums[j] < nums[i]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;//returns a new array of the numbers
    }
}
