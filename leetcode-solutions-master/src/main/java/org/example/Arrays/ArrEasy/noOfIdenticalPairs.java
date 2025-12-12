package org.example.Arrays.ArrEasy;

public class noOfIdenticalPairs {

    public static void main(String[] args) {


       int result =  numIdenticalPairss(new int[]{1, 2, 3, 1, 1, 3});
                                            //   0, 1, 2, 3, 4, 5
                                            //
        System.out.println(result);
    }

    public static  int numIdenticalPairs(int[] nums) {
        int count = 0;

        int i = 0;
        int j = 1;

        while(i < j ){//i < j comparison is done after updating j in the outerloop along with i

            while(j < nums.length){
                if(nums[i] == nums[j]){
                    count++;
                    j++;
                }
                else{
                    j++;
                }
            }
            i++;
            j = i + 1;
        }
        return count;
    }

    public static int numIdenticalPairss(int[] nums) {
        int count = 0;
        int i;
        int j = 1;
//i: 0 -> till i equals or exceeds j
        for (i = 0; i < j; i++) {
            for (j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}

