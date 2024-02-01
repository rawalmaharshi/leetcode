class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int soldierCount = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                soldierCount++;
            }
            countMap.put(i, soldierCount);   //Index -> Soldier Count Mapping
        }
        
        //Store k weakest rows in maxPQ (head is strongest - need to reverse order in answer)
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> countMap.get(a) == countMap.get(b) ? b - a : countMap.get(b) - countMap.get(a));
        for (int index : countMap.keySet()) {
            maxPQ.offer(index);
            if (maxPQ.size() > k) {
                maxPQ.poll();
            }
        }
        
        int[] answer = new int[k];
        while (--k >= 0) {
            answer[k] = maxPQ.poll();
        }
        
        return answer;
    }
}