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
