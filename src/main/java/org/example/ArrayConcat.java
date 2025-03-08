package org.example;

import java.util.Arrays;

public class ArrayConcat {
    public static void main(String[] args) {

        int[] result = getConcatenation(new int[]{1,2,3});
        System.out.println(Arrays.toString(result));


    }

    //this was my solution to concatenate the same array and print it
        public static int[] getConcatenation(int[] nums) {
            int n = nums.length;
            int[] ans = new int[2 * n];//size of array ans -> 2n
            int i;
//loop 1 for inputting till i reaches n-1;
            for(i = 0; i< nums.length; i++){

                ans[i] = nums[i];

            }
//loop 2 for inputting after i reaches
            for(i = 0; i< nums.length; i++){
                ans[i + n] = nums[i];
            }
            //since both loops are having same functionality just combine them into a single loop
            return ans;
        }
}




