package org.example.Arrays.ArrMed.SortColors;

import java.util.Arrays;

public class SortColorsOnePassFixed {

    public static void main(String[] args){

        int[] nums = {0, 0, 1, 1, 2, 2};
        int [] nums1 = {2, 0, 1};
        int[] nums2 = {1,2,0};
        fixedOnePassSort(nums);

    }
    public static void fixedOnePassSort(int[] nums){
    int start = 0;
    int end =  nums.length - 1;
    int mid = start;
    int temp = 0;

        while(mid <= end){
        //we will sort

        if(nums[mid] == 0){
            //swap if start value is greater than mid value
            temp = nums[start];
            nums[start] = nums[mid];
            nums[mid] = temp;
            start++;
            //increment start by 1 position to the right
        }
        else if(nums[mid] == 2) {
            //swap the mid value with the end value
            temp = nums[end];
            nums[end] = nums[mid];
            nums[mid] = temp;
            end--;
        }
        else{
            mid++;
        }
    }
        System.out.println(Arrays.toString(nums));
}
}
/* int start = 0;
        int end =  nums.length - 1;
        int mid = start;
        int temp = 0;

        while(mid <= end){
            //we will sort

            if(nums[mid] == 0){

                //swap if you find red color at mid index
                temp = nums[start];
                nums[start] = nums[mid];
                nums[mid] = temp;
                start++;
                //after filling that position then only increment the start index
                //because the start starts fromo index 0, and if we choose comparison based operation like then,
                //1 also is lesser thann 2 and that will get wrongly stored inside the nums[0] and start is incremented by 1, which is not correct, if once the start is incremented then it is not possible to change its value,
                //and if we choose to not increment the start untill we compare it with all the elements each time, it is not optimal. so therefore since we want all the reds to be at the front we just blindly store 0s here , whenever a mid comes across one.
                //increment start by 1 position to the right
            }
            else if(nums[mid] == 2){
                //swap the mid value with the end value
                temp = nums[end];
                nums[end] = nums[mid];
                nums[mid] = temp;
                end--;
                //decrement end by 1 position to the right
            }
            else{
                mid++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }*/