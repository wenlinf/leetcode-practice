class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int lo, hi, target;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            lo = i + 1;
            hi = nums.length - 1;
            target = 0 - nums[i];
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (lo < hi) {
                    if (nums[lo] + nums[hi] > target) {
                        hi--;
                    } else if (nums[lo] + nums[hi] < target) {
                        lo++;
                    } else {
                        List<Integer> subList = Arrays.asList(nums[i], nums[lo], nums[hi]);
                        result.add(subList);
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    }
                }
            }            
        }
        return result;
    }
}
