package org.example.Arrays.ArrMed.RotateArray;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {


        int temp = 0;
        int temp1 = 0;

        for (int i = 0; i < k; i++) {
            int rotatedIndex = i + k;


            //simply insert the element at that position
            temp = nums[rotatedIndex];
            nums[rotatedIndex] = nums[i];

            temp1 = nums[rotatedIndex + k];
            if (rotatedIndex + k < nums.length) {

                nums[rotatedIndex + k] = temp;
            }
            if (rotatedIndex + k + k >= nums.length) {

                nums[(rotatedIndex + k + k) % nums.length] = temp1;
//            }
            }
            // System.arraycopy(rotatedArray, 0, nums, 0, nums.length);

            System.out.println(Arrays.toString(nums));
        }
    }
}
//        int[] rotatedArray = new int[nums.length];
//
//        for(int i = 0; i < nums.length; i++){
//            int rotatedArrIndex = i+k;
//            if(rotatedArrIndex < nums.length){
//
//                //simply insert the element at that position
//                rotatedArray[rotatedArrIndex] = nums[i];
//
//            }
//            if(rotatedArrIndex >= nums.length ){
//
//                rotatedArray[rotatedArrIndex % nums.length] = nums[i];
//            }
//        }
//        System.out.println(Arrays.toString(rotatedArray));
//    }

