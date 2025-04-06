package org.example.Arrays.ArrMed.maxsubarray;

public class Product_Sum {
    public static void main(String[] args) {
        subtractProductAndSum(15);
    }
    public static void subtractProductAndSum(int n) {
        int product_Of_Digits = 1;
        int sum_Of_Digits = 0;
//        Scanner input = new Scanner(System.in);
//
//        n = input.nextInt();
        int rem = 0;
        while(n > 0){

            rem = n % 10;
            product_Of_Digits *=  rem;
            System.out.println("product_Of_Digits: " + product_Of_Digits);
            sum_Of_Digits += rem;
            System.out.println("sum_Of_Digits: " + sum_Of_Digits);
            n = n/10;
        }

        int result = product_Of_Digits - sum_Of_Digits;
        System.out.println(result);
    }

}
