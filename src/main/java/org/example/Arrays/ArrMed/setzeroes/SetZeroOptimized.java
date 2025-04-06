package org.example.Arrays.ArrMed.setzeroes;

import java.util.Arrays;

class SetZeroOptimized {

    public static void main(String[] args){

        int[][] matrix = {{1,2,3},{4,5,6},{7,0,9}};
        int[][] matrix1 = {{0,1}};
        setZeroes(matrix1);

    }
    public static void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean colZeroHasZero = false;

        for(int i = 0; i < rows; i++){

            if(matrix[i][0]==0){
                colZeroHasZero = true;
                if(i == 0){
                    matrix[i][0] = -1;
                }
            }
            for(int j = 1; j < cols; j++){

                if(matrix[i][j] == 0){
                    matrix[i][0] = -1;//true
                    matrix[0][j] = -1;//true
                }
            }
        }
        //after setting markers;
        //bottom - up traverse(reason mentioned in the comments section)
        for(int i = matrix.length-1 ; i >= 0; i--){
            for(int j = matrix[0].length-1; j > 0; j--){//3-1 = 2  -->2 and 1
                if(matrix[i][0] == -1 || matrix[0][j] == -1){

                    matrix[i][j] = 0;
                }
            }//this internal loop is run only for row 2, 1, not 0 because zeroiing out entire zeroeth row is solely based on isRowZero var

            if(colZeroHasZero || matrix[i][0] == -1){
                matrix[i][0] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
    }
//identify and store/mark positions if the colums or any rows have zeros in it
// instead of using additional memory, we use the first/0th row to mark which columns have zeroes in it
//similarly for marking which rows have zeroes in them we use the first/0th column
//but the catch is we end up having a single cell (origin cell) that is common. i.e., if we consider first row and column to
//mark the zeroed row or column the first cell

        /*[[1 2 0],
        *  [4 0 6],
        *  [5 6 7]]- in this example if we mark first row on the basis of whether a column as a zero or not
like this --> [[1 2 0],
         *     [4 0 6],
         *     [5 6 7]]  -- we mark as leastNeg
         *     starting at mat(0,0) no zero in 0th col we leave(0,0) and move on to the next (0,1)pos
         *     (0,1) has =2 we leave it, move to
         *     (0,2), has 0 therefore we mark (0.2) as -1 and update 0,0 to -1
         *  [[-1 2 -1],
         *   [4  0  6],
         *   [5  6  7]]-
         * next= (2,0) pos = 4 as per the condition no zero therefore we leave it
         * next - (2,1) =0 , update that columns 0th row to -1 and that rows 0th col to -1
         * next-(2,2) = 6, leave
         * updated matrix looks like this
         * [-1 -1 -1],
         * [-1  0  6],
         * [5  6  7]]
         * next= (3,0) pos = 5 as per the condition no zero therefore we leave it
         * next - (3,1) =6 , update that columns 0th row to -1 and that rows 0th col to -1
         * next-(3,2) = 7, leave
         * * [-1(c) -1(c) -1(c/orig)],
         *   [-1(c)  0(orig)  6],
         *   [ 5      6       7]]
         * -----------------
         *  [-1 -1 -1],
         *  [-1  0  6],
         *  [5  6  7]]
         * now using the markers to zero out ,
         * whenever we are at a certain pos in the matrix
         * we check if that particular position's 0th col and 0th row has marker(-1) or not
         * if yes we update it to zero
         * [-1 -1 -1],
         * [-1  0  6],
         * [5  6  7]]
         * -- now using bottom up traversal
         * we start at (2,2) = 7 , we update it to 0 based on the condition
         * if(0th row of the same col has marker -1 or not /OR/ 0th col of same row as -1
         * (0,2) = -1 therefore we update 2,2 to 0
         * next -> 2,1 = 6 ==> 0 since, 0,1 has -1
         * next -> 2,0 = 5 ==> 0 since, 0,0 has -1
         * 1,2 = 6 ==>0 since, 0,2 has -1
         * 1,1 = 0 ==> 0 0,1 has -1
         * 1,0 = -1 ==>0 since, 0,0 has -1 and 1,0 has -1
         * 0, 2= -1==>0 since, 0,1 has -1 and 0,0 has -1
         * 0,1=-1==>0; (0,0) = -1 ==>0
         * result = [[0   0   0],
         *           [0   0   0],
         *           [0   0   0]]---- wrong answer because from the given array/matrix
         * our answer for
         * [[1 2 0],
        *  [4 0 6],
        *  [5 6 7]]
        * should look something like this below
         * [[0  0  0],
        *  [0   0  0],
        *  [5   0  0]]-- here 5 is suppposed to be as it is
        * because there were no zeroes present in the 0th col or 0th row, but we still ended up
        * marking 0,0 as -1 because we had zero in the 0th row, but not 0th col
        *  when we thought of considering the 0th row and 0th col
        * as markers that means we moved the array inside of the matrix
        * we were sure that if the position 0,1 contains -1 we update the current pos in col 1 to 0,
        * if we are at (1,2) since 0,2 had -1 or 1,0 had -1 we marked 1,2 to 0, but now the question is what if
        * we are at (2,0) and 0,0 had -1(which is not the initially given 0th position but the one we ended up updating it
        * just because the 0th row has 0 in it, then if we are using 0,0 to mark if the 0th row has 0 in it or not
        * what if the 0th col has 0 in it? what will we use is the question, if there is no 0 in the 0th col
        * but we still have 0,0 as -1 we end up zeroing all the elements in the 0th col which is a grave mistake
        * this is happening because 0th row and 0th col has a common cell (0,0) other than this one particular cell
        * they  have seperate cells like they have for the rest of the positions (0,1); (1,0) etc
        * ote
        * [[-1(not supposed)   2     0],
        *  [4                  0     6],
        *  [5                  6     7]]and
        * to avoid  using 0,0 as a common cell to mark we use 1 seperate variable either for marking if the first col has 0 or not
        * or-- row 0 has zero or not
        * if we use a seperate variable, then isColZero remains as it is without getting marked to -1 while marking the matrix
        * we can use any type of variable if we use integer we use a value that is not present within the range given for then elements
        * or instead of dealing with the numbers we simply use the boolean variable, we can simply set it to true or let it remain false
        * if we use isColZero variable to mark if the col0 has 0 or not, we update col 0 elements seperately based on only if isColZero = true/faalse
        * if we use isRowZero variable, we first use a seperate linear loop to mark if 0 is present in the first row and start nested loop from row 1
        * and we update the elements of row 0 to zero seperately , solely on the basis of if the isRowZer0 is zero or not
        *  [1 2 3]
        *  [3 4 5]
        *  [5 0 7] * */

//after maarking use these markers to zero out the positions
//we dont use simple top to bottom traverse because the main marking arrays we use here is 0th row and 0th col
//if we start from top to bottom left to right the current position that we encounter is a th e0th row or 0th column,
//which we dont want to enter because, if we enter we update those important marker cells whcih will result in loss of data

//therefore , we start coming from the not marker row/col
//in each iteration, marker col is marked at the end of marking all the remainig columns
