class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // return usingMinPQ(k, countMap);
        return usingMaxPQ(k, countMap);
    }
    
    public int[] usingMinPQ(int k, Map<Integer, Integer> countMap) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>((a, b) -> countMap.get(a) - countMap.get(b));
        for (int num : countMap.keySet()) {
            minPQ.offer(num);
            if (minPQ.size() > k) {
                minPQ.poll();
            }
        }
        
        int[] answer = new int[k];
        int ansIndex = 0;
        while (!minPQ.isEmpty()) {
            answer[ansIndex++] = minPQ.poll();
        }
        
        return answer;
    }
    
    public int[] usingMaxPQ(int k, Map<Integer, Integer> countMap) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> countMap.get(b) - countMap.get(a));
        for (int num : countMap.keySet()) {
            maxPQ.offer(num);
        }
        
        int[] answer = new int[k];
        int ansIndex = 0;
        while (k-- > 0) {
            answer[ansIndex++] = maxPQ.poll();
        }
        
        return answer;
    }
}