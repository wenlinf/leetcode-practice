class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {return a[0] - b[0];});

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = result.get(result.size()-1);
            if (curr[0] > prev[1]) {
                result.add(curr);
            } else {
                prev[1] = Math.max(curr[1], prev[1]);
            }
        }

        return result.toArray(new int[0][0]);
    }
}
