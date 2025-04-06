package org.example.Arrays.ArrMed.RotateArray;

import java.util.Arrays;

public class Rotate {

    public static void main(String[] args){

      int[] nums = {1, 2, 3, 4, 5, 6};
      int k= 8;
      System.out.println(Arrays.toString(rotateArray(nums, k)));
//        Expected Output: [3, 1, 2]

    }

    public static int[] rotateArray(int[] nums, int k){

        //int start = 0;//start at index 0

        int count = 0; // this should become the size of the array
        int source = 0;

        int originalValue = 0;
        int n = nums.length;

        for(int i = 0; i < nums.length; i++){
                //i is the destination
                //cycle starts by updating the ith index,
                int start = i;
                originalValue = nums[start];
                while (count < nums.length) {//before starting a cycle always check if we have completed updating all elements in the array
                    //if yes then don't start

                    //calculate the source first and then decide which condition to run based on the value
                    source = ((i - k) % n + n) % n;//source is getting updated for every i here

                    if(source != start){
                        //compared to see if the source has become start, as start was the destination initially
                        //for that cycle, not equal means the source is not yet looped back to the start position
                        nums[i] = nums[source];
                        count++;
                        i = source;//update i to the source index. after pulling
                        //repeat
                    }
                    else{
                        //once source == start;when cycle start possition becomes source thats when the loop is exited
                        nums[i] = originalValue;
                        count++;
                        break; //stop the cycle there and restart with a new start position
                    }
                }

            }
        return nums;
    }

}

