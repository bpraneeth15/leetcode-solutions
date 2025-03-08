package org.example;

public class MaxSubArrKadanes {

    public static void main(String[]args){

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

    }

    public static int maxSubArray(int[] nums) {

        int maxSumValue = Integer.MIN_VALUE;
        int runningSum = nums[0];
        if(nums.length == 1){
            return nums[0];
        }

        //for each size tryout  calculate sum of all sub arrays of the same size
            for(int i = 1; i < nums.length ; i++){
                //initialize the value of j
                //updates the j value to the end index of the subarray

                if(runningSum < 0){
                    runningSum = nums[i] ;

                }
                else{
                    runningSum += nums[i];
                }

                if(runningSum > maxSumValue){
                    maxSumValue = runningSum;

                }
            }
        return maxSumValue;

    }
    }
    /*what am saying is that, yes i will check if adding the current value to the current sum would lead to a reduction in the current sum or not,
    if currentSum is  reducing my value for instance lets say, in the table before, when we are at index 3 we got current sum as 4,
    and we  updated our maxsubsum to 4, when we are at index 4, we were adding -1 to the 4 so that makes the current sum to 4-1 = 3,
    but since 4 is greater, why cant we keep the current sum 4 only? however we are not changing the maxSubSum from 4 to 3 right?
    okay so if we do that then we will be carrying the same currentSum 4 to the next index 5,
    if we carry the same currentSum 4 to the next position at index 5 we have2, so the current sum would lead to 4+2= 6 ,
    and if we go bby that val and store it in maxSubArr then we might end up storing the wrong answer and again if we were to add another positive value in the next index/iteration,
    we will be getting more larger number than maxSubbSum and i update it to that number which would be more than 6  which is not correct at that particular instance of time
    ok i got it now */