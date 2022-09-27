class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] - b[0] != 0) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        list.add(intervals[0]);
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            int[] prev = list.getLast();
            int[] curr = intervals[i];
            if (curr[0] == prev[0]) {
                prev[1] = curr[1];
            } else if (curr[1] > prev[1]) {
                list.add(curr);
            }
        }
        return list.size();
    }
}
