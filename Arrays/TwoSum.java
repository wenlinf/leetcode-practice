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
    public int[] twoSumSolution2(int[] nums, int target) {
        Map<Integer,Integer> dic = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            dic.put(nums[i], i);
        }
        int complement;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (dic.containsKey(complement) && dic.get(complement) != i) {
                result[0] = i;
                result[1] = dic.get(complement);
            }
        }
        return result;
    }
}
