package org.example.Arrays.ArrEasy.Simulation;

import java.util.ArrayList;
import java.util.List;

public class TargetArrInGivOrder {

    public static void main(String[] args) {

        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};

       System.out.println(createTargetArray(nums, index));
        //createTargetArray(nums, index);
     }

    public static int[] createTargetArray(int[] nums, int[] index) {

        List<Integer> result = new ArrayList<>();
        int[] arrRes =  new int[index.length];
        for(int i = 0; i < index.length; i++){

            result.add(index[i], nums[i]);
        }

        //copy elements from list into the array
        for(int i = 0; i < arrRes.length; i++){
            arrRes[i] = result.get(i);
        }

        return arrRes;
//        System.out.println(result);

        //return result;
    }
}
