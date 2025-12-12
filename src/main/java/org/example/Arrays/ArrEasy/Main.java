package org.example.Arrays.ArrEasy;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("Enter Salary: ");
        int salary = input.nextInt();
        if (salary >= 10000) {

            salary = salary + 2000;

        } else {

            salary = salary + 1000;
        }

        System.out.println(salary);
    }

}