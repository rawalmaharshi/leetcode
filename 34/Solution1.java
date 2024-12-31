/**
 * This solution does the same thing that Solution2 from the other file does.
 * If that code makes sense, use it. 
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        //edge case
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }

        int first = findFirstIndex(nums, target);
        int last = findLastIndex(nums, target);

        return new int[] {first, last};
    }

    private int findFirstIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2 ;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (left < nums.length && nums[left] == target) ? left : -1;
    }

    private int findLastIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2 ;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (right >= 0 && nums[right] == target) ? right : -1;
    }
}