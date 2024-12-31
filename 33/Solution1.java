class Solution {
    public int search(int[] nums, int target) {
        //edge case
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/ 2;
            if (nums[mid] > nums[nums.length - 1]) {
                //pivot is on the right
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int pivotIndex = left;

        //search on the left side of pivot index;
        int answer = binarySearch(nums, target, 0, pivotIndex - 1);

        //if answer is -1, we need to search on the right side as well
        if (answer != -1) {
            return answer;
        }

        return binarySearch(nums, target, pivotIndex, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid; 
            } else if (nums[mid] > target) {
                //search on left
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        //element not found
        return -1;
    }
}