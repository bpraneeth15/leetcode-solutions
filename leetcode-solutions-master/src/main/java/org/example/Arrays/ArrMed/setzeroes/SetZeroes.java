package org.example.Arrays.ArrMed.setzeroes;

import java.util.Arrays;

public class SetZeroes {

    public static void main(String []args){

        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        setMatrix(matrix);

    }
    public static void setMatrix(int[][] matrix){

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] rowArray = new boolean[rows];
        boolean[] colArray = new boolean[cols];

        //traverse through the matrix
        //as soo as we find 0 break, the nested loop increment the pointer and pass the control to fill out the 0s

        for(int i = 0; i < rows; i++){

            for(int j = 0; j < cols ; j++){

                if(matrix[i][j] == 0){
                    rowArray[i] = true;
                    colArray[j] = true;
                }
            }
        }

        //now we have to set that entire row and columns to 0

        //iterate through the generated boolean arrays
        //Iterate through the first array, until you find true
        //boolean[] rowArray = new boolean[rows];

        for(int i =0; i < rowArray.length; i++) {
            //if we find true at index i then that entire ith row i matrix becomes 0
            if(rowArray[i] == true) {
                for (int col = 0; col < matrix[0].length; col++) {
                    //if true then we set entire row to 0(keep i as constant and increment cols
                    matrix[i][col] = 0;
                }
            }
        }
        //iterate through the second boolean array until we find true
        //this time we will keep col as constant and increment
        //boolean[] colArray = new boolean[cols];

        for(int i = 0; i < colArray.length; i++){

            //if we find true at index i then we set entire col as costant and increment row setting the positions to 0.
            if(colArray[i] == true){
                for(int row = 0; row < matrix.length; row++){
                    matrix[row][i] = 0;
                }
            }
        }
    System.out.println(Arrays.deepToString(matrix));
    }
}
