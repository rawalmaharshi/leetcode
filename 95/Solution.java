class Solution {
    public int numTrees(int n) {
        // return usingDP(n);
        return usingCatalan(n);
    }

    //See explanation for arriving to the recurrence relation
    private int usingDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <=i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    //You can look for explanation
    private int usingCatalan(int n) {
        //long to prevent overflow
        long c = 1;
        for (int i = 0; i < n; i++) {
            c = c * 2 * (2 * i + 1) / (i + 2);
        }

        return (int) c;
    }
}