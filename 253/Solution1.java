class Solution {
    public int minMeetingRooms(int[][] intervals) {
        /* Algorithm - 
        1. Sort the intervals based on start time so that we always go in order of meeting start times
        2. Create a minPQ based on end times of meetings
        3. If end time of PQ head is less than start time of new interval, that meeting is over -> remove from PQ, otherwise add to PQ
        */
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minPQ = new PriorityQueue<>((a, b) -> a[1] -  b[1]);
        for (int[] interval : intervals) {
            if (minPQ.isEmpty()) {
                minPQ.offer(interval);
            } else {
                int[] currMeetingInterval = minPQ.peek();
                if (currMeetingInterval[1] <= interval[0]) {
                    minPQ.poll();
                }
                minPQ.offer(interval);
            }
        }
        
        return minPQ.size();
    }
}