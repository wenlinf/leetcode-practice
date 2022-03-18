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


class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] table = new int[amount + 1];
        Arrays.fill(table, amount + 1);
        table[0] = 0;
        
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                table[i] = Math.min(table[i], 1 + table[i - coin]);
            }
        } 
        return table[amount] == amount + 1 ? -1 : table[amount];
    }
}
