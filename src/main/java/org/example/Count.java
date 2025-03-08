package org.example;

import java.util.Scanner;

public class Count {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("enter the number");
        int n = input.nextInt();
        int desiredNumber = input.nextInt();
        int count = 0;
        while(n>0){

            int rem = n%10;
            if(rem == desiredNumber){
                count++;
            }
            n = n / 10; //updating n before moving on to the next iteration
        }
        System.out.println(count);


    }
}
