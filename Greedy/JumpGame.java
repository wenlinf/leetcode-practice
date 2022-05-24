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
