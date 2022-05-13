class Solution {
    public int tribonacci(int n) {
        // return usingRecursion(n);
        // return usingMemoization(n);
        return usingDP(n);
    }
    
    public int usingDP(int n) {
        //edge cases
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        
        int[] dp = new int[n + 1];
        //base cases
        dp[0] = 0; dp[1] = 1; dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        return dp[n];
    }
    
    public int usingMemoization(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return usingMemo(n, memo);
    }
    
    public int usingMemo(int n, Map<Integer, Integer> memo) {
        //base cases
        if (n == 0) {
            return 0;
        }
        
        if (n == 1 || n == 2) {
            return 1;
        }
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            memo.put(n, usingMemo(n - 1, memo) + usingMemo(n - 2, memo) + usingMemo(n - 3, memo));
        }
        
        return memo.get(n);
    }
    
    //Would not work for n > 34
    public int usingRecursion(int n) {
        //base cases
        if (n == 0) {
            return 0;
        }
        
        if (n == 1 || n == 2) {
            return 1;
        }
        
        return usingRecursion(n - 1) + usingRecursion(n - 2) + usingRecursion(n - 3);
    }
}