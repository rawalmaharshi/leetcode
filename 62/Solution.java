class Solution {
    public int uniquePaths(int m, int n) {
        // return usingMemo(m, n);
        return usingDP(m, n);
    }
    
    public int usingDP(int m, int n) {
        int[][] dp = new int[m][n];
        //set column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        
        //set row
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    public int usingMemo(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1; 
            }
        }
        
        return memoHelper(memo, m - 1, n - 1);
    }
    
    public int memoHelper(int[][] memo, int i, int j) {
        //base case
        if (i == 0 || j == 0) {
            return 1;
        }
        
        if (memo[i][j] == -1) {
            memo[i][j] = memoHelper(memo, i - 1, j) + memoHelper(memo, i, j - 1);
        }
        
        return memo[i][j];
    }
}