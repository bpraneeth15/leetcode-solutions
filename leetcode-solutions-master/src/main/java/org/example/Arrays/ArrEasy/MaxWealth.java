package org.example.Arrays.ArrEasy;

public class MaxWealth {
    public static void main(String[] args) {

        int[][] a = {{1,2,3},
                    {4,5,6},
                {0,0,0}};

        int maxWealth = maximumWealth(a);
        System.out.println(maxWealth);
        }

     static int maximumWealth(int[][] a){
        int max_Value = 0;

        for(int row = 0 ; row<a.length; row++){
            int sumOfWealth = 0;
            for(int col = 0; col< a[row].length; col++){

                sumOfWealth += a[row][col];
            }
            if(sumOfWealth > max_Value){

                max_Value = sumOfWealth;
            }
        }
        return max_Value;
    }
}
