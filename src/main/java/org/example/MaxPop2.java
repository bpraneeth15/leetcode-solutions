package org.example;

import static java.sql.Types.INTEGER;

public class MaxPop2 {

    public static void main(String[] args) {


    }

    public static int maxPop(int[][] logs){

        int n = logs.length;//length of the 2d array
        //no of rows

        int earliestYear = 0;
        int[] population = new int[101];//to track the population in each year,
        //FI is 1950 + 0 --> 1950+ length - 2;
        //0 ---> 100==> 1950+0--->1950 + 100==>1950 --> 2050
        //for each iteration/i value
        //compare/check if birth of one person is lesser than the other person,
        //make comparisons for all the inner arrays(persons) that are given
        //

        for(int i =0; i < logs.length - 1; i++){
//since iterating through the logs array
           //simply incrementing the elements at that year indexes
            population[logs[i][0] - 1950]++;//incrementing the birth years
            population[logs[i][1] - 1950]--;//decrementing the death years
        }

        int totalPopulation = 0;
        int minYear = 1950;//by defalult
        int maxPopulation = Integer.MIN_VALUE;

        //now transform the population array in such a way that each year reflects the population count at that year
        //for ensuring that the population is calculated for every year, we perform a running sum total in the array
        for(int i =0; i < population.length; i++){
            //each iteration/i is the year index
            //as we iterate we calculate the running sum, so that the population is reflected in all the years mentiojned
            totalPopulation += population[i];//keep summing values at all indexes
            //at the same time, insert/update those values into the population array at that particular year indexes
            population[i] = totalPopulation; //this way we are also storig that particular population count at that year index
        }
        //after transforming the pop array, now since it has the actual population count now we can iterate through it again t
        //to find out the maximum value and return the earliest index of the max value/


        for(int i=0; i < population.length; i++) {
//population[i] represents the actual total population at that particular array , which we acquire by calculating running sum

            if (population[i] > maxPopulation) {
                maxPopulation = population[i];
                //update the year as well.
                minYear = 1950 + i;//converting index into actual year
            }
        }
        return minYear;
    }
}
