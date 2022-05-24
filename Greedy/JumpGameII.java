// Recursive solution. TLE.
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        return dp(nums, 0);
    }
    public int dp(int[] nums, int index) {
        int n = nums.length;
        if (index >= n - 1) return 0;
        if (index + nums[index] >= n - 1) return 1;
        int minJumps = 10001;
        for (int i = index + 1; i <= index + nums[index]; i++) {
            minJumps = Math.min(minJumps, 1 + dp(nums, i));
        }   
        return minJumps;
    }
}

// memoization added to recursive solution
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        this.memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }
    private int[] memo;
    public int dp(int[] nums, int index) {
        int n = nums.length;
        if (index >= n - 1) return 0;
        if (memo[index] != -1) return memo[index];
        if (index + nums[index] >= n - 1) return 1;
        int minJumps = 10001;
        for (int i = index + 1; i <= index + nums[index]; i++) {
            minJumps = Math.min(minJumps, 1 + dp(nums, i));
        }   
        memo[index] = minJumps;
        return minJumps;
    }
}

// dp bottom up
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        this.memo = new int[n];
        Arrays.fill(memo,  n + 1);
        memo[n - 1] = 0;
        dp(nums);
        return memo[0];
    }
    
    private int[] memo;
    private void dp(int[] nums) {
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= n - 1) {
                memo[i] = 1;
            } else {
                for (int j = i + 1; j <= i + nums[i]; j++) {
                    memo[i] = Math.min(memo[i], 1 + memo[j]);
                }
            }
        }
    } 
}
