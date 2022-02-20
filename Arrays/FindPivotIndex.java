class Solution {
    public int pivotIndex(int[] nums) {
         // initial conditions:
           // int leftSum = 0
           // int rightSum = sum - nums[0]
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        // while traversing, leftSum += nums[i], rightSum -= nums[i]
        if (leftSum == rightSum) return 0;
        // when rightSUm == leftSum return i
        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (rightSum == leftSum) return i;
        }
        return -1;
    }
}
