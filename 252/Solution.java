class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        //edge case
        if (intervals.length <= 1) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prevInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (prevInterval[1] > currInterval[0]) {
                return false;
            }
            prevInterval = currInterval;
        }

        return true;
    }
}