class Solution {
    int[] prefixSums;
    int totalSum;

    public Solution(int[] w) {
        this.prefixSums = new int[w.length];

        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            this.prefixSums[i] = sum;
        }
        this.totalSum = sum;
    }
    
    //Linear Search - O(n)
    public int pickIndex() {
        double target = this.totalSum * Math.random();
        for (int i = 0; i < this.prefixSums.length; i++) {
            if (target < this.prefixSums[i]) {
                return i;
            }
        }

        return -1;   //never reaches here
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */