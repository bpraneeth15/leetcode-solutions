package org.example.Arrays.ArrEasy;

import java.util.Arrays;

public class LongestSubSequenceLimSum {

    public static void main(String[] args) {

        int[] nums = {4,5,2,1};
        int[] queries = {3,10,21};
        System.out.println(Arrays.toString(answerQueries(nums,queries)));

    }
//Approach:
    //start calculating the running sum from the array nums,
    //keep adding the sum and increment the current size till there is an over flow, once there is an over flow,
    //you dont increment the size if there is an over flow,
    // Just copy the current size -> size, and restart the running sum from the next element
    //As we can see, when we try to start calculating the running sum from that current value nums[j], we might observe that
    //we can observe that we are trying to take the values as they come in the order that was already given to us
    //so whenever we try to take  the vaalues in the order strictly, we may add the values but , neglect
    //the possible smaller values that make up the size bigger
    //so even if we break the continuous order while calculating the running sum, and start the new running sum calculation from
    //that current value itself, we might loose the few potential valuable elements before the over flow has occuredm which may be very important
    //therefore, this approach may work accidentally but never guarantee we will have thhe largest subsequence
    //Not: The subsequence that was asked in this question may or may not require to follow the order of the nums array
    //now inorder for this approach to work, we should generate each every possible sizes of subsequences whose sum is <= queries[i]
    //so yes this works perfectly fine but the time complexity will be way too high even for the n = 50
    //what I mean by that is, lets say we are starting at j =0 on the nums array, we start the running sum , calculate the size, and then
    //when we reach the condition nums[j] > queries[i] we just copy and reset the size value marking this size as
    //one of the possibilities of the desired condition
    //we keep doing this for all the possibilities
    public static  int[] answerQueries(int[] nums, int[] queries) {

        int[] result = new int[queries.length];
        int currentSize ;
        int size;
        int currentRunningSum;
        int prevRunningSum;

        for(int i = 0; i < queries.length; i++){
             currentSize = 0;
             currentRunningSum = 0;
             size = 0;
//             prevRunningSum=0;

            //compare each queries[i] with rSum of nums[j=0....j=nums.length]
            for(int j = 0; j < nums.length; j++){
                currentRunningSum += nums[j];
                if(currentRunningSum > queries[i]){
                    //store the currentSize into prevSize
                    size = currentSize;
                    //prevRunningSum = currentRunningSum;
                    currentSize = 0;
                    currentRunningSum = nums[j];
                }
                else{
                    currentSize++;
                }
                if(size < currentSize){
                    size = currentSize;
                }
            }

            result[i] = size;
        }

        return result;
    }
}
/*Approach Summary
The attempted solution works as follows:
1. Start iterating through nums from left to right.
2. Keep a running sum (currentRunningSum) and increment a size counter (currentSize) as long as the sum stays ≤ queries[i].
3. When an overflow happens (currentRunningSum > queries[i]),
4. copy the current size into a global size variable,
5. reset the running sum and current size,
6. then start building a new running sum from the next element.
After the loop finishes, return the maximum size observed.
This sounds reasonable at first, but it collapses when the array’s order works against the optimal subsequence.
You always attempt to include large elements before smaller ones if they appear earlier in the input.
Once an overflow happens, you “restart” the running sum at the next index, completely ignoring the smaller,
more valuable elements that appeared earlier.

Even if you try to “break continuity” by restarting the running sum after overflow,
the reset logic permanently discards all elements before the reset point.
Restarting the loop from the next index after overflow is not real backtracking.
in this exam: nums = [7,4,1,1,1]
query = 9

Your approach explores segments like:
[7]
[4]
[1,1,1]
[1,1]
[1]

But it will NEVER explore subsequences like:
[4,1,1,1] (correct length-4 answer)
[1,4,1]
[7,1,1]
 */