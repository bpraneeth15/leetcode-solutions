package org.example.Search.Binaryy.Easy;

public class Square {

    public static void main(String[] args){

        int num = 14;// not a perfect square
        System.out.println(isPerfectSquareValid(num));

    }
    public static boolean isPerfectSquareValid(int num) {

        boolean isValid = false;
        int start = 0;
        int end = num;
        while(start <= end){

            int mid  = start + (end - start) / 2;
            //calculate the mid and eliminate the side you don't need

            if((long)mid * mid == num){

                isValid = true;
                break;
            }
            else if((long)mid * mid < num){

                //dial up by looking right
                start = mid + 1;
            }
            else{
                end = mid -1 ;
            }
        }
        return isValid;

    }
}
