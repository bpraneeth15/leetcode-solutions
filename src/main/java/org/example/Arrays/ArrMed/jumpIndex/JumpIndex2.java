package org.example.Arrays.ArrMed.jumpIndex;

public class JumpIndex2 {

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};
        //reaches the last index

        int[] nums1 = {2, 3, 1, 1, 4};//doesnt reach
        System.out.println(jump(nums1));
    }

    public static int jump(int[] nums) {

        //we have to find the minimum jumps that the pointer is required to take to reach the
        //last index
        //so what is a jump? --a jump can be of any no steps in a single go
        int jumps = 0;

        //we have to minimize the no of jumps. inorder to do that we have to maximize the steps(over mos of the area). we take in single jump
        //so inorder to do that, essentially we have to consider taking only those jumps (or)
        //consider only those jumps whose no of steps take me to the farthest index in the path/array without taking me to a
        //potential trap or overseeing/skipping the even better jump powers
        //if it is leading to a potential trap a better jump power will automatically be found within the range.
        //if there is a trap at the mR, that means that position won't push us even one bit further.
        // so that means even if current position 'i' reaches the mR, that means we have not found any better jump that takes us further,
        // hence, we can stop. this is in the case of path/array that is not reachable
        //But in the case of arrays/paths that are reachable, if the mR of a index i is having a trap. that means, we will be having other better jumps
        //with in the range of index 'i' and the mR index, that pushes the maxReach at least one step ahead. if it is not pushing then that means
        // the array is not valid for this question (unreachable).
        //so given above example and the question,

        //at index 0 we will see the maxReach of index 0 ---mR = 0 + 1 = 1, this is the potential maxReach,
        //which means it is the only jump power we have within our reach so far
        //we must always check and decide what is the best jump power that we have within our reach and then take one jump.
        //how do we decide that? by checking and comparing the potential maxReachs of all the jump powers we have within our reach
        //how do we see that? by checking the potential maxReach  of 'i' position while we traverse.
        //this enables us to skip rechecking of the potential maxReach each and everytime
        // Initially maxReach = 0 (INDEX-0) mR ->farthest reach that we have so far
        // because that is the only position/index that we can access so far. (since we don't want to skip any jump-power/index without checking.
        // [ 0,     1,      2,      3,    4,    5]->INDEXES/[POSITIONS],
        // [ 1,     2,      3,      0,    1,    4]
        //  i,    nI,mR
        // --Now, newIndex= 0+1=1, newIndex shows till how far each ith index/position can push us, this means so far this is the farthest position that we
        //need to remember, 'maxReach' keeps track of it because if anything in between is not far enough we can take this jump, otherwise we will change our maxReach if anything greater appears
        //therefore this newIndex becomes the maxReach because newIndex = 1 is farther than maxReach=0
        //so First, I made a mistake of continuously updating the maxReach if any farther position appeared, and taking a jump whenever a farther position appeared.
        //now this jump doesn't have a strong reason, jumping just because we found a greater/farther position is wrong, because it is generally saying that,
        //instead of taking the best of all the jumps i accessed so far, I will take jump for every farther position I find.
        //[1,3,4,4,0]--  newIndex[index-0] = 0 + 1 = 1, mR = 0 at start, now mR = nI =1, we found potential farther position, take a jump = 1, cmpare if we reacched last index
        // i =1, newIndex[index-1] = 1 + 3 = 4, we found a better farther position, take a jump = 2, we reached last index. since 4 is last index, return jumps made
        //but what if in some scenarios where our newIndex reach is farther than the maxReach and the next immediate position(after newIndex) reaches the last index?
        //Ex: {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3} -- in this test case,first index jumping power has a wide range, it can reach from index 1 to index 7,
        //if i make a jump here, because mR has stretched, now that means im choosing my first jump directly which might be correct, but inorder for us to choose the
        //next jump we should select from the range of jumps within our reach, that is decided by knowing which takes us the farthest of all.
        //therefore, here taking one jump already decides where we are going to jump, therefore we wait till we find out the best possible position to be found
        // and take that first jump. when can we know which position within our reach has a better jump? only when we check all the ones within our reach
        //why all the ones? because last position within our reach may have the best jump. Since you have to write an algorithm that works for each and every scenario
        //not just for those arrays that look like this-- {2, 4, 3, 1, 4,1} -- here maxReach starts to increase from the initial index,
        //we can reach the last index within 2 jumps. Here jumping, whenever maxReach is stretched coincidentally works but what if an array is like below
        //prev ex: works {2, 4, 3, 1, 4,1}--what if->{2, 3, 5, 1, 4, 4}doesnt work--> proof below
        //according to our pre-existing approach, we jump whenever maxReach is stretched
        //newIndex[index 0]= 0 + 2 = 2, index 2 is far than index 0 maxReach , therefore we update maxReach = 2 (index2).since increased jump=1, reached last index? no
        //newIndex[index 1]= 1 + 3= 4, index 4 is far than index 2 mR, therefore update maxReach = 4(index-4), since increased jump =2, mR reached last index? no
        //newIndex[index 2]= 2 + 5 = 7, index 7 is far than index mR = 4, therefore update maxReach = 7, since increased we jump = 3, mR reached last index? yes
        //we return jumps=3, which is incorrect. because according to the example that we took for proof, we are supposed to reach it in jumps , we can tell just by looking
        //the jump 2 which we made was unnecessary because the next jumping power(which was within our reach) takes us directly to the last index
        //Instead of taking that 2nd jump from index 1 which we could have simply avoided it and took that second jump from the index 2 which could have took us to
        //last index.
        //Why did this happen? because we haven't checked all the jumping powers that we had within our reach.
        //what's within our reach? the position that we are currently at till the position that we can reach to so far, the position that we can reach so far is continuously increased
        //so how do we decide the best jump? if the range is continuously stretched and reaches/exceeds the last index
        //we cant decide the best jump because newer jump powers will continuously keep on adding till we reach last index. then the question returns back to square one
        //where we have to decide best jumps from the entire array. now, do we have the track of all jumping powers? to decide? no we don't
        //therefore we cant decide the best possible jump from the entire array
        //To solve this problem of deciding the best possible jump " without having knowledge of the entire array upfront ",
        //we can solve this problem of deciding the best jump possible in few cases not all-- without having to keep track of the range
        //when ? -- when we have the local visibility like below examples
        //the best reach is directly at thee start or edge of the initial i to maxReach- either best jump should be at the current i position
        //or at the maxReach position, because we only have access to these two pieces of information not the entire array
        //i and maxReach
        //1. A strictly decreasing, non-zero, or plateaued sequence
        // nums = [4, 3, 2, 1, 0] -- window is not required and a single jump is the minimum
        //From index 0:
        //You can reach up to index 4,
        //All future jump powers are known immediately
        //
        //2. Jump powers include “super jumps” that dominate all future options
        //You can see the “best jump” right now and its future outcome
        //
        //3. When the number of reachable positions is small, and their futures are easily visible, window tracking becomes unnecessary.
        //
        //You can't determine the best jump locally when:
        //🔹 The best reach isn’t at the start or edge of your current jump window
        //🔹 The best long-term jump (i.e., one that leads to the goal or best future path) is not directly visible from the current index
        //🔹 So even if you're standing at a high jump power, you may mistakenly jump early and miss a better future route(better jump before the current range)
        //nums = [2, 1, 5, 1, 1, 1, 10]
        //i = 0, nums[0] = 2 → you can jump to index 1 or 2
        //You look at immediate reachable options:
        //nums[1] = 1 → not great
        //nums[2] = 5 → seems like a strong choice — so you jump to index 2
        //Now you're at index 2:
        //You can go to indices 3, 4, 5, 6
        //All of them seem "okay", but nums[6] = 10 is excellent
        //So what's the catch?
        //
        //If you had chosen to go from index 0 → 1 → 2 → 6,
        //you could still have reached the goal, but from index 2 you didn’t know that nums[6] = 10 was your gateway to the goal.
//  Even though nums[2] = 5 looks good, its real value depends on where it takes you next
// You only find that out after jumping
//
// The truly best jump was to reach the index that gets you to nums[6] = 10, but that wasn't locally visible


// if we take the jump based on the maxReach we are ignoring the jump-powers within the range.
// if we consider taking jumps whenever we reach a new increased maxReach we would be keep incrementing the jumps unnecessarily for the jump powers
//that could not take us to the last index along with for the ones that take us .


        int newIndex = 0;

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // so basically
            newIndex = i + nums[i];

            if (newIndex > maxReach) {
                maxReach = newIndex;
                //the maxReach is updated only when the jump is reaching to a farther place
                //only when maxReach is increased we increment jump
                jumps++;
            }
        }

        return jumps;
    }
}



