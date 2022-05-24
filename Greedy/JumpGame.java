class Solution {
    public boolean canJump(int[] nums) {
        int end = 0;
        int nextEnd = 0;
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (i <= end) {
                while (i < n && i <= end) {
                nextEnd = Math.max(nums[i] + i, nextEnd);
                i++;
            }
            end = nextEnd;
            if (end >= n - 1) return true;
            } else {
                break;
            }
            
        }
        return false;
    }
}

/*
boolean canJump(int[] nums) {
    int n = nums.length;
    int farthest = 0;
    for (int i = 0; i < n - 1; i++) {
        // 不断计算能跳到的最远距离
        farthest = Math.max(farthest, i + nums[i]);
        // 可能碰到了 0，卡住跳不动了
        if (farthest <= i) {
            return false;
        }
    }
    return farthest >= n - 1;
}
*/

// DP: Top down:
class Solution {
    public boolean canJump(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.memo = new State[n];
        Arrays.fill(memo, State.UNKNOWN);
        return dp(0) == State.GOOD ? true : false;
    }
    
    private int[] nums;
    private int n;
    private State[] memo;
    
    private State dp(int index) {
        if (memo[index] != State.UNKNOWN) return memo[index];
        if (index >= n - 1) return State.GOOD;
        for (int i = index + 1; i <= index + nums[index]; i++) {
            if (dp(i) == State.GOOD) {
                memo[index] = State.GOOD;
                    break;
            }
        }
        if (memo[index] == State.UNKNOWN) {
            memo[index] = State.BAD;
        }
        return memo[index];
    }
    
    private enum State {
        GOOD, BAD, UNKNOWN
    }
}

//DP: Bottom up
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        this.memo = new State[n];
        Arrays.fill(memo, State.UNKNOWN);
        memo[n - 1] = State.GOOD;
        return dp(nums);
    }
    
    private State[] memo;
    
    private boolean dp(int[] nums) {
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j > n - 1) break;
                if (memo[j] == State.GOOD) {
                    memo[i] = State.GOOD;
                    break;
                }
            }
            if (memo[i] == State.UNKNOWN) {
                memo[i] = State.BAD;
            }
        }
        return memo[0] == State.GOOD;
    }
    
    private enum State {
        GOOD, BAD, UNKNOWN
    }
}

// recursion: Time limit exceeded
class Solution {
    public boolean canJump(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        return dp(0);
    }
    
    private int[] nums;
    private int n;
    private boolean dp(int index) {
        if (index >= n - 1) return true;
        if (nums[index] == 0 && index < n - 1) return false;
        for (int i = index + 1; i <= index + nums[index]; i++) {
            if (dp(i)) return true;
        }
        return false;
    }
}
