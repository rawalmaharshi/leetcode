class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word: words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> countMap.get(a).equals(countMap.get(b)) ? b.compareTo(a) : countMap.get(a) - countMap.get(b));
        
        for (String word : countMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        List<String> answer = new ArrayList<>();
        while (!pq.isEmpty()) {
            answer.add(pq.poll());
        }
        
        Collections.reverse(answer);
        return answer;
    }
}