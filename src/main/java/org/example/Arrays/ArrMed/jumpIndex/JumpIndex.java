package org.example.Arrays.ArrMed.jumpIndex;

public class JumpIndex {


    public static void main(String[] args){

        int[] nums = {};

    }

    public static boolean canJump(int[] nums) {
//initialize the variables to store -
        //distance between the current position and the right most trap

        int maxReach = 0;//initially it is our 0th index so far

        boolean canReach = false;
//        if(nums[0] == 0){
//            return false;
//        }

        int newIndex = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                //if the maxSteps = 0 then we reached a trap do nothing

                newIndex = i + nums[i];//after getting newIndex see if it reaches the end
                if(newIndex >= nums.length -1 ){

                    canReach = true;
                    break;
                }
                else{//if not reaching the last index, checking if its maxSteps are greater than the
                    //steps of the maxReach position so far
                    if(nums[newIndex] > nums[maxReach]){
                        //maxSteps after jumping > maxSteps that we are considering
                        //if greater then update the maxReach to that position because that has the maxReach steps
                        //but what if
                        maxReach = newIndex;
                    }
                    else if(nums[maxReach] == nums[newIndex]){
                        //if no of maxSteps at both positions are equal then check which position to consider
                        //chooose between
                        if(newIndex + nums[newIndex] > maxReach+ nums[maxReach]){
                            //if this is the case then update maxReach depending on the farthest reach
                            maxReach = newIndex;
                        }
                    }
                }
                if (maxReach >= nums.length - 1) {

                    canReach = true;
                }
            }
        }

        return canReach;
    }
}

/* [2,3,0,1,3,4],
Calculate newIndex = i + nums[i] – simulates your jump from position i.

Check if newIndex >= nums.length - 1

If yes → you can reach the end → return true.

If not, compare nums[newIndex] with nextMaxReach

If nums[newIndex] is greater, it becomes your new nextMaxReach.

and what if the nums[i + nums[i]] which is the maxSteps at new index == nextMaxReach?
okay wait, if that is the case then may be i should compare the index i of the current position
and the index of the current nextMaxReach at hand whcih ever is greater i will be choosing it as my nextMaxReach, but here in order to compare indexes i have to store the index of the nextMaxReach each and every time i upadte the nextMaxReach.
but here im not doing that im just storing the next jumping power in the  nextMaxReach */