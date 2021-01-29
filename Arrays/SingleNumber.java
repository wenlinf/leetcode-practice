class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], false);
            else map.put(nums[i], true);
        }
        int result = nums[0];
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) result = entry.getKey();
        }
        return result;
    }
}
