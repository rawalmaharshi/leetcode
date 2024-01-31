class KthLargest {
    PriorityQueue<Integer> minPQ;
    int[] nums;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        this.minPQ = new PriorityQueue<>((a, b) -> a - b);
        for (int i : nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        minPQ.offer(val);
        if (minPQ.size() > this.k) {
            minPQ.poll();
        }
        return minPQ.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */