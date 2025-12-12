package org.example.Arrays.ArrEasy;

public class HighestAltitude {

    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        int result = largestAltitude(gain);
        System.out.println(result);
    }

    public static int largestAltitude(int[] gain) {

        int netGain = 0;
        int n = gain.length;
        int[] altitudeGain = new int[n+1];
        int maxValue = Integer.MIN_VALUE;

        int i = 0;
        while(i <= n);
        if(i == 0){
            altitudeGain[i] = 0;
            maxValue = altitudeGain[i];
            i++;
        }
        else{
            netGain = netGain + gain[i - 1];
            altitudeGain[i] = netGain;
            if(maxValue < altitudeGain[i]){
                maxValue = altitudeGain[i];//this way we will keep updating it at each iteration.
            }
            i++;
        }
        return maxValue;
    }
}

