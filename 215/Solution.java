class Solution {
    public int findKthLargest(int[] nums, int k) {
        // return usingSort(nums, k);
        return usingPQ(nums, k);
    }
    
    public int usingPQ (int[] nums, int k) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            minPQ.offer(num);
            if (minPQ.size() > k) {
                minPQ.poll();
            }
        }
        
        return minPQ.peek();
    }
    
    public int usingSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}