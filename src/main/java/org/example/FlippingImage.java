package org.example;

import java.util.Arrays;

public class FlippingImage {

    public static void main(String[] args) {
        int[][] image = {{1,1,0}, {1,0,1}, {0,0,0}};

        System.out.println(Arrays.deepToString(flipAndInvertImage(image)));

    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int[][] resultImage = new int[n][n];

        for(int row = 0; row < n; row++){
            //Each iteration for each row
            int rowLength = image[row].length;
            for(int col = 0; col < rowLength; col++){
                //col = 0--> if(image[0][0] = 1)-->1-1 = result[0][image[0].length - 1]->result[0][3-1]= result[0][2] = 0
                //In each iteration, we iterate through each col
                //i.e, iterating through each column one by one in each row
                if(image[row][col] == 0){
                    resultImage[row][rowLength - 1] = image[row][col] + 1;
                }
                else{
                    resultImage[row][rowLength - 1] = image[row][col] - 1;
                }

            }
        }
        return resultImage;
    }
}
