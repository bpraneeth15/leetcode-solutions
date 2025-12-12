package org.example.Arrays.ArrEasy;

import java.util.Arrays;

public class NoOfLessThanCurrentOpt {

    public static void main(String[] args) {

        int[] nums = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        //lets sort the array first
        //lets use the bubble sort
        //in each iteration the biggest number is guaranteed to reach its destination
        //therefore we dont need to end each iteration till the last position in the array
        //for each iteration i , we must end till current index reaches n - i; where n is the size of the given array


        int n = nums.length;
        int[] result = new int[n];
        //for each position i in result we have to insert no of nums[j] < nums[i]
        //Optimal Solution : first sort it
        int temp = 0;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                //swap if nums[j] < nums[j+1]
                if( j+1 < n && nums[j] > nums[j+1]){
                    temp = nums[j+1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }//sorting logic

        int count = 0;
        for(int i = 0; i < n; i++){
            count = i;
            if( i > 0 && nums[i-1] == nums[i]){
                result[i] = count;
            }
            result[i] = count;
        }

        return nums;//returns a new array of the numbers
    }
}
