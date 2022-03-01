class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // return bruteForce(numbers, target);
        return twoPointers(numbers, target);
    }
    
    public int[] twoPointers(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                //we are on the positive side (decrease right - since array is sorted)
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return new int[] {left + 1, right + 1}; //1-indexed
            }
        }
        
        return new int[] {-1, -1};  //doesn't reach here
    }
    
    public int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i + 1, j + 1};
                }
            }
        }
        
        return new int[] {-1,-1};   //doesn't reach here
    }
}