class Solution {
    public int fib(int n) {
        //edge case
        if (n < 2) {
            return n;
        }
        int[] fibs = new int[n + 1];
        fibs[0] = 0;
        fibs[1] = 1;
        for (int i = 2; i < n; i++) {
            fibs[i] = -1;
        }
        return memoizationHelper(n, fibs);
    }
    
    public int memoizationHelper(int n, int[] fibs) {
        //base case
        if (n == 2) {
            fibs[n] = fibs[0] + fibs[1];
            return fibs[n];
        }
        
        if (fibs[n - 1] == -1 || fibs[n - 2] == -1) {
            fibs[n] = memoizationHelper(n - 1, fibs);
        }
        
        fibs[n] = fibs[n - 1] + fibs[n - 2];
        
        return fibs[n];
    }
}