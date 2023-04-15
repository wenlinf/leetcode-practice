class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            List<Integer> pile = piles.get(i - 1);
            for (int j = 0; j <= k; j++) {
                int currSum = 0;
                for (int l = 0; l <= Math.min(j, pile.size()); l++) {
                    if (l > 0) {
                        currSum += pile.get(l - 1);
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - l] + currSum);
                }
            }
        }
        return dp[n][k];
    }
}
