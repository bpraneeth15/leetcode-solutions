package org.example.Arrays.ArrEasy;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayL {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //creating a one dimensional arrayLIST

        ArrayList<Integer> arrayList1 = new ArrayList<>(5);

        //creating  an Array list of multidimension
        ArrayList<ArrayList<Integer>> arrayList2 = new ArrayList<>(3);

//        arrayList1.add(1);--> this addition works if you are adding an integer type  value because integer is what it is expecting
        arrayList1.add(2); //the values we add must be of the same type specified while declaration
        arrayList1.add(3);
        arrayList1.add(4);
        arrayList1.add(5);

//4 rows , therefore size of array  = 4
        for (int k = 0; k < 4; k++) {
            arrayList2.add(new ArrayList<>());
        }

        //inputting elements into the 1-D array list
        //use 1. loop, 2. add(), 3. instead of specifying a value, just replace it with the scanner object 'input.nextInt()'
        for (int i = 0; i< arrayList1.size(); i++){
            arrayList1.add(sc.nextInt());
        }
        // since we cannot add the elements into the 'new ArrayList<>()' we first retrieve it and then add values
        System.out.println(" 1. first row : " + arrayList2.get(0));

        arrayList2.add(0, arrayList1);//--> this is one of the methods  for inputting or adding values
        //directly add an array by specifying the index
//        arrayList2.set(0, arrayList1);

        //-->2. get the index and add something to it
        System.out.println("2." + arrayList2.get(0));
        System.out.println("3." + arrayList2.get(0).size());

        ArrayList<Integer> element = new ArrayList<>();
        System.out.println();
        //automating the above process
        for(int i = 0 ; i < arrayList2.size() ; i++) {
            for (int j = 0; j < arrayList2.get(i).size(); j++) {

                element = arrayList2.get(i);
                arrayList2.add(element);
                System.out.println(element + " element at: " + i +" " + j);

            }
//            System.out.println(element + " element at: " + i +" " + j);
        }
//        System.out.println(element + " element at:");
        System.out.println(arrayList1);
        System.out.println(arrayList2);
    }
}
