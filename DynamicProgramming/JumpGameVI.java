class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{0, nums[0]});
        for (int i = 1; i < n; i++) {
            int[] top;
            while (pq.peek()[0] < i - k) {
                top = pq.poll();
            }
            top = pq.peek();
            dp[i] = top[1] + nums[i];
            pq.offer(new int[]{i, dp[i]});
        }
        return dp[n - 1];
    }
}
