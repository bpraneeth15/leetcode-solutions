package org.example.Arrays.ArrMed.setzeroes;

import java.util.Arrays;

public class SetZeroesOpt1 {

    public static void main(String[] args){
        int[][] matrix= {{0,2,3},
                         {0,5,0},
                         {0,5,0}};
        int[][] matrix1 = {{0,1}};

        setZero(matrix1);

    }
    public static void setZero(int[][] matrix){

        int rows = matrix.length;
        int cols = matrix[0].length;
        //used for marking if the column 0 has zeroes in it
        boolean isColZero = false;
        /*{{0,2,3},
           {0,5,7},
           {0,5,0}};*/
        //we should also make sure we are marking the 0th column whenever we find 0 in any of the rows
                /*{{0,2,3},
                  {0,5,7},
                  {0,5,0}};*/

        //if we are using any other value   for marking other than 0 then we have to explicitly mark the 0th column in that particular row
        //if we were marking row 0 for columns, mat[0][0] = 0 initially then we have to set the entire row 0 to 0s,
        //if we were marking mat[i][0] mat[0][j] to 0 then we use the matrix[i][0] == 0 || matrix[0][j] ==0 condition to update values to 0 ,
        //hence updating the entire row 0 to 0
        //if we were using -1 as a marker then we will be ignoring the cell 0,0
        //because we only update the poitions in the matrix based on if its 0th col or 0th row is equal to -1 not 0, thereby incorrectly ignoring to
        //update the entire row to 0
        //if any of the row has 0s in the 0th column like row 1 in the input
        /*{0,5,7}, if we mark based on zeroes we ignore 0th col because  we will iterate from col 1 till end and keep marking 0th col and 0th row*/
        for(int i = 0; i < rows; i++){

            //check if the 0th col in any row has 0s in it or not
            if(matrix[i][0] == 0){
                //if any row in 0th col has zeros we set isColZero as true
                isColZero = true;
            }
            for(int j = 1; j < cols; j++){

                //at each position we check if there are any zeroes in the matrix.
                if(matrix[i][j] == 0){
                    //if any element is 0 then we mark its corresponding position in the 0th row and 0th col to 0
                    matrix[i][0] = 0;//corresponding row pos at the 0th col ex : row 2 - {0,5,0} has 0 in its 0th col then we
                    // mark 0th col of the row 2 as 0 only . it is still the same
                    matrix[0][j] = 0; //corresponding col pos at the 0th row we can use any value instead of marking them as 0,
                    //marking 0 make it so convinient because however at the end those positions at 0th col/row must become 0
                }
            }
        }
        /*Step 2: back traversing the matrix to zero out necessary marked  positions in the matrix */
        for(int i = rows - 1; i >= 0; i--){
            for(int j = cols - 1; j > 0; j--){

                //check if each position should be zeroed out or not based on the markings
                //if the 0th row of that current pos is 0 then update current pos to 0 similarly if 0th col of that current pos is 0 then
                // update that current pos to 0
                if(matrix[i][0] == 0 || matrix[0][j] ==0 ){
                    matrix[i][j] = 0;
                }
            }
            //after going till j = 1 seperately handle j =0
            if(isColZero){
                matrix[i][0] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
