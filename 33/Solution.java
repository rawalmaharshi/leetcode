class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[right]) {
                //array is stil shifted at this point
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        int start = left;
        left = 0;
        right = nums.length - 1;
        
        if (nums[start] <= target && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }
        
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        
        return -1;  //if element not found
    }
}