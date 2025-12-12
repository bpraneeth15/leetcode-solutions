package org.example.Arrays.ArrMed.SortColors;

import java.util.Arrays;

/*75. Sort Colors

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
NOTE:  You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.*/
//General 2 pass approach
public class SortColors2Pass {

    public static void main(String[] args){

        int[] nums = {2,0,2,1,1,0};

        sortColors(nums);
    }

    public static void sortColors(int[] nums) {

        int red = 0;
        int white = 0;
        int blue = 0;


        //one pass for counting
        for(int i = 0; i<nums.length; i++){

            int color = nums[i];
            switch(color){
                case 0: red++; break;

                case 1: white++; break;

                case 2: blue++; break;
            }
        }

        //2nd pass for updating
        for(int i = 0; i < nums.length; i++){

            if (red > 0){
                nums[i] = 0;
                red--;
            }
            else if(white > 0){
                nums[i] = 1;
                white--;
            }

            else if(blue > 0){
                nums[i] = 2;
                blue--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
