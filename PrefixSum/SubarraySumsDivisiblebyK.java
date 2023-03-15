class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] mods = new int[k];
        int prevMod = 0;
        int result = 0;
        mods[0] = 1; // if the subarray from 0 to i is divisible by k
        for (int num : nums) {
            prevMod = (prevMod + num % k + k) % k;
            result += mods[prevMod];
            mods[prevMod]++;
        }
        return result;
    }
}
