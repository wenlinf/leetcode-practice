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
}
