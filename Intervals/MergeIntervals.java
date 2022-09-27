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

// this solution didn't really take advantage of the list that I'm creating. Time complexity is O(n) because we are only traversing the array once. Space complexity is also O(n) because of the list we 're creating
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        if (n == 1) return intervals;
        
        List<int[]> tempList = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= prev[1]) {
                int[] merge = new int[]{prev[0], Math.max(interval[1], prev[1])};
                prev = merge;
            } else {
                tempList.add(prev);
                prev = interval;
            }
            if (i == n - 1) {
                tempList.add(prev);
            }
        }
        int size = tempList.size();
        int[][] result = new int[size][2];
        for (int i = 0; i < size; i++) {
            result[i] = tempList.get(i);
        }
        return result;
    }
}
