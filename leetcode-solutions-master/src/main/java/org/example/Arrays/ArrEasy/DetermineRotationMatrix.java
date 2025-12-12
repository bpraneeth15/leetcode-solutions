package org.example.Arrays.ArrEasy;

public class DetermineRotationMatrix {

    public static void main(String[] args){

        int[][] matrix = {{0,1},{1,0}};
        int[][] target = {{1,0},{0,1}};

        System.out.println(findRotation(matrix, target));

    }

    public static boolean findRotation(int[][] mat, int[][] target) {
//for a 2D array, max rotation count is 4
        int n = mat.length;
        int rotationCount = 0;
        int[][] rotatedMat = mat;//initially call the method for once
        boolean foundMismatch = false;
        //we first have to check if the two array lengths are equal or not
        if(mat.length != target.length){
            return false;
        }

        //compare if no of columns are equal
        if(mat[0].length != target[0].length){
            return false;//if no of columns are not equal
        }

        while(rotationCount < 4){
            for(int i = 0; i < rotatedMat.length; i++){
                for(int j = 0; j < rotatedMat[i].length; j++){
                    //check if each element of rmat[][] is equal to target[][]
                    if(rotatedMat[i][j] == target[i][j]){
                    }
                    else{
                        foundMismatch = true;
                        break;
                    }
                }
                if(foundMismatch) break;
            }
            //after comparisons are done
            if(!foundMismatch){
                return true;
            }
            foundMismatch = false;
            rotatedMat =  rotateArray(rotatedMat);
            rotationCount++;
        }
        return false;
    }

    public static int[][] rotateArray(int[][] matrix){
        int n = matrix.length;
        int[][] rotatedMatrix = new int[n][n];

        //step 1: transpose

        for(int i = 0; i < matrix.length; i++){

            int colLastIndex = matrix[i].length-1;
            for(int j = 0; j < matrix[i].length; j++){

                rotatedMatrix[i][colLastIndex - j] = matrix[j][i];
            }
            //one inner loop gives us one entire row, after transposing, we will directly reverse it

        }
        return rotatedMatrix;
    }
    }


