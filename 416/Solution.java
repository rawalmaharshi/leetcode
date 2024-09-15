class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        //Total sum has to be even for it to be divided into subsets of two having same sum
        if (totalSum % 2 != 0) {
            return false;
        }

        int subsetSum = totalSum / 2;
        int n = nums.length;
        // return dfs(nums, 0, subsetSum);
        // return dfsMemo(nums, 0, subsetSum, new Boolean[n + 1][subsetSum + 1]);
        return dp(nums, subsetSum, new boolean[nums.length + 1][subsetSum + 1]);
    }

    //T: O(m*n), S: O(m*n)
    private boolean dfsMemo(int[] nums, int i, int subsetSum, Boolean[][] memo) {
        //base case
        if (subsetSum == 0) {
            return true;
        }

        if (i == nums.length || subsetSum < 0) {
            return false;
        }

        //check from memo
        if (memo[i][subsetSum] != null) {
            return memo[i][subsetSum];
        }

        memo[i][subsetSum] = dfsMemo(nums, i + 1, subsetSum - nums[i], memo) || dfsMemo(nums, i + 1, subsetSum, memo);

        return memo[i][subsetSum];
    } 

    //T: O(2^n), S: O(n)
    private boolean dfs(int[] nums, int i, int subsetSum) {
        //base cases
        if (subsetSum == 0) {
            return true;
        }

        if (i == nums.length || subsetSum < 0) {
            return false;
        }

        return dfs(nums, i + 1, subsetSum - nums[i]) || dfs(nums, i + 1, subsetSum);
    }

    //T: O(m*n), S: O(m*n)
    private boolean dp(int[] nums, int subsetSum, boolean[][] dp) {
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= subsetSum; j++) {
                if (j < curr) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - curr];
                }
            }
        }

        return dp[nums.length][subsetSum];
    }
}