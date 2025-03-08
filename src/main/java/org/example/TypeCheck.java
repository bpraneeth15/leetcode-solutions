package org.example;

import java.util.Scanner;

public class TypeCheck {
    public static void main(String[] args) {
        //check if the first letter oif a word is upper case or lower
        //input a string and extract a character
        Scanner input = new Scanner(System.in);
        //String str = input.nextLine().trim();//ignores the spaces before and after the string not in between
        String str = input.next().trim();
        char ch = str.charAt(0);

        if (ch >= 'a' && ch <= 'z') {
            System.out.println("lower case :" + ch);//compare this using if condition
        }
        else if (ch >= 'A' && ch <= 'Z') {

            System.out.println("Upper case :" + ch);
        }

        else{
            System.out.println("Invalid character");
        }
    }
}
