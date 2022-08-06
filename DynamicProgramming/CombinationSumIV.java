class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] cache = new int[target + 1];
        Arrays.fill(cache, -1);
        cache[0] = 1;
        return helper(nums, target, cache);
    }
    
    private int helper(int[] nums, int target, int[] cache) {
        if (cache[target] != -1) return cache[target];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                result += helper(nums, target - nums[i], cache);
            }
        }
        cache[target] = result;
        return result;
    }
}


//bottom-up
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        int n = nums.length;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] > i) continue;
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
