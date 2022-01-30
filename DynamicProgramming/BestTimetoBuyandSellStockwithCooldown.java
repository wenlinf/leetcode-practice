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
