package org.example;

public class MaxPop {

    public static void main(String[] args) {

        int[][] logs = {
                {1993,1999},
                {2000,2010}
        };

        System.out.println(maximumPopulation(logs));

    }


    public static int maximumPopulation(int[][] logs) {


        int maxAlive = 1;
        int birth = 0;
        int death = 1;
        int year = 2050;//initialize to max birth year and keep minimizing it


        for(int row = 0; row < logs.length-1; row++){

            //check if the birth of the next person is overlapping with the death of the current person
            if(logs[row + 1][birth] < logs[row][death]) {

                maxAlive++;//if overlaps then increment maxAlive
                if (logs[row + 1][birth] < year) {//if a person is added and that year is lesser, then that year is initialized as
                    //the earliest year after incrementing the maxAlive.
                    year = logs[row + 1][birth];//update the year as the earliest year
                }
            }

        }
        return year;
    }
}