package org.example;

import java.util.ArrayList;
import java.util.List;

public class MaxCandieKid {

    public static void main(String[] args) {

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int n = candies.length;
        List<Boolean> result = new ArrayList<>(n);

        int maxCandieKid = maxCandieKid(candies);
        for(int i = 0; i < n; i++){
            //compare with max Candie kid

            result.add(i, candies[i] + extraCandies >= maxCandieKid);
        }
        return result;
    }
    //instead of comparing with every kid, i will just compare with the max candie kid in the given array
//find out who is the max candie kid in the given array then compare with that kid after adding
    static int maxCandieKid(int[] array){

        int start;
        int end = array.length -1;
        int maxValue = 0;
        //linear search to find out maximum value of the array
        for(start = 0; start <= end; start++){

            if(maxValue < array[start]){
                maxValue = array[start];
            }
        }
        return maxValue;
    }
}
