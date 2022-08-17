//bottom-up dp
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int sum = prefix[j + 1] - prefix[i];
                int pickFirst = sum - dp[i + 1][j];
                int pickLast = sum - dp[i][j - 1];
                dp[i][j] = Math.max(pickFirst, pickLast);
            }
        }
        int playerOne = dp[0][n - 1];
        int playerTwo = prefix[n] - prefix[0] - playerOne;
        return playerOne >= playerTwo;
    }
}

// Memoization, top-down
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        dp = new int[n][n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            sum += nums[i];
        }
        int playerOne = helper(0, n - 1);
        return playerOne >= (sum - playerOne);
    }
    
    private int[][] dp;
    private int[] nums;
    private int helper(int start, int end) {
        if (start > end) return 0;
        if (start == end) {
            dp[start][end] = nums[start];
            return dp[start][end];
        }
        if (dp[start][end] != -1) return dp[start][end];
        int pickStart = nums[start] + Math.min(helper(start + 2, end), helper(start + 1, end - 1));
        int pickLast = nums[end] + Math.min(helper(start, end - 2), helper(start + 1, end - 1));
        int result = Math.max(pickStart, pickLast);
        dp[start][end] = result;
        return result;
    }
}
