package org.example.Arrays.ArrMed.jumpIndex;

public class JumpLocalVisible {

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};
        //reaches the last index

        int[] nums1 = {2, 3, 1, 1, 4};// works

        int[] numsTest = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};//doesnt work for this testcase because the jump is not locally
        //visible.
        System.out.println(jump(nums1));
    }

    public static int jump(int[] nums) {

        int jumps = 0;
        int maxReach = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int newIndex = i + nums[i];

            if (newIndex > maxReach) {
                maxReach = newIndex; // Cap maxReach
                jumps++;
            }

            if (maxReach >= n - 1) {
                break;
            }
        }
            return jumps;
    }
}

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
