class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    private int[] cost;
    public int minCostClimbingStairs(int[] cost) {
        // return usingMemoization(cost, cost.length);
        return usingDP(cost);
    }
    
    public int usingDP(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0; dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }
        
        return dp[cost.length];
    }
    
    public int usingMemoization(int[] cost, int n) {
        this.cost = cost;
        return memoizationHelper(n);
    }
    
    public int memoizationHelper(int n) {
        //base cases
        if (n <= 1) return 0;
        
        if (!memo.containsKey(n)) {
            memo.put(n, Math.min(memoizationHelper(n - 1) + cost[n - 1], memoizationHelper(n - 2) + cost[n - 2]));
        }
        
        return memo.get(n);
    }
}