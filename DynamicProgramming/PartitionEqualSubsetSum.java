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
