// top down DP TLE
class Solution {
    private Map<String, Integer> memo;
    public int minOperations(int[] nums, int x) {
        this.memo = new HashMap<>();
        return dp(nums, 0, nums.length - 1, x);
    }
    
    private int dp(int[] nums, int i, int j, int target) {
        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);
        if (target < 0) return -1;
        if (target == 0) return 0;
        if (i == j) {
            if (nums[i] == target) return 1;
            return -1;
        }
        if (i > j) {
            return -1;
        }
        int takeLeft = dp(nums, i + 1, j, target - nums[i]);
        int takeRight = dp(nums, i, j - 1, target - nums[j]);
        if (takeLeft == -1 && takeRight == -1) {
            memo.put(key, -1);
        }
        else if (takeLeft == -1) {
            memo.put(key, takeRight + 1);
        }
        else if (takeRight == -1) {
            memo.put(key, takeLeft + 1);
        } else {
            memo.put(key, Math.min(takeLeft, takeRight) + 1);
        }
        return memo.get(key);
    }
}
