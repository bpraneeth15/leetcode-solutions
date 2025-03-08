package org.example.Binaryy;

class Solution {

    public static void main(String[] args) {

        int[] nums = {2,3,1,2,4,3};
        int[] nums2 = {7,2,5,10,8};
        int k2 = 2;
        int k = 5;
        System.out.println(splitArray(nums2, k2));

    }
    public static int splitArray(int[] nums, int k) {

        int start = 0;
        int end = 0 ;
        int ans = -1;
        int sumOfArrElements = 0;
        //find sum of all the elements because that is the max poossible answer that is minimum when the partition is 1,
        //since the min no of partitions that we can make on any array is 1
        for(int i = 0; i < nums.length; i++){

            //run a loop to find out the sum of all the elements in given array, to find the upper limit
            sumOfArrElements+= nums[i];
        }
        end = sumOfArrElements;

        if(k == nums.length){
            int maxValueArr = 0;
            for(int i = 0; i < nums.length; i++){
                if(maxValueArr < nums[i]){
                    //find the greatest and return it
                    maxValueArr = nums[i];
                }
            }
            return maxValueArr;
        }

        if(k == 1){
            return sumOfArrElements;
        }

        if(nums.length == 0){
            return ans;
        }
        //run binary search now from start to N
        while(start <= end){

            //find mid in the range
            //and see if this mid is valid or not and then i will decide which side to shrink and which side to move
            int mid = start+(end - start) / 2;

            //after we get mid, check if the mid is valid(follows the conditions we have) or not

            if(isValid(nums, mid, k, start, end)){//check if this maximumSum is valid, if valid we store it and continue to search if there are any other minimum possible max sum on the left
                //if valid then update the answer and then we move left, shrink the space on right and move left
                ans = mid;//if valid then we update ans to that mid and continue search on the left. which means to increase no of partitions
                end = mid - 1;
            }
            else{
                //if not valid then it means we need to increase the partitions capacity
                start = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isValid(int[] nums, int allowedMax, int m, int start, int end){

        //before checking if a mid is valid or not check if the mid is falling within the range of the N
        if(allowedMax < start && allowedMax > end){
            return false;
        }



        int maxSum = 0;
        int noOfPartitions = 1;//no of partitions is 1 initially before increasing


        //i will iterate through the array nums[] and ofr each nums value i will start adding the value nums[i] and check if its addition is not exceeding the allowedMax, if it exceeds then i will increment noOfPartitions
        for(int i = 0; i < nums.length; i++){
            //in each iteration we try to add the values of nums[i] to maxSum to see if its exceeding the allowedMaxValue, if exceeds then i will increase the partition and insert values there
            if(allowedMax < nums[i]){
                return false;
            }
            if(maxSum + nums[i] <= allowedMax){
                //if it is below then add
                maxSum += nums[i];
            }
            else{
                //if above condition is not true then we increase the partitions and set maxSum of that partition to the next subsequent element nums[i]
                maxSum = nums[i];
                noOfPartitions++;
            }
        }//after running the loop before returning anything check if the no of partitions is exceeding if exceeds then return false
        if(noOfPartitions > m){
            return false;
        }
        return true;

    }
}
