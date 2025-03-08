package org.example;
/**/
public class findNumbersEvenDigits {

    public static void main(String[] args) {

        int[] arr = new int[]{1, -22, 224, 123, -2456};

//        int result = findNumbers(arr);
//        System.out.println(result);
        int noOfDigitss = digits2(2456);
        System.out.println(noOfDigitss);
        }

    static int findNumbers(int[] arr){

        int count = 0;
        if(arr == null || arr.length == 0){
            return 0;
        }

        //loop for the array
        for(int number : arr){
            if(number < 0){
                number = number * -1;
            }
            if(even(number)){
                count++;
            }
        }
        return count;
    }

    static boolean even(int number){
        return digits2(number) % 2 == 0;
    }

    private static int digits(int number) {
        int noOfDigits = 0;
        while(number != 0){

            number = number /10;

            noOfDigits++;
        }

        return noOfDigits;//we should return a boolean expression
    }

    static int digits2(int number) {

        return (int)(Math.log10(number)) + 1;
    }
}
