class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> answer = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            pq.add(interval);
        }
        int[] currInterval = pq.poll();
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            if (next[0] <= currInterval[1]) {
                currInterval[1] = currInterval[1] > next[1] ? currInterval[1] : next[1];
            } else {
                answer.add(currInterval);
                currInterval = next;
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