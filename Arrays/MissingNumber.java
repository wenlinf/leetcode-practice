class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                result = i;
                break;
            }
        }
        return result;
    }

    public int missingNumberBitManipulation(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        res ^= nums.length;
        return res;
    }
}
