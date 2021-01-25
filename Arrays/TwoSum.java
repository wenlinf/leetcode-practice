class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int pt1 = 0;
        int pt2 = 1;
        int sum;
        int[] result = new int[2];
        while (pt1 < nums.length - 1 && pt2 < nums.length) {
            sum = nums[pt1] + nums[pt2];
            if (sum == target) {
                result[0] = pt1;
                result[1] = pt2;
            }
            if (pt2 == nums.length - 1 && pt1 != nums.length - 2) {
                pt1++;
                pt2 = pt1 + 1;
                continue;
            } 
            pt2++;
        }
        return result;
    }
}
