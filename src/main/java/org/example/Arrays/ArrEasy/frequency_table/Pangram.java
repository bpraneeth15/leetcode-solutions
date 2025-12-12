package org.example.Arrays.ArrEasy.frequency_table;

public class Pangram {

    //in this problem we find whether a give string is a pangram or not
    //pangram: A string or sentence that contains all the 26 english alphabets

    public static void main( String[] args){

       String sentence = "leetcode";

        System.out.println(checkIfPangram(sentence));


    }

    public static boolean checkIfPangram(String sentence) {

        boolean isPanagram = true;

        //for every string we have to check if all the 26 alphabets are present
        //for this we can mark whatever alphabet that we come across as present
        //since there are 26 alphabets , I can use a frequency table, but
        //here we dont need to keep the count of each alphabet but, we just need
        //to mark it present
        //creating a frequency array of size 26 from 0 to 25
        int[] alphabets = new int[26];
        int index = 0;
        //now as we iterate the string, we will come across the alphabets randomly
        //in any order. so as they come we jjust mark their presence in the corresponding
        //indexes by changing or marking the value at that inndex to 1 from 0

        for(int i = 0; i < sentence.length(); i++){

            //take each character
            index = sentence.charAt(i) - 'a';
            alphabets[index] = 1;
        }

        for(int i = 0 ; i < alphabets.length; i++){

            if(alphabets[i] == 0){
                isPanagram = false;
                break;
            }
        }

        return isPanagram;
    }
}
