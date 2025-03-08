package org.example.ArrMed.maxsubarray;

public class MaxSubArrayProduct {

    public static void main( String[] args){

        int[] nums = {2,3,-2,4};
        int[] numss = {0,2};

        System.out.println(maxProductArr(numss));
    }

    public static int maxProductArr(int[] nums) {
        int minProduct = Integer.MAX_VALUE;
        int maxProduct = 0;
        int currentProd = nums[0];
        for(int i = 1; i < nums.length; i++){
            //running product
            currentProd *= nums[i];

            if(nums[i] <= 0){
                //if the current value is 0 or negative reset the currentProd to
            }

            if(currentProd == 0){
                //if running product is zero
                currentProd = nums[i];
            }
            else if(currentProd < 0){
                //if negative number then store it in minProduct
                minProduct = currentProd;
            }
            else if(currentProd > 0){

                //if positive number then store it in the maxProduct
                if(currentProd > maxProduct){
                    maxProduct = currentProd;
                }
            }
        }
        return maxProduct;
    }

}
