class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) return -1;
        
        int n = jobDifficulty.length;
        
        int[][] dp = new int[n][d];  
        
        // dp[n - 1][0] = jobDifficulty[n - 1];
        // for (int i = n - 2; i >= 0; i--) {
        //     dp[i][0] = Math.max(jobDifficulty[i], dp[i + 1][0]);
        // }
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(jobDifficulty[i], dp[i - 1][0]);
        }
        
        for (int j = 1; j < d; ++j) {
            
            for (int i = j; i < n; ++i) { // it's not possible to have i smaller than j
                int hardest = jobDifficulty[i];
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = i; k >= j; --k) {
                    hardest = Math.max(hardest, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], dp[k - 1][j - 1] + hardest); 
                }
            
            }
        }
        return dp[n-1][d-1];
    }
}
