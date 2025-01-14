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
    
    //Binary Search - O(logn)
    public int pickIndex() {
        double target = this.totalSum * Math.random();
        
        int left = 0, right = this.prefixSums.length;
        while (left < right) {
            int mid = left + (right - left)/2 ;
            if (target > this.prefixSums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */