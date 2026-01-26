package org.example.Arrays.ArrEasy;

public class RemoveDuplicatesArray {


    public static void main(String[] args){

        System.out.println(removeDuplicates(new int[]{1,2,2,3,3,3}));
    }

    public static int removeDuplicates(int[] nums) {

        int fill = 1;
        for(int i = 0; i <= nums.length - 2; i++){

            if(nums[i] != nums[i+1]){

                //if the current value is different from the next value that means im going to pull in that value
                nums[fill] = nums[i+1];
                fill++;
            }
        }
        return fill;//last index that gets filled with uniques elements
        // is equal to the no of unique elements
    }
}
