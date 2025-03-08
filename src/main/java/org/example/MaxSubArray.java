package org.example;

public class MaxSubArray {
 public static void main(String[] args) {

     int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
     System.out.println(maxSubArray(nums));
 }
        public static int maxSubArray(int[] nums) {
        /*Step 1: Initialize subarraySums[]
Start by copying the elements from nums[] because for size 1, each subarray is just the element itself.
Step 2: Iterate Through Subarray Sizes
Start with size 1 and build upwards.
For each size, extend the subarray by adding the next element.
Step 3: Calculate and Store Sums
For each subarray, reuse the previous sum by adding the next element.
Update maxSum whenever the current sum is greater than the previous maxSum.
Step 4: Return the Maximum Sum
After checking all subarray sizes, return maxSum.*/
            int[] subArraySum = new int[nums.length];

            int maxSumValue = Integer.MIN_VALUE;

            if(nums.length == 1){
                return nums[0];
            }

            for(int size = 1; size <= nums.length ; size++ ){

                //for each size tryout ot calculate sum of all sub arrays of the same size
                for(int i = 0; i <= nums.length - size; i++){
                    //initialize the value of j
                    int  j = i + size - 1;//updates the j value to the end index of the subarray
//endIndex = startIndex + size -1

                    subArraySum[i] = subArraySum[i] + nums[j];

                    if(subArraySum[i] > maxSumValue){
                        maxSumValue = subArraySum[i];

                    }
                }
            }
            return maxSumValue;
        }
    }
