class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/ 2;

            //Mid is target
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                //Subarray on mid's left is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //Subarray on mid's right is sorted
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }   
        }

        return -1;
    }
}