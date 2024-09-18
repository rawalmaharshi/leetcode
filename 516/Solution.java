class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // return usingMemo(s, 0, n - 1, new int[n][n]);
        return usingDP(s, new int[n][n]);
    }

    private int usingDP(String s, int[][] dp) {
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }

    private int usingMemo(String s, int i, int j, int[][] memo) {
        //base case(s)
        if (i > j) {
            return 0;
        }

        if (i == j) {
            return 1;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = usingMemo(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(usingMemo(s, i + 1, j, memo), usingMemo(s, i, j - 1, memo));
        }

        return memo[i][j];
    }
}

/**
 Alogrithm - 
 1. Start form beginning and end 
 2. If the characters are same, they are part of longest palindromic subsequence - add 2, continue to find subsequence
 3. If they are different, then either of them are part of subsequence
 4. Gives us the relation
    a. if s[i] == s[j], answer = 2 + LPS(i + 1, j - 1)
    b. if s[i] != s[j], answer = max(LPS(i + 1, j), LPS(i, j - 1))
 */