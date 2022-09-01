class Solution {
    public int maxSubArray(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
        // return optimizedDP(nums);
    }
    
    public int optimizedDP(int[] nums) {
        int maxSum = nums[0], currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }
    
    //Unintuitive approach - just for reference
    public int divideAndConquer(int[] nums, int left, int right) {
        //base case
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        
        int mid = left + (right - left)/2;
        
        int sum = 0, leftBestSum = 0, rightBestSum = 0;
        for (int i = mid - 1; i >= left; i--) {
            sum += nums[i];
            leftBestSum = Math.max(leftBestSum, sum);
        }
        
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightBestSum = Math.max(rightBestSum, sum);
        }
        
        int combinedSum = leftBestSum + nums[mid] + rightBestSum;
        
        int leftSum = divideAndConquer(nums, left, mid - 1);
        int rightSum = divideAndConquer(nums, mid + 1, right);
        
        return Math.max(combinedSum, Math.max(leftSum, rightSum));
    }
}