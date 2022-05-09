class Solution {
    public int climbStairs(int n) {
        //Actually fibonacci number question
        //edge case
        if (n <= 2) {
            return n;
        }
        
        int[] stairs = new int[n + 1];
        stairs[1] = 1;
        stairs[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            stairs[i] = -1;
        }
        
        return memoizationHelper(n, stairs);
    }
    
    public int memoizationHelper(int n, int[] stairs) {
        //base case
        if (n == 2) {
            return n;
        }
        
        if (stairs[n - 1] == -1 || stairs[n - 2] == -1) {
            memoizationHelper(n - 1, stairs);
        }
        
        stairs[n] = stairs[n - 1] + stairs[n - 2];
        
        return stairs[n];
    }
}