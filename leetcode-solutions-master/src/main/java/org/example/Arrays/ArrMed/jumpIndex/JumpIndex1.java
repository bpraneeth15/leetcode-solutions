package org.example.Arrays.ArrMed.jumpIndex;

class JumpIndex1 {

    public static void main(String[] args){

        int[] nums = {2,3,1,1,4};
        //reaches the last index

        int[] nums1 = {3,2,1,0,4};//doesnt reach
        System.out.println(canJump(nums));

    }
    public static boolean canJump(int[] nums) {

        boolean canReach = false;
        int maxReach = 0;//initially our maxReach is at index 0 because that is what we can reach so far before start of the traversal
        //traverse through the array

        for(int i = 0; i < nums.length; i++){

            //check if the current position is always lesser than the maxReach, maxReach is the farthest index that we can reach so far
            //so the idea is that the maxReach(max position that we can reach) increases atleast by 1 position when we are at the maxReach index position, if it doesnt increase then that means all the
            //jump powers that are present before it are leading to the trap or not reaching the trap in the first place
            //that is the reason, the current position goes past the maxReach index, return false if that happens because indicates that no jump powers in the indexes/positions before the maxReach index
            //can surpass the maxReach index that we have at hand. and this maxReach index contains a trap.
            if(i > maxReach){
                //this condition proves that there is a trap in the path which no jump power before it can over take it
                return canReach;
            }

            // newIndex = i + nums[i]; //newIndex is always compared against the maxReach we have at hand,

            if(maxReach < i + nums[i]){
                maxReach = i + nums[i];//we are always considering the farthest index that we get as the maxReach
            }

            if(maxReach >= nums.length - 1){
                canReach = true;
                break;
            }
        }

        return canReach;
    }
}