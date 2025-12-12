package org.example.Arrays.ArrEasy;

import java.util.Arrays;

public class Arrays1 {
    public static void main(String[] args) {

        int[] arr3 = {1, 2, 3, 4, 5};

//        changeArray(arr3);
//        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.stream(arr3).max());

    }
}


//    static void changeArray(int[] arr) {
//
//         arr[0] = 99;
//    }
//}
