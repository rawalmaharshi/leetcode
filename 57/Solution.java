class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /*Algo:
            1. Add all the intervals to minPQ
            2. Merge Intervals
        */
        PriorityQueue<int[]> minPQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            minPQ.offer(interval);
        }
        minPQ.offer(newInterval);
        return mergeIntervals(minPQ);
    }
    
    public int[][] mergeIntervals(PriorityQueue<int[]> pq) {
        List<int[]> answer = new ArrayList<>();
        int[] currInterval = pq.poll();
        while (!pq.isEmpty()) {
            int[] nextInterval = pq.poll();
            if (currInterval[1] >= nextInterval[0]) {
                currInterval[1] = currInterval[1] > nextInterval[1] ? currInterval[1] : nextInterval[1];
            } else {
                answer.add(currInterval);
                currInterval = nextInterval;
            }
        }
        answer.add(currInterval);
        
        int[][] ans = new int[answer.size()][];
        int ansIndex = 0;
        for (int[] interval : answer) {
            ans[ansIndex++] = interval;
        }
        return ans;
    }
}