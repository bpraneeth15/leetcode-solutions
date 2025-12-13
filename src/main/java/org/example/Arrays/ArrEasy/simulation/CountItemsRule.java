package org.example.Arrays.ArrEasy.simulation;

import java.util.ArrayList;
import java.util.List;

public class CountItemsRule {
    public static void main(String[] args) {

        List<List<String>> list= new ArrayList<>();

        list.add(new ArrayList<>(List.of("phone", "blue", "pixel")));
        list.add(new ArrayList<>(List.of("computer", "silver" , "lenovo")));
        list.add(new ArrayList<>(List.of("phone", "gold", "iphone")));

       String ruleKey = "color" ; String ruleColor = "silver";
        System.out.println(list);
        System.out.println(countMatches(list, "type", "phone"));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {


        //process the matrix from top to botto,m,
        //we have to decide which columns to touch for each entry/row depending on the 'ruleKey'

        int count = 0;
        for(int i = 0; i < items.size(); i++){

            //deviceType -> column 0
            //deviceColor -> col 1
            //deviceMa,e -> col 2

            if(ruleKey.equals("type") && ruleValue.equals(items.get(i).get(0))){
                //only check column 0
                count++;
            }

            if(ruleKey.equals("color") && ruleValue.equals(items.get(i).get(1))){
                //checking the ith row's 1st column
                count++;
            }

            if(ruleKey.equals("name") && ruleValue.equals(items.get(i).get(2))){
                //checking each rows 2nd column only
                count++;
            }
        }
        return count;
    }
}

//This is the O(n) solution ,--> we can further optimize this