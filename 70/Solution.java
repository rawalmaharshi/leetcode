class Solution {
    public int climbStairs(int n) {
        //Actually fibonacci number question
        //edge case
        if (n <= 2) {
            return n;
        }
        // return memo(n);
        return dp(n);
    }
    
    public int dp(int n) {
        int[] dp = new int[n + 1];
        //base cases
        dp[1] = 1; dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    public int memo(int n) {
        int[] stairs = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i == 1 || i == 2) {
                stairs[i] = i;
            } else {
                stairs[i] = -1;
            }
        }
        
        return memoizationHelper(n, stairs);
    }
    
    public int memoizationHelper(int n, int[] stairs) {
        //base case
        if (n <= 2) {
            stairs[n] = n;
            return n;
        }
        
        if (stairs[n] == -1) {
            memoizationHelper(n - 1, stairs);
        }
        
        stairs[n] = stairs[n - 1] + stairs[n - 2];
        
        return stairs[n];
    }
}