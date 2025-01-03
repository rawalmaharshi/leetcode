class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2 ;
            if (mid != 0 && nums[mid] < nums[mid - 1]) {
                right = mid - 1;    //search left (think of a falling slope)
            } else if (mid != nums.length - 1 && nums[mid] < nums[mid + 1]) {
                left = mid + 1;     //search right (think of a rising slope)
            } else {
                return mid;
            }
        }

        return -1;
    }
}

/**
 * Algorithm - Binary Search
 * 1. If nums[mid] < nums[mid - 1], then peak element must be in the left half.
 * 2. Else if nums[mid] < nums[mid + 1], then peak element must be in the right half.
 * 3. Else, nums[mid] is the peak element.
 * T: O(logn)
 * S: O(1)
 */