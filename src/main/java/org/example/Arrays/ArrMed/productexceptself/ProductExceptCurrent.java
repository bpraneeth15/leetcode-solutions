package org.example.Arrays.ArrMed.productexceptself;

import java.util.Arrays;

public class ProductExceptCurrent {

    public static void main(String[] args){

        int[] nums = {1,2,3,4};
        int[] zeroNums = {-1, 1, 0,-3, 3};

        System.out.println(Arrays.toString(productArray(zeroNums)));

    }
    public static int[] productArray(int[] nums){

        int[] answer = new int[nums.length];
        int runningProduct = 1;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        // iterate through the array from left to right{1,2,3,4}
        for(int i = 0; i < nums.length ; i++){
            //left to right
            if(i == 0){
                left[i] = 1;
            }
            else{
                left[i] = left[i-1] * nums[i-1];
            }
        }

        for(int i = nums.length - 1; i >= 0; i--){
            //right to left calculate the running product
            if(i == nums.length -1 ){
                right[i] = 1;
            }else{
                right[i] = right[i+1] * nums[i+1];
            }
        }

        for(int i = 0; i < nums.length; i++){
            //multiply corresponding values
            answer[i] = left[i] * right[i];
        }

        return answer;
    }
}
            /*input =   [1,2,3,4]
            *answer =   [(2*3*4), (1)*(3*4), (1*2)*(4), (1*2*3)] = [24, 12, 8, 6] -- if we follow this approach directly we would get O(n^2) solution
            *answer arr is --> [1*(R) ,  (L)* (R),  (L) *(R),   (L)*1 ]* -
            *     fig 1 -----> [0*(R) ,  (L)* (R),  (L) *(R),   (L)*0 ]
            *  product of left and right side of the current position/self
             we can see that we are performing some redundant calculations.therefore, we need to optimize by not doing redundant calculations
            *for instance in the above example, we can we that we are multiplying elements from the start to end
            *for each and every element(for '1' 2*3*4, '2' 1*3*4 etc, we are calculating 3*4 for the second time(or more))
            *instead of doing that since it is the product of left and the right part of the current position, we can use 2 arrays to store the
            * left part and right part respectively,
            * ----like left[] = {(1) , 1, 1*2, 1*2*3}, right= {2*3*4, 3*4, 4, (1)} and multiply the corresponding result
            * gives us the exact elements that are need to be multiplied at that position,
            * dry run: At i =0,  L(0) * R(0)=> 1 * 2*3*4 = 24; i =1, L(1)*R(1) => 1 * 3*4= 12....At i = 3, L(3)*R(3) => 1*2*3 * 1 = 6;
            * we can see that we are generating an answer array of expected output {24, 12, 8, 6}
            *Very Imp point on why division doesnt work:
            * -----Not considering 0 while multiplying and dividing with 0 inorder to remove its effect on the product
            * is not the same, because if we Not consider, the product doesnt become 0
            * but if we consider and then try to remove it by dividing then we miss the value as it becomes 0
            * *-----why i chose 1 in the empty cells?, because if i chose 0 or any other number other than 1 the product would change
            * --if there are no values to the left that means, the product is entirely dependent on the elements present on the right and vice versa
            * therefore inorder for the product that was acquired from the right side to remain the same we use '1', because product of something with '1'
            * gives you that same something
            *
            * ex 2: {-1, 1, 0,-3, 3} =
            * if we use dividing the ech current element from the total product of all the elements , does not work
            * because the idea here to print the array, it might work in the above example but not here in this one as 0s are present
            * Our approach:
            * left[] = {(1) , -1, , -1*1, -1*1*0, -1*1*0*-3}, right= {1*0*-3*3, 0*-3*3, -3*3, 3, (1)}
            * in the above line inorder to explain in detail i have included the breakdown of each element in each cell, going by the above simulation again,
            * leads to O(n^2)
            * we have to some how use the product of before elements inorder to calculate the product for the current position
            * in the left[] we can observe that each and every product that's coming(from left to right) is
            * dependent on the immediate last element that
            * we got
            * but in the right[] we can observe that it is not the same, the current position's product is
            * dependent on the immediate right element that is
            * there
            *
            *Lef[] = {1, -1, -1, 0, 0}, right[] = {0, 0, -9, 3, 1}
            * answer[] = {0, 0, 9, 0, 0}--> we get the expected output, here the effect of 0 is not carried to all the positions
            * the effect is only carried to the cells that dont have 0 in it the effect of 0 is contained.
            *
            *Steps:
            * 1.Iterate through the array input
            * 2.At each iteration
            * we traverse from left to right and right to left
            * and within each traversal we check if we are within the range of the indexes of the array,
            * because we are dealing with the elements to the
            * left and right of the current element, it helps when we are at start and end positions
            *
            * 3.Inorder to calculate running product as we go from left to right in the array, we can use the before element's value
            * but, if we want to calculate running product of the elements to the right side, we should consider coming from right to left
            * because if the goal is to calculate running product of elements on right side, we must make sure that we have total product of the elements on
            * the right side, we cant get this by traversing in the same direction in O(n) complexity,
            * so  value that has
            * if we get the  running product from left side for the
            * 2. Calculate the running product of the left side of the elements of the current element from the left
            * 3. Calculate the running product of the elements on the right side of the current element from the right
            * 4. Multiply corresponding elements/ tie them together for acquiring the product of array except self array
            *
             *  /
             */
