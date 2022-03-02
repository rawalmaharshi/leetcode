class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || nums == null) {
            return new int[] {};
        }
        
        //edge case
        if (nums.length == k) {
            return nums;
        }
        
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> countMap.get(a) - countMap.get(b));
        for (int key : countMap.keySet()) {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] ans = new int[k];
        int ansIndex = 0;
        while (!pq.isEmpty()) {
            ans[ansIndex++] = pq.poll();
        }
        
        return ans;
    }
}