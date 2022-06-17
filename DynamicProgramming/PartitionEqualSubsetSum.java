class Solution {
    // RECURSIVE SOLUTION - TIME LIMITED EXCEEDED !!!!
    private boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        memo = new boolean[n][sum];
        return helper(nums, 0, sum / 2);
    }
    
    private boolean helper(int[] nums, int index, int sum) {
        int n = nums.length;
        if (index >= n && sum != 0) return false;
        if (sum <= 0 && index < n) return false;
        if (index == n && sum == 0) return true;
        if (nums[index] > sum) {
            return helper(nums, index + 1, sum);
        } else {
            return helper(nums, index + 1, sum - nums[index]) || helper(nums, index + 1, sum);
        }
    }
}

class Solution {
    // Use memoization based on the recursive solution - accepted
    private Map<String, Boolean> memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        memo = new HashMap<>();
        return helper(nums, 0, sum / 2);
    }
    
    private boolean helper(int[] nums, int index, int sum) {
        String key = String.valueOf(index) + "," + String.valueOf(sum);
        
        int n = nums.length;
        if (index >= n && sum != 0) return false;
        if (sum <= 0 && index < n) return false;
        if (index == n && sum == 0) return true;
        if (memo.containsKey(key)) return memo.get(key);
        boolean result;
        if (nums[index] > sum) {
            result = helper(nums, index + 1, sum);
        } else {
            result = helper(nums, index + 1, sum - nums[index]) || helper(nums, index + 1, sum);
        }
        memo.put(key, result);
        return result;
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        sum = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0 ; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}

// same bottom-up solution but size of array is n rather than n+1
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        sum = sum / 2;
        boolean[][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] == j) {
                    dp[i][j] = true;
                } else if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n - 1][sum];
    }
}
