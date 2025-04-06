package org.example.Arrays.ArrEasy;

public class MatDiagonal {

    public static void main(String[] args) {
        int[][] input = {{1,2,3}, {4,5,6}, {7,8,9}};

        System.out.println(diagonalSum(input));
    }

    public static int diagonalSum(int[][] mat) {

            //
            int start = 0;
            int end = mat.length - 1;//since it is a square matrix
            int sum = 0;
            int i =0;
            int mid = mat.length / 2;
            while(i < mat.length){

                if(mat.length % 2 !=0 && start == mid && end ==mid) {//if length is odd

                    sum += mat[i][start];
                }
                else{
                    sum += mat[i][start] + mat[i][end];
                }
                start++;
                end--;
                i++;
            }

            return sum;
        }
}
