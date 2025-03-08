package org.example;

import java.util.Scanner;

public class SumOfAllNum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        int largest = 0;
        while ( num != 0) {

                sum += num;
                if(largest < num){
                    largest = num;
                }
                num = sc.nextInt();

        }
        System.out.println(sum);
        System.out.println(largest);
    }
}
