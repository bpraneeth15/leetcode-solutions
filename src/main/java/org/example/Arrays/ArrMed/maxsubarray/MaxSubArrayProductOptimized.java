package org.example.Arrays.ArrMed.maxsubarray;

public class MaxSubArrayProductOptimized {

    public static void main(String[] args){

        int[] nums = {-2,0,-1};

        System.out.println(maxProd(nums));

    }

    public static int maxProd(int[] nums){
        int maxProduct = Integer.MIN_VALUE;
        int runningProductLR = 1; //FROM LEFT TO RIGHT
        int runningProductRL = 1; //from right to left

        //1. count the no of negative values inside the array
        //look at how many sub array products can be formed, this is

        int n = nums.length;
        for( int i = 0 ; i < n; i++){

            if(runningProductLR == 0){
                runningProductLR = 1;
            }
            if(runningProductRL == 0){
                runningProductRL = 1;
            }

            //CALCULATE THE RUNNING PRODUCT
            runningProductLR *= nums[i];//calculate from front
            runningProductRL *= nums[n-i-1];//calculate from back


            //at each iteration check which is greater and keep updating the maxProductValue;
            //AFTER CALCULATING both the RUNNINGProducts check which one of those is maximum , pick one max and then again compare it with the existing maxProduct that we have at hand
//            maxProduct = Math.max(maxProduct, Math.max(runningProductLR, runningProductRL));
            int maxOfBoth = Math.max(runningProductLR, runningProductRL);//CHOOSE ONE MAX

            if(maxProduct < maxOfBoth){
                maxProduct = maxOfBoth;
            }
        }
        return maxProduct;
    }
}
