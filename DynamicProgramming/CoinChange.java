class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int result = subProblem(coins, amount, new int[amount]);
        return result;       
    }
    
    private int subProblem(int[] coins, int amount, int[] count) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (count[amount - 1] != 0) return count[amount - 1];
        
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = subProblem(coins, amount - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
            count[amount - 1] = (min == Integer.MAX_VALUE)? -1 : min;
        }
        return count[amount - 1];
    }
}
