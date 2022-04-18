class Solution {
    public int search(int[] nums, int target) {
        /*Algo: 1st find the smallestElement index
        determine where to search in the array with respect to smallest index
        run another binary search to search there
        */
        
        int start = 0, end = nums.length - 1;
        int smallestIndex = 0;
        
        while (start < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        smallestIndex = start;  //after end of 1st binary search start = end
        
        // Reset start and end variables to determine which part of array to search 
        //Use example of 5 and 1 in array [4,5,6,7,0,1,2] to understand why we have set the variables like this
        start = 0;
        end = nums.length - 1;
        if (nums[smallestIndex] <= target && target <= nums[end]) {
            start = smallestIndex;
        } else {
            end = smallestIndex;
        }
        
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } 
        
        return -1;  //not found
    }
}