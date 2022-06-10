class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n == 1) return 1;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        
        pq.add(intervals[0]);
        int result = 1;
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            if (pq.size() != 0) {
                int[] top = pq.peek();
                if (top[1] <= interval[0]) {
                    pq.poll();
                    pq.add(interval);
                } else {
                    result++;
                    pq.add(interval);
                }
            }
        }
        return result;
    }
}
