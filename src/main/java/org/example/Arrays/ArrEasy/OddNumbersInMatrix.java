package org.example.Arrays.ArrEasy;

public class OddNumbersInMatrix {

    public static void main(String[] args) {

    }


    public int oddCells(int m, int n, int[][] indices) {

        int[][] matrix = new int[m][n];
        int result = 0;
        int[] rowMatrix = new int[indices.length];
        int[] colMatrix = new int[indices.length];

        //extract the values of rows and columns that should be incremented first
        for(int i = 0; i < indices.length; i++){
            rowMatrix[i] = indices[i][0];
            colMatrix[i] = indices[i][1];
        }

        //increment the matrix array based on the values generated
        //rowMatrix entire row must be incremented
        for(int col = 0; col < n; col++){
            matrix[rowMatrix][col]++;
        }

        for(int row = 0; row < m; row++){
            matrix[row][colMatrix]++;
        }






        return result;
    }
}
