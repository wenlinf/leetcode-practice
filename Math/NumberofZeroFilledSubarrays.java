class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long numOfSubarray = 0;
        for (int num : nums) {
            if (num == 0) {
                numOfSubarray++;
            } else {
                numOfSubarray = 0;
            }
            ans += numOfSubarray;
        }
        return ans;
    }
}
