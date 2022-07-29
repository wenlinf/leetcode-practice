class Solution {
    public int twoEggDrop(int n) {
        int[][] dp = new int[3][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[1][i] = i;
        }
        dp[2][1] = 1;
        
        for (int i = 2; i <= n; i++) {
            int minMove = Integer.MAX_VALUE;
            for (int j = 2; j <= i; j++) {
                if (minMove > Math.max(dp[1][j - 1], dp[2][i - j])) {
                    minMove = Math.max(dp[1][j - 1], dp[2][i - j]);
                }        
            }  
            dp[2][i] = minMove + 1;
        }
        return dp[2][n];
    }
}
