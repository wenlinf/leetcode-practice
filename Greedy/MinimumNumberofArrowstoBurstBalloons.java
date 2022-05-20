class Solution {
    public int findMinArrowShots(int[][] points) {
        // Arrays.sort(points, (a, b) -> a[1] - b[1]); can't use. Overflow
        Arrays.sort(points, (a, b) -> {
            if (a[1] > b[1]) return 1;
            if (a[1] == b[1]) return 0;
            return -1;
        });
        int result = 1;
        int leastStart = points[0][0];
        int leastEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > leastEnd){
                result++;
                leastStart = points[i][0];
                leastEnd = points[i][1];
            }
        }
        return result;
    }
}
