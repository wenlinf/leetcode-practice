class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        int[] result = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];
            int num = trip[0];
            int from = trip[1];
            int to = trip[2];
            diff[from] += num;
            if (to < 1000) {
                diff[to] -= num;
            }
        }
        if (diff[0] > capacity) return false;
        result[0] = diff[0];
        for (int i = 1; i < 1001; i++) {
            result[i] = result[i - 1] + diff[i];
            if (result[i] > capacity) return false;
        }
        return true;
    }
}
