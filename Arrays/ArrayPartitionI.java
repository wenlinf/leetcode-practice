class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = nums[0];
        if (nums.length == 2) return result;
        for (int i = 2; i < nums.length; i+= 2) {
            result += nums[i];
        }
        return result;
    }
}
