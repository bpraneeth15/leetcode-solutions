package org.example;

import java.util.Scanner;

public class ReverseNum {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("enter the number");
        int n = input.nextInt();

        while(n>0){
            int newNum = 1;
            int rem = n%10;
//            if(rem == desiredNumber){
//                count++;
//            }
            newNum = newNum*rem;
            System.out.print(newNum);
            n = n / 10; //updating n before moving on to the next iteration
        }


    }
}
