class Solution {
    public int oddEvenJumps(int[] arr) {
        // 0 - odd. 1 - even
        int n = arr.length;
        boolean[][] dp = new boolean[2][n];
        dp[0][n - 1] = true;
        dp[1][n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        int res = 1;
        for (int i = n - 2; i >= 0; i--) {
            int num = arr[i];
            Map.Entry<Integer, Integer> ceiling = map.ceilingEntry(num);
            Map.Entry<Integer, Integer> floor = map.floorEntry(num);
            if (ceiling != null) {
                dp[0][i] = dp[1][ceiling.getValue()];
            }
            if (floor != null) {
                dp[1][i] = dp[0][floor.getValue()];
            }
            if (dp[0][i]) res++;
            map.put(arr[i], i);
        }
        return res;
    }
}
