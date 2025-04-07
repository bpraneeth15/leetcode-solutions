package org.example.Arrays.ArrMed.SortColors;

import java.util.Arrays;

public class SortColors1Pass {
//Comparison based approach only works for few cases but misses the core logic
    //If we move start after a comparison-based swap, and that new start has a 0, it's too late to push that 0 to the left again. We've already "locked in" that region.
    //and the question was to group the similar elements together.
    //why this has nothing to do with comparisons? because the question
    //was about colors and not the values/elements
    // the numbers just represent
    public static void main(String[] args){

        int[] nums = {0, 0, 1, 1, 2, 2};
        int [] nums1 = {2, 0, 1};
        int[] nums2 = {1,2,0};
        int[] nums3 = {2,0,1};
        sortColorsOnePass(nums2);

    }

    public static void sortColorsOnePass(int[] nums){

        int start = 0;
        int end =  nums.length - 1;
        int mid = start;
        int temp = 0;

        while(mid <= nums.length -1){
            //we will sort

            if(nums[start] > nums[mid]){

                //swap if start value is greater than mid value
                temp = nums[start];
                nums[start] = nums[mid];
                nums[mid] = temp;
                start++;
                //increment start by 1 position to the right

            }

            if(nums[mid] > nums[end]){

                //swap the mid value with the end value
                temp = nums[end];
                nums[end] = nums[mid];
                nums[mid] = temp;

                //decrement end by 1 position to the right
            }
            //increment mid only at the end of the iteration
            mid++;
        }

        System.out.println(Arrays.toString(nums));

    }
}


/*Your Final Realization:
"Instead of asking whether one value is less than another, I should just check:
Is it a red (0)? Yes → it goes to the red zone."
if(nums[mid] == 0) {
    // Whenever we find a red (0) at mid,
    // we place it at the current 'start' position.

    // Swap the red to the front
    temp = nums[start];
    nums[start] = nums[mid];
    nums[mid] = temp;

    // After placing a red at the correct position,
    // we increment 'start' to point to the next available front slot.
    start++;

    // It's important to note:
    // - We are not using value comparisons (like start > mid or nums[start] > nums[mid]).
    //   Because comparisons might let a '1' (white) or '2' (blue) wrongly occupy the front.
    // - Once a 'start' position is filled and the pointer is moved,
    //   we never go back to it — so it must only contain a red.

    // By acting only when we see a 0 and moving it directly to the front,
    // we ensure the front zone is always filled correctly without rechecking.
}
*/