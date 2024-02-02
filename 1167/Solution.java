class Solution {
    public int connectSticks(int[] sticks) {    
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int stick : sticks) {
            minPQ.offer(stick);
        }
        
        int finalCost = 0;
        while (minPQ.size() > 1) {
            int stick1 = minPQ.poll();
            int stick2 = minPQ.poll();
            int cost = stick1 + stick2;
            minPQ.offer(cost);
            finalCost += cost;
        }
        
        return finalCost;
    }
}