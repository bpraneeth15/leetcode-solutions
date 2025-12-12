package org.example.Arrays.ArrEasy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoOfSmallerValuesRight {

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        System.out.println(Arrays.toString(countSmaller(nums).toArray()));
    }

    public static List<Integer> countSmaller(int[] nums) {


        List<Integer> resList = new ArrayList<>();

        //Brute force: take the array nums and then compare each nums[i] with the ones to the right
        //increase count only when the nums[i] > nums[i+1....n]
        for(int i = 0; i < nums.length ; i++){
            int count = 0;
            for(int j = i+1; j < nums.length; j++){

                if(nums[i] > nums[j]){
                    count++;
                }
            }
            resList.add(i, count);
        }
        return resList;
    }
}

/*Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].

Example 1:
Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Example 2:
Input: nums = [-1]
Output: [0]

Example 3:
Input: nums = [-1,-1]
Output: [0,0]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104*/