package org.example.Arrays.ArrEasy;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //first we take the initial values 0 , 1 then take their sum value

        int a = sc.nextInt();
        int b = sc.nextInt();

        //since we dont know what value will be asked or how big the fibonacci series is going to be
        int n = sc.nextInt();
        System.out.println(a);
        System.out.println(b);
        int i = 2;
        //instead of the if condition, we can directly print 0 and 1 before start of the loop and then start the index from 2
        //which is a good idea
        int  c = 0;
        while(i<=n){
//            if(i < 2){
//                System.out.println(a);
//                i++;
//                System.out.println(b);
//                i++;
//            }
             c = a + b;
            System.out.println( c );
            a = b;//after print assign b's vale to a and c's val to b
            b = c;
            i++;
        }
        System.out.println(b + "" + c);
    }
}
