package org.example.Arrays.ArrEasy;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {

    public static void main(String[] args){
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};

        System.out.println(luckyNumbers(matrix));
    }
    public static List<Integer> luckyNumbers(int[][] matrix) {

        int[] min_Element_Index = new int[matrix.length];//store column indexes
        List<Integer> luckyNumbers = new ArrayList<>();

        /**Finding minimum elements in each row */
        for(int i = 0; i < matrix.length; i++){
            int minRow = Integer.MAX_VALUE;//re initialize the minRow value for each row

            for(int j = 0; j < matrix[i].length; j++){

                //traverse through the array and store minim elemnt columns(j)s into the min_Element_Index array
                if(matrix[i][j] < minRow){
                    minRow = matrix[i][j];
                    min_Element_Index[i] = j;//only update/store the index when you find the minimum element
                }
            }
        }
        //   /*Finding the maximum element in the min row values's columns */
        for(int i = 0; i < min_Element_Index.length; i++){
            //use these column values and compare only those columns chaging the row

            //column index of each row minimum
            int minColIndex = min_Element_Index[i]; //stores the column index at each iteration
            int minRowValue = matrix[i][minColIndex]; // this is the minimum value of that particular row and column,
            boolean isLucky = true;

            //because index i = 0 stores the min element's index of 0th row of matrix[][]..so on..

            for(int j = 0; j < matrix.length; j++){

//compare the min row value with the value at that particular min col index and row index
                if( minRowValue < matrix[j][minColIndex]){//if yes then simply mark it as the lucky number
                    //marking lucky as false if above condition is met, if any other element is greater than the minRow Value we dont further compare therefore we break
                    isLucky = false;
                    break;
                }
            }
            if(isLucky){
                luckyNumbers.add(minRowValue);
            }
        }
        return luckyNumbers;

    }
}
/**Steps:
 1. Traverse through the 2d array and pick the minimum elements in each row,
 since each of these minimum elements have the potential to be a lucky number, i will have to store these minimum elements somewhere
 2. for each minimum element now find the maximum element of that column,
 3. for step 2 , i have to store the column indexes of the minimum elements not the minimum elements itself
 4. then for those columns only i will change the row value and then keep comparing, to see which of these minimum values are lucky numbers
 5. while each number gets passed as a lucky number i will store these numbers one by one into the list
 */
