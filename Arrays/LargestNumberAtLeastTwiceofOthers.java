class Solution {
    public int dominantIndex(int[] nums) {
        // if only one element return 0
        if (nums.length == 1) return 0;
        // initialize a maxNUm to be the first element
        int maxNum = nums[0];
        int index = 0;
        // initialize another num to keep track of the number that is twice as big as each element, keep the largest one
        // traverse the array, update the maxNum
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                index = i;
            }
        }

        int tracker = index == 0 ? nums[1] * 2 : nums[0] * 2;
        for (int i = 0; i < nums.length; i++) {
            if (i != index) {
                tracker = Math.max(tracker, nums[i] * 2);
            }
        }
        // compare the two integers
        if (tracker <= maxNum) {
            return index;
        }
        return -1;
    }
}
