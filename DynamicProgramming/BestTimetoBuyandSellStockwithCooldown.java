class BestTimetoBuyandSellStockwithCooldown {
    List<Map<Boolean, Integer>> dp = new ArrayList<>();

    public int maxProfit(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
           dp.add(new HashMap<Boolean, Integer>());
        }
//         buying : start from i + 1
//         selling : start from i + 2
        return dfs(0, prices, true);
    }
    
    private int dfs(int index, int[] prices, boolean buying) {
        if (index >= prices.length) return 0;
        if (dp.get(index).size() != 0 && dp.get(index).get(buying) != null) return dp.get(index).get(buying);
        
        int buy = 0;
        int skip = 0;
        int sell = 0;
        
        if (buying) {
            buy = dfs(index + 1, prices, !buying) - prices[index];
            skip = dfs(index + 1, prices, buying);
            dp.get(index).put(buying, Math.max(buy, skip));
        } else {
            sell = dfs(index + 2, prices, !buying) + prices[index];
            skip = dfs(index + 1, prices, buying);
            dp.get(index).put(buying, Math.max(sell, skip));
        }
        return dp.get(index).get(buying);
    }
}


class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            }
        }
        return dp[n - 1][0];
    }
}
