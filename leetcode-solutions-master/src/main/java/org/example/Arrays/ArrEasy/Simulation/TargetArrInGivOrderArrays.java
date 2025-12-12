package org.example.Arrays.ArrEasy.Simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetArrInGivOrderArrays {
    public static void main(String[] args) {


        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};

        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {

       // List<Integer> result = new ArrayList<>();
        int[] arrRes =  new int[index.length];
        for(int i = 0; i < index.length; i++){
            //iterate from left to right
            //if the destination is before the current i just run the nested loop
            //to shift elements to the right
            int dest = index[i];
            if(dest < i){
                for(int j = i; j > dest; j --){
                    //push to right starting from the current ith position till j reaches to destination
                    arrRes[j] = arrRes[j - 1];
                }
            }
            arrRes[index[i]] = nums[i];
        }

        return arrRes;
    }
}
