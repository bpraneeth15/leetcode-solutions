package org.example.ArrMed.spiral;

import java.util.ArrayList;
import java.util.List;

public class Spiral {
    public static void main(String[] args){

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);
    }
    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> ans = new ArrayList<>();
        int visited = 101;
        int row = 0;
        int col = 0;
        int direction = 0;
        int index = 0;
        //when row = 0. col = 0, increment col to length of row
        //when row =0, col = limit, increment row to length
        //when row = limit, col = limit, decrement col to 0
        //when row = limit, col = 0 , decrement row-
        while(index < matrix.length * matrix[0].length ){
            while(col < matrix[row].length){

                if(direction == 0){
                    ans.add(index, matrix[row][col]);
                    index++;
                    matrix[row][col] = visited;
                    if(col < matrix[row].length - 1 && matrix[row][col + 1] != visited){
                        col++;
                    }
                    else{
                        row++;
                        break;//inner loop breaks
                    }
                }
                else if(direction ==1 ){
                    //if not visited then visit it
                    ans.add(index, matrix[row][col]);//adds the laast element of the first row initially
                    matrix[row][col]= visited;  //after adding mark as visited
                    index++;
                    if(row < matrix.length -1 && matrix[row+1][col] != visited){
                        row++;
                    }
                    else{
                        col--;
                        break;
                    }
                }
                else if(direction == 2){

                    ans.add(index, matrix[row][col]);
                    index++;
                    matrix[row][col] = visited;

                    if(col > 0 && matrix[row][col - 1]!=visited ){
                        col--;
                    }
                    else{
                        row--;
                        break;
                    }
                }
                else if(direction == 3){
                    ans.add(index, matrix[row][col]);
                    index++;
                    matrix[row][col] = visited;
                    if(row > 0 && matrix[row-1][col] != visited){
                        row--;
                    }
                    else{
                        col++;
                        break;
                    }
                }
            }
            if(direction == 3) {
                direction = 0;
            }
            else {
                direction++;//direction becomes 1 after checking if the next row element is not visited
            }
        }
        return ans;
    }
}
