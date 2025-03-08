package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwoDimArrList {

    public static void main(String[] args) {

        //creating and declaring a scanner object and arraylist
        Scanner sc = new Scanner(System.in);
        int input;

        ArrayList<ArrayList<Integer>> arrayList1 = new ArrayList<>(5);//5 array lists inside this arraylist
        /*Inputing steps:
        * 1.Use a loop based on the needs(for/while)
        * 2.since we don't know whats the size before hand we use while loop
        * 3. we create those inner arrayList in onestep ahead of inputting elements/we directly input arrayLists with elements which we cannot do.
        * 4. After creating arrayLists we insert elements
         */

//        arrayList1.add(new ArrayList<>());
//        System.out.println(arrayList1.size());
        int row = 0;
        while(row < 5) {
            System.out.println("Enter elements for row " +row);

                System.out.println("Creating a new array list at index " + row);
                arrayList1.add(row, new ArrayList<>());//represent a row of arrayList1

                while (true) {//inner loop for inserting elements into the new arraylist

                    if (sc.hasNextInt()) {
                        input = sc.nextInt();//this reader doesn't consume the non-integer input from the buffer
                        arrayList1.get(row).add(input);
                    } else {
                        String nonInteger = sc.next();
                        System.out.println("you have entered a non integer. Exiting inner loop...");
                        break;
                    }
                }

            System.out.println("arrayList at index " +row + " : " + arrayList1.get(row));
            row++;
        }
//this loop is for outputting the elements
        for(ArrayList<Integer> arrayList : arrayList1){
            System.out.println(arrayList);

        }
    }
}