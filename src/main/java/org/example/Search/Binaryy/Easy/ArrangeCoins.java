package org.example.Search.Binaryy.Easy;

public class ArrangeCoins {

    public static void main(String[] args){

        int n = 10;

        System.out.println(arrangeCoins(n));
    }

    public static int arrangeCoins(int n){

        int validRow = 0;
        int i = 1;//start from i = 1 row
        while(i >= 0){

            n -= i;//add coins
            if(n >= 0){
                //check if n is still greater than or equal to 0
                i++;
                //go to the next ith row
                validRow++;
                //increment the  count of valid row
            }
            else{
                break;
            }

        }
        return validRow;
    }
}
