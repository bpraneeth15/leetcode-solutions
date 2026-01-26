package org.example.Arrays.ArrEasy;

public class OddNumbersInMatrix {

    public static void main(String[] args) {

        System.out.println(oddCells(2, 3, new int[][]{{0,1}, {1,1}}));
    }


    public static int oddCells(int m, int n, int[][] indices) {

        //create an m x n result array
        int[][] result = new int[m][n];
        int[] rows = new int[indices.length];
        int[] cols = new int[indices.length];
        int noOfOddCells = 0;

        //extract the values from the indices array
        for(int i = 0; i <= indices.length-1; i++){

            //each row is a coordinate
            rows[i] = indices[i][0]; //ri values are all on the 0th col/ 0th index of each 1-D array

            cols[i] = indices[i][1]; //ci values are all on the 1st col/ index-1 of each 1-D array
        }

        //after storing the values use these values from the matrixes rows and cols
        for(int r = 0; r <= rows.length-1; r++){

            //incrementing the entire row by changing the cols
            for(int i = 0; i <= n-1; i++){
                result[rows[r]][i]++;
            }

            //increment the entire col by changing the rows
            for(int j = 0; j <= m-1; j++){
                result[j][cols[r]]++;
            }
        }

        //count by iterating
        for(int i = 0; i < result.length; i++){
            for( int j = 0; j < result[i].length; j++){

                //count and verify each cell if it is an odd value or not
                if(result[i][j] % 2 != 0){
                    //it is an odd number
                    noOfOddCells++;
                }
            }
        }

        return noOfOddCells;
    }
    }
