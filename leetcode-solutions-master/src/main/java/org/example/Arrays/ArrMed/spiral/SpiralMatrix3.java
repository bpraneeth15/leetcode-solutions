package org.example.Arrays.ArrMed.spiral;

import java.util.Arrays;

public class SpiralMatrix3 {
    public static void main(String[] args){

        int rows = 5;
        int cols = 6;
        int rStart = 1;
        int cStart = 4;

        System.out.println(Arrays.deepToString(spiralMatrixIII(rows, cols, rStart, cStart)));
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int noOfCoordinates = rows * cols;//5 * 6 = 30
        int[][] coordinateMatrix = new int[noOfCoordinates][];//this must have rows * cols no of coordinates
        int storedCoordinates = 0;
        int row = rStart;//1
        int col = cStart;//4
        int direction = 0;
        int steps = 1;
        while(storedCoordinates < noOfCoordinates){

            if(storedCoordinates == 0 ){
                storedCoordinates = getStoredCoordinates(rows, cols, row, col, coordinateMatrix, storedCoordinates);

            }
            if(direction == 0){
                //we move horizontally right
                for (int i = 0; i < steps; i++) {
                    col++ ; //1 + 1 = 2
                    storedCoordinates = getStoredCoordinates(rows, cols, row, col, coordinateMatrix, storedCoordinates);
                }
                direction++; //direction change happens
            }
            else if( direction == 1){
                //we move vertically down

                for (int i = 0; i < steps; i++) {
                    row++ ; //1 + 1 = 2
                    storedCoordinates = getStoredCoordinates(rows, cols, row, col, coordinateMatrix, storedCoordinates);
                }
                direction++;//2
                steps++;
            }
            else if ( direction == 2) {
                //we move h left

                for (int i = 0; i < steps; i++) {
                    col--;
                    storedCoordinates = getStoredCoordinates(rows, cols, row, col, coordinateMatrix, storedCoordinates);
                }
                direction++;
            }
            else if(direction == 3){
                //we move v up

                for (int i = 0; i < steps; i++) {
                    row--;
                    storedCoordinates = getStoredCoordinates(rows, cols, row, col, coordinateMatrix, storedCoordinates);
                }
                direction++;
                steps++;
            }
            else{
                direction = direction % 4;//4 % 4 = 0
            }
        }
        return coordinateMatrix;
    }

    private static int getStoredCoordinates(int rows, int cols, int row, int col, int[][] coordinateMatrix, int storedCoordinates) {
        if(row >=0 && col >=0 && row < rows && col < cols){
            //if the above condition satisfies only then store the coodinates
            coordinateMatrix[storedCoordinates] = new int[]{row, col};//directly storing the row of coordinates
            storedCoordinates++;
        }
        return storedCoordinates;
    }
}
