class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int cur = prices[0];
        int maxProfit = 0;
        int boughtIn = 0;
        boolean bought = false;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= cur) {
                if (bought) {
                    bought = false;
                    maxProfit += (prices[i - 1] - boughtIn);
                } 
            } else if (prices[i] > cur) {
                if (!bought) {
                    bought = true;
                    boughtIn = cur;
                } 
            }
            cur = prices[i];
            if (i == prices.length - 1 && bought) {
                maxProfit += (prices[i] - boughtIn);
            }
        }
        return maxProfit;
    }
}
