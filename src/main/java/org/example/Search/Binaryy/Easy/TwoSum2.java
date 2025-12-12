package org.example.Search.Binaryy.Easy;

import java.util.Arrays;

public class TwoSum2 {

    public static void main(String[] args){

        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    public static int[] twoSum(int[] numbers, int target) {

//        int[] result = new int[2];
        int sum = 0;
        int start = 0;
        int end = numbers.length -1 ;

        while(start < end){
            //since we should add a same value

            sum = numbers[start] + numbers[end];

            if(sum > target){
                //dial down
                end--;
            }
            else if( sum < target){
                //dial up
                start++;
            }
            else{

                break;
            }
        }
        return new int[]{start+1, end+1};

    }
}
