package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShuffleArr {
    public static void main(String[] args) {


       int[] result = shuffle(new int[]{1,2,3,4,5,6,7}, 3);
        System.out.println(Arrays.toString(result));
    }

    public static int[] shuffle(int[] nums, int n) {

        int[] ans = new int[2*n];


        int currentIndex = 0;

        for(int i = 0; i < n; i++){

           // select the start of both:  left and right subarrays
            // ans[currentIndex] = nums[i];
            // ans[currentIndex + 1] = nums[n+i];
            /*Improved space complexity below*/
            ans[2*i] = nums[i];//2*i lets us access indexes at even positions
            ans[2*i + 1] = nums[n+i];//2*i+1 to access at odd positions

            // currentIndex = currentIndex + 2;
            }
            return ans;
        }
    }

