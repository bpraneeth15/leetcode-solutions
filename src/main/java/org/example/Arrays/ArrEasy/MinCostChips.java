package org.example.Arrays.ArrEasy;

public class MinCostChips {

    public static void main(String[] args) {

        System.out.println(minCostToMoveChips(new int[]{1, 2, 3}));
    }

    public static int minCostToMoveChips(int[] position) {


        int evenNumbers = 0;
        int oddNumbers = 0;
        for (int i = 0; i <= position.length - 1; i++) {

            //count the no of even and odd positions return the value of lesser couont
            if (position[i] % 2 == 0) {
                //even'
                evenNumbers++;
            } else {
                oddNumbers++;
            }
        }
        return oddNumbers < evenNumbers ? oddNumbers:evenNumbers;
    }
}


//Question explanation:
//