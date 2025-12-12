package org.example.Arrays.ArrMed.spiral;
import java.util.Arrays;

public class Spiral2 {
    public static void main(String[]args){
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }
    public static int[][] generateMatrix(int n) {
        //create a matrix of size n * n
        int[][] ans = new int[n][n];
        int number = 1;
        int row = 0;
        int col = 0;
        int direction = 0;
        int index = 0;
        while(index < ans.length * ans[0].length ){
            while(col < ans[row].length){

                if(direction == 0){
                    ans[row][col] = number;
                    number++;
                    index++;
                    if(col < ans[row].length - 1 && ans[row][col + 1] == 0){
                        col++;
                    }
                    else{
                        row++;
                        break;//inner loop breaks
                    }
                }
                else if(direction ==1 ){
                    //if not visited then visit it
                    ans[row][col] = number;//addd the number to that position
                    number++;
                    index++;
                    if(row < ans.length -1 && ans[row+1][col] == 0){
                        row++;
                    }
                    else{
                        col--;
                        break;
                    }
                }
                else if(direction == 2){
                    ans[row][col] = number;
                    number++;
                    index++;
                    if(col > 0 && ans[row][col - 1] == 0 ){
                        col--;
                    }
                    else{
                        row--;
                        break;
                    }
                }
                else if(direction == 3){
                   ans[row][col] = number;
                    number++;
                    index++;
                    if(row > 0 && ans[row-1][col] == 0){
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
            else{
                direction++;
            }
        }
        return ans;
    }
}
