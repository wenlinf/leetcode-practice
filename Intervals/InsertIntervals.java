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
