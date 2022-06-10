class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int result = 0;
        int leastStart = intervals[0][0];
        int leastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < leastEnd) result++;
            else {
                leastEnd = intervals[i][1];
                leastStart = intervals[i][0];
            }
        }
        return result;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) return 0;
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int res = 1;
        int endTime = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            if (interval[0] >= endTime) {
                res++;
                endTime = interval[1];
            }
        }
        return n - res;
    }
}
