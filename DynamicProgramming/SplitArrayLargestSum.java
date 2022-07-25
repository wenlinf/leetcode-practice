class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[m + 1][n + 1];
        
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        
        for (int i = 1; i <= n; i++) {
            dp[1][i] = prefix[i];
        }
        for (int i = 2; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }
        
        
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], 
                                        Math.max(dp[i - 1][k], 
                                                 prefix[j] - prefix[k]));
                }
            }
        }
        return dp[m][n];
    }
}
