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

//greedy
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int farthest = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                end = farthest;
                jumps++;
            }
        }
        return jumps;
    }
}

// greedy solution from neetcode
class Solution {
    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int farthest = 0;
        int jumps = 0;
        
        while (right < n - 1) {
            for (int i = left; i<= right; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }
            jumps++;
            left = right + 1;
            right = farthest;          
        }
        return jumps;
    }
}
