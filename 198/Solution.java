class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    private int[] nums;
    public int rob(int[] nums) {
        // return usingMemoization(nums, nums.length - 1);
        return usingDP(nums);
    }
    
    public int usingDP(int[] nums) {
        int length = nums.length;
        //edge case
        if (length == 1) {
            return nums[0];
        }
        
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        return dp[length - 1];
    }
    
    public int usingMemoization(int[] nums, int n) {
        this.nums = nums;
        return memoHelper(n);
    }
    
    public int memoHelper(int n) {
        //base case(s)
        if (n == 0) {
            return nums[0];
        }
        
        //Can either rob from house at index 0 or 1; will rob whereever max money
        if (n == 1) {
            return Math.max(nums[0], nums[1]);
        }
    
        //Max of previous house or (current house + house at currentIndex - 2)
        if (!memo.containsKey(n)) {
            memo.put(n, Math.max(memoHelper(n - 1), memoHelper(n - 2) + nums[n]));
        }
        
        return memo.get(n);
    }
}