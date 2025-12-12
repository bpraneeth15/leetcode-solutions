package org.example.Arrays.ArrMed.gameOfLife;

import java.util.Arrays;

public class GameOfLife {

    public static void main(String[]args){

        int[][] matrix = {{1,0,0},{0,1,1},{1,1,1}};
        updateMatrix(matrix);

    }

    public static void updateMatrix(int[][] matrix){

        int rows = matrix.length;
        int cols = matrix[0].length;

        //create a 8 * 2 2d array for storing those fixed direction neighbors of i,j
        int[][] neighbors =
                {{-1,-1}, {-1,0}, {-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};//8 X 2 matrix 8 rows represent 8 different coordinates

        //these 8 represent the 8 directions we have to look at to access each neighbor
        //for each position we are at, we have to check in all those directions inorder to see if they are dead or alive
        /* {{-1,-1}, {-1,0}, {-1,1},
            {0,-1},  {0, 0}, {0,1},
            {1,-1},  {1,0},  {1,1}};*/
        int count = 0;
        for(int i  = 0 ; i < rows; i++){

            for(int j = 0; j < cols; j++){
                //while traversing
                // at each position we have to check the 8 neighbors
                //we have to decide when to check all of the 8 and when to ignore
                //if we are at any of the 4 corners we have to check only 3 neighbors
                //since adding the loop to check all the neighbors at each position doesnt include the time complexity because,

                //for eacch iteration we would be checking only those 8 neighbors therefore it would add a constant time complexity of O(8)
                for(int[] direction : neighbors){//each direction array has 2 elements, 0th element
                    while(direction[0] <= i && direction[1] <= j){
                        //the  origin
                        //we can skip directions till we arrive at points greater than 0,0
                        continue;
                    }
                    //now at each position we should add all those directions to the current one and check if they are alive or not
                    System.out.println(Arrays.toString(direction) + " " + count++);

                }


                }


            }
        }
    }
