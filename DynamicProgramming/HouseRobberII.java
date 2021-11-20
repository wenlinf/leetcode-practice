class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] robFirst = new int[nums.length - 1];
        int[] robSecond = new int[nums.length - 1];
        robFirst[0] = nums[0];
        robSecond[0] = nums[1];
        int result;
        for (int i = 1; i < nums.length; i++) {
            if (i >= 1 && i < robFirst.length) {
                if(i == 1) {
                    robFirst[i] = Math.max(nums[i], robFirst[i - 1]);
                } else {
                    robFirst[i] = Math.max((nums[i] + robFirst[i - 2]), robFirst[i - 1]);
                }
            }
            if (i >= 2 && i < nums.length) {
                if (i == 2) {
                    robSecond[i - 1] = Math.max(nums[i], robSecond[i - 2]);
                } else {
                    robSecond[i - 1] = Math.max((nums[i] + robSecond[i - 3]), robSecond[i - 2]);
                }
            }

        }
        result = Math.max(robFirst[robFirst.length - 1], robSecond[robSecond.length - 1]);
        return result;
    }
}
