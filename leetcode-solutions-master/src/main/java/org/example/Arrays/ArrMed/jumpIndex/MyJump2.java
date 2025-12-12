package org.example.Arrays.ArrMed.jumpIndex;

public class MyJump2 {

    public static void main(String[] args){

        int[] nums= {2,3,1,1,4};
        int[] nums1= {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        System.out.println(jump(nums1));

    }
    public static int jump(int[] nums) {
        int jumps = 0;
        int maxReach = 0;
        int newIndex = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {

            //not required to explicitly determine if reachable or not because by default all test cases are reachable.
            //according to the question

               //newIndex = i + nums[i]; //updating newIndex value for every iteration, we are not locking the window,
            //inorder to lock we only update maxIndex when the entire range is completed, for updating after range is completed we need a new farthest range possible.
            //which is stored/give by the maxReach always.
            //therefore, we removed newIndex from the if condition and used direct i + nums[i],
            // because we won't be using newIndex variable for comparison directly because
            //newIndex must be updated for each and every iteration if we want to compare it against the maxReach.
            //or if we do want to use newIndex for comparison,then we should be using a different variable for locking in the window range.
            if (i + nums[i] > maxReach) {
                maxReach = i + nums[i]; // update maxReach when every you find a greater one
            }

            if(i == newIndex){
                //if we complete checking the jump powers between i and newIndex that we locked in before
                //we jump
                jumps++;//and we update our newIndex to the farthest maxReach we have at hand.
                newIndex = maxReach;
            }

            if (newIndex >= n - 1) {
                break;
            }
        }

        return jumps;
    }
}
