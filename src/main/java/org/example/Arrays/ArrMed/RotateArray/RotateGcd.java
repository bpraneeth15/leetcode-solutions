package org.example.Arrays.ArrMed.RotateArray;
//rotation based on GCD

public class RotateGcd {

   public static void main(String[] args){

       int[] nums = {1, 2, 3, 4, 5, 6, 7};
       int k = 3;
       rotate(nums,k);

    }


       public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Normalize k if it's larger than array size
        int count = 0; // How many elements we've rotated

        int gcd = getGCD(n, k);

        for (int start = 0; start < gcd; start++) {
            int current = start;
            int prev = nums[start];

            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current); // Complete the cycle
        }
    }

    private static  int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
