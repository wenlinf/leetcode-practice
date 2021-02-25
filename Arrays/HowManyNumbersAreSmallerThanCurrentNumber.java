class HowManyNumbersAreSmallerThanCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums.length-1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[i]) result[j]--;
                else if (nums[j] > nums[i]) result[i]--;
                else {
                    result[i]--;
                    result[j]--;
                }
            }
        }
        return result;
    }
}
