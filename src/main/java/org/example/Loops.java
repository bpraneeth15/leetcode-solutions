package org.example;

import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {
        /* we use :
        * 1. for loop: when we know how many times we must run a loop
        * ex: ques -> print the first 10 numbers
        * 2. while loop : Used when we do not know before hand how many tines we have to run the loop
        * ex: keep taking input from user till user press x
        * 3. Do while loop: used when we want to run loop for atleast once irrespective of the condition/ to check if it still meets the condition
        * ex:  take the input from the user till they give x(here inorder to see if the given i/p is x or not the loop should atleast run once for the first time*/

        //FIND THE LARGEST NUMBER
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

//    1st. approach-
//        int max  = a;
//        if(b > max) {
//            max = b;
//        }
//        if(c > max) {
//            max = c;
//        }
//   2nd approach - use of Math()
        int max = Math.max(Math.max(a,b), c);
        System.out.println(max);


    }
}
