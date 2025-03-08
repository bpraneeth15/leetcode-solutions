package org.example.Binaryy;

public class RotatedArrMed2 {

    public static void main(String[] args) {

        int[] nums = {1,0,1,1,1};
        int target = 0;

        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {

        int start = 0;
        int end = nums.length -1;
            if(start == end) {//if only single value

                return binarySearch(nums, start, end, target);
            }

            int pivotIndex = findPivot(nums);

            if(nums[start] <= target){
                //search in left array by performing binary search on left side
                return binarySearch(nums, start, pivotIndex, target);
            }
            else{//if nums[start] > target then search right by performing BS on right part of the array after pivotIndex

                return binarySearch(nums, pivotIndex + 1, end, target);

            }
        }

        public static int findPivot(int[] nums){

            //we dont need the target here
            int start = 0;
            int end  = nums.length -1;

            while(start <= end){
                //
                int mid = start + (end - start)/2;
                if(nums[mid] > nums[mid+1] && mid <= end)//which in a sorted array is not possible unless mid is a pivot
                {//mid < end this check was already thought but was mentioned later
                    return mid;//mid as pivot
                }
                else{
                    if(nums[start] > nums[mid]){

                        //search left
                        end = mid -1;
                    }
                    else{//nums[start] < nums[mid]

                        //search right
                        start = mid + 1;
                    }
                }
            }
            return -1;
        }

        public static boolean binarySearch(int[] nums, int start, int end, int target){

            while(start <= end){

                int mid = start + (end - start) / 2;

                if(nums[mid] == target){

                    return true;//targeet is found
                }
                else if( nums[mid] < target){
                    //search right
                    start = mid+1;
                }
                else{
                    end = mid - 1;
                }
            }
            return false; // target not found.
        }
    }
