package org.example.Arrays.ArrMed;

import java.util.Arrays;

public class LaserBeams {

    public static void main(String[] args) {


        String[] bank = {"011001", "000000", "010100", "001000"};
        //identify and store the rows that contain 1 in it

        System.out.println(numberOfBeams(bank));
//        System.out.println();
    }

    public static int numberOfBeams(String[] bank) {


        int noOfDevices;
        int noOfDevicesPR = 0;
        int noOfBeams = 0;
        boolean[] validRows = new boolean[bank.length];
        char[][] charArray = new char[bank.length][];
        //store valid rows that contain 1
        for (int i = 0; i < bank.length; i++) {
            //runs loop times the bank array length
            charArray[i] = bank[i].toCharArray();//[[0, 1, 1, 0, 0, 1], [0, 0, 0, 0, 0, 0], [0, 1, 0, 1, 0, 0], [0, 0, 1, 0, 0, 0]]
            if (bank[i].contains("1")) {
                validRows[i] = true;
            }
        }

        /*Step 2: count no of security devices in each valid row and use that value to multiply with the no of security devices in the next valid row*/
        for (int i = 0; i < validRows.length; i++) {
            noOfDevices = 0;
            if (validRows[i] == true) {
                for (int j = 0; j < charArray[0].length; j++) {

                    //if row is valid only then increment/count no of devices in it
                    if(charArray[i][j] == '1'){
                        noOfDevices++;
                    }
                }

               //store the no of security devices in another variable to that we can use it to perform multiplication with the no of devices in the currnt row
                noOfBeams += noOfDevicesPR * noOfDevices;
                noOfDevicesPR = noOfDevices;
                //after counting each row, we calculate total no of beams after that
            }


        }
        return noOfBeams;
    }
}
/* Step 1: Initialize Variables
Create three integer variables:

noOfDevices → Stores the number of '1's in the current valid row.
noOfDevicesPR → Stores the number of '1's in the previous valid row.
noOfBeams → Stores the total laser beam count.
Create an array validRows[] of boolean values to mark which rows contain at least one '1'.

Convert the given String[] bank into a char matrix (charArray[][]) for easier character access.

🔹 Step 2: Identify Valid Rows
Iterate through each row bank[i]:
Convert the row into a character array (charArray[i]).
Check if the row contains '1' using bank[i].contains("1").
If '1' is found, mark the row as valid (validRows[i] = true).
🔹 Step 3: Count Devices and Calculate Beams
Iterate through each row (validRows[i]):
If the row is valid (true):
Reset noOfDevices = 0 for the current row.
Iterate through each character in the row (charArray[i][j]).
If the character is '1', increment noOfDevices.
Compute the beams using:
noOfBeams
+
=
noOfDevicesPR
×
noOfDevices
noOfBeams+=noOfDevicesPR×noOfDevices
Update noOfDevicesPR to store the current row’s device count.
🔹 Step 4: Return the Total Beam Count
After all valid rows have been processed, return noOfBeams, which contains the total laser beam count.
*/