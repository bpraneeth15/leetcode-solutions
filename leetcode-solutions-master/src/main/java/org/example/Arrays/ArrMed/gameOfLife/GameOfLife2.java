package org.example.Arrays.ArrMed.gameOfLife;

import java.util.Arrays;

public class GameOfLife2 {

    public static void main(String[] args){

        int[][] matrix = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(matrix);
        System.out.println(Arrays.deepToString(matrix));


    }

    public static void gameOfLife(int[][] matrix){

        int rows = matrix.length;
        int cols = matrix[0].length;

        //create a 8 * 2 2d array for storing those fixed direction neighbors of i,j
        int[][] neighbors =
                {{-1,-1}, {-1,0}, {-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};//8 X 2 matrix 8 rows represent 8 different coordinates

          /* {{-1,-1}, {-1,0}, {-1,1},
            {0,-1},  {0, 0}, {0,1},
            {1,-1},  {1,0},  {1,1}};*/
        //traverse the positions

        for( int i  = 0 ; i  < rows ; i++){

            for( int j  = 0 ; j < cols; j++){

                int aliveNeighbors = 0;//the alive Neighbors will reset to 0

                //at each position check the neighbors
                //now for each position the neighbor position must be greater than equal to 0,0 and row-1, col-1
                //the range of the neighbor's row position is between the origin 0,0 -----rows-1, cols-1
                for(int[] directionOffSet : neighbors){

                   int newRow = i + directionOffSet[0];
                   int newCol = j + directionOffSet[1];

                   if(newRow >= 0 && newRow <= rows-1 && newCol >= 0 && newCol <= cols - 1){
                       if(matrix[newRow][newCol] == 1 || matrix[newRow][newCol] == -1){
                           aliveNeighbors++;
                       }
                   }
                }
                //4 rules here
                //rule of remaining dead
                if(aliveNeighbors < 2 || aliveNeighbors > 3){
                    //remains dead  or killed
                    if(matrix[i][j] == 1){
                     //if alive then only kill if dead do nothing, since it is already have to be dead
                     matrix[i][j] = -1;
                    }
                }

                if( aliveNeighbors == 3 && matrix[i][j] == 0){
                    matrix[i][j] = 2;//revive
                }

            }
        }
        //step 2 : re traverse the same updated matrix and update or change all the killed to 0 and
        //all that are revived are updated to 1
        for(int i = 0; i < rows; i ++){

            for( int j = 0; j < cols; j++){

                if(matrix[i][j] == -1){
                    //if killed inm the previous step updating it to 0
                    matrix[i][j] = 0;
                }
                if(matrix[i][j] == 2){
                    //if revived make it alive
                    matrix[i][j] = 1;
                }
            }
        }
    }
}


