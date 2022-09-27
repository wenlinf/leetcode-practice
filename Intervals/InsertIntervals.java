// This solution is purely based on Merge Intervals problem. Not optimal. 
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] temp = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            temp[i] = intervals[i];
        }
        temp[n] = newInterval;
        Arrays.sort(temp, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> list = new LinkedList<>();
        list.add(temp[0]);
        for (int i = 1; i <= n; i++) {
            int[] prev = list.getLast();
            int[] curr = temp[i];
            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(curr[1], prev[1]);
            } else {
                list.add(curr);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}

// a better solution Time complexity O(n) space O(n)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] interval : intervals) {
            int newStart = newInterval[0];
            int newEnd = newInterval[1];
            int currStart = interval[0];
            int currEnd = interval[1];
            if (newEnd < currStart) {
                list.add(newInterval);
                newInterval = interval;
            } else if (newStart > currEnd) {
                list.add(interval);
            } else {
                int[] temp = new int[]{Math.min(currStart, newStart), Math.max(currEnd, newEnd)};
                newInterval = temp;
            }
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
