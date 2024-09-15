class Solution {
    public int[][] merge(int[][] intervals) {
        //edge case
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            pq.offer(interval);
        }

        List<int[]> ansList = new ArrayList<>();
        int[] currInterval = pq.poll();

        while (!pq.isEmpty()) {
            int[] nextInterval = pq.poll();
            if (currInterval[1] >= nextInterval[0]) {
                currInterval[1] = currInterval[1] > nextInterval[1] ? currInterval[1] : nextInterval[1];
            } else {
                ansList.add(currInterval);
                currInterval = nextInterval;
            }
        }
        //add final interval
        ansList.add(currInterval);

        //Make a 2-D array from List<int[]>
        int[][] answer = new int[ansList.size()][];
        return ansList.toArray(answer);
    }
}