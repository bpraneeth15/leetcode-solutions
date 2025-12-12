package org.example.Arrays.ArrMed.productexceptself;

import java.util.Arrays;

public class SpaceOptimizedProductExceptSelf {

    public static void main(String[] agrs){

        int[]  nums = {1,2,3,4};
        int[] numss = {-1, 1, 0,-3, 3};

        System.out.println(Arrays.toString(prodcutExcSelf(numss)));
    }

    public static int[] prodcutExcSelf(int[] nums){
        int[] answer = new int[nums.length];

        int runningProduct = 1;

        for(int i = 0; i < nums.length; i++){

            //left to right
            if(i == 0 ) {

                answer[i] = runningProduct;
            }
            else {
                    runningProduct *= nums[i-1];
                    answer[i] = runningProduct;
                }
        }

        for(int i = nums.length-1; i >=0; i--){
            if(i == nums.length -1){
                runningProduct = 1;
            }
            else{
                runningProduct *= nums[i+1];
                answer[i] *= runningProduct;
            }
        }
        return answer;
    }
}
