class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1) {
            if (nums[0] > target) return 1;
            return 0;
        } 
        int pt1 = 0;
        int pt2 = 0;
        int currSum = 0;
        int minLen = Integer.MAX_VALUE;
        boolean hasMin = false;
        while (pt2 < nums.length) {
            if (nums[pt2] + currSum < target) {
                currSum += nums[pt2];
                pt2++;
            } else {
                hasMin = true;
                minLen = Math.min(minLen, pt2 - pt1 + 1);
                currSum -= nums[pt1];
                pt1++;
            }
            
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen; 
    }
}
