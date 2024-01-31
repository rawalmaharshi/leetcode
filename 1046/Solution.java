class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        //add all stones to maxPQ 
        for (int stone : stones) {
            maxPQ.offer(stone);
        }
        
        while (maxPQ.size() >= 2) {
            int stone1 = maxPQ.poll();
            int stone2 = maxPQ.poll();
            int resultingStone = stone1 - stone2;
            if (resultingStone > 0) {
                maxPQ.offer(resultingStone);
            }
        }
        
        return maxPQ.isEmpty() ? 0 : maxPQ.poll();
    }
}