package org.example.ArrMed.spiral;

import java.util.ArrayList;
import java.util.List;

public class Spirraal {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        List<Integer> ans = spiralTraverse(matrix);
        System.out.println(ans);

    }

    public static List<Integer> spiralTraverse(int[][] matrix) {

        int row = 0;
        int col = 0;

        int direction = 0;
        List<Integer> ans = new ArrayList<Integer>();

        int visited = 101;
        int index = 0;
        while (row < matrix.length) {
            switch (direction) {

                case 0:
                    ans.add(index, matrix[row][col]);//move right
                    index++;
                    col++;

                    break;

                case 1:
                    row++;
                    break;

                case 2:
                    col--;
                    break;

                case 3:
                    row--;
                    break;

            }
        }
        return ans;
    }
}