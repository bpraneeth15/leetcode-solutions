package org.example.Arrays.ArrEasy;

import java.util.ArrayList;
import java.util.Scanner;

public class OneDimArrList {

    public static void main(String[] args) {


        //declaring and creating
        Scanner scanner = new Scanner(System.in);
//        int in  = scanner.nextInt();
        ArrayList<Integer> arrayList1 = new ArrayList<>(10);

        //since we want to add input and exit it based on the element passed, we dont know how many elements we want to pass
        //while is better option
       // for(int i = 0; i< arrayList1.size(); i++){
        while(true){
            //hasNextInt check if the entered input is an integer or not
            if(scanner.hasNextInt()) {
                arrayList1.add(scanner.nextInt());
            }
            else{
                break;
            }
        }
        System.out.println(arrayList1);

    }

}
