class Solution {
    private int[][] memo;
    private int[] nums, multipliers;
    private int n, m;
    
    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        this.nums = nums;
        this.multipliers = multipliers;
        
        memo = new int[n][m];
        
        return dp(0, 0);
    }
    
    public int dp(int left, int i) {
        if (i == m) {
            return 0;
        }
        
        int right = n - 1 - (i - left);
        
        if(memo[left][i] == 0) {
            memo[left][i] = Math.max(nums[left] * multipliers[i] + dp(left + 1, i + 1),
                       nums[right] * multipliers[i] + dp(left, i + 1)); 
        }
        
        return memo[left][i];
    }
}
