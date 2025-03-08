package org.example.Binaryy;
//https://leetcode.com/problems/find-in-mountain-array/
public class MountainArrayMinValIndex {
    public static void main(String[] args) {

        int[] Arr = {1,2,3,4,5,3,1};
        int result = findInMountainArray(4, Arr);
        System.out.println(result);
    }
    public static int findInMountainArray(int target, int[] mountainArr) {
        int peak = findPeakElement(mountainArr);
        int tryAscArr = orderAgnosticbinarySearch(mountainArr, target, 0, peak);//searching in the ascending orders
        int tryDescArr = 0;
        if(tryAscArr != -1){
            //if tryAscArr is not equals -1 then it means target is  found therefore i return it
            return tryAscArr;
        }//if equals then i run bs on the descending array and then return the answer, it returns -1 if no target is found, therefore no need to mention the returning of -1
        else{
            tryDescArr = orderAgnosticbinarySearch(mountainArr, target, peak, mountainArr.length-1);
            return tryDescArr;
        }
    }

    public static int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length -1;

//using start <= end --> result in calculating mid even when the start = end , which make the arr[mid+1] throw
//IndexOutOfBound exception.
        while(start < end){

            int mid = (start + end) / 2 ;

            if(nums[mid] < nums[mid+1]){
                //we are in increasing slope and this comfirms that val at mid is not the greatest, and
                //value at mid+ 1 might be a potential peak therefore we update start to mid + 1.
                //search right by updating start

                start = mid + 1;
            }
            else {//if that is not the case then, arr[mid] > arr[mid+1]-> means arr[mid] is a potential peak/greater value
                //therefore, we shrink the search space keeping mid in the consideration or within the range.
                //therefore, we dont update end to skip mid (end = mid -1 X avoided)
                //consider searching left
                end = mid ;
            }
        }
        return start;

    }

//order agnostic binary search--> we start loop at (start <= end)and if A[start]< A[end] it means that the array is sorted in ascending order
//therefore-> if mid value is lesser than the target value, search right side of the array, by updating start = mid + 1,
// else(mid value greater than target val) then search left side of the array by updating end = mid -1 and continue the search
    //if A[start] > A[end] at start < end then we look opposite -> if A[mid] < target then continue searching right side
    public static int orderAgnosticbinarySearch(int[] arr, int target, int start, int end){

        boolean isAscending = arr[start] < arr[end];
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == target){
                return mid;
            }
            if (isAscending){
                if(arr[mid] < target){

                    //search on the right side
                    start = mid + 1;
                }
                else{
                    //search on the left side
                    end = end - 1;
                }
            }
            else{
                if(arr[mid] < target){
                    //if the array is in descending order then search left for above condition
                    end = mid - 1;
                }
                else{
                    //else search right
                    start = mid + 1;
                }
            }
        }
        return -1;//return -1 if none is returned above
    }
}
