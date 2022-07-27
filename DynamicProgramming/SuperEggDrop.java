// bottom-up dp, Time limit exceeded
class Solution {
    public int superEggDrop(int k, int n) {
         int[][] dp = new int[n + 1][k + 1];
        
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
        }
        
        for (int i = 1; i <= k; i++) {
            dp[1][i] = 1;
        }  
        
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                int minMoves = Integer.MAX_VALUE;
                for (int f = 2; f <= i; f++) {
                    if (Math.max(dp[f - 1][j - 1], dp[i - f][j]) < minMoves) {
                        minMoves = Math.max(dp[f - 1][j - 1], dp[i - f][j]);
                        dp[i][j] = minMoves + 1;
                    }
                }                
            }
        }
        return dp[n][k];
    }
}

// get min trials from max floors you can try with m trials and k eggs
class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n + 1][k + 1];
        
        int m = 0;
        while (dp[m][k] < n) {
            m++;
            for (int i = 1; i <= k; i++) {
                dp[m][i] = dp[m - 1][i] + dp[m - 1][i - 1] + 1;
            }
            
        }
        return m;
    }
}
