class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0 || n == k) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) == 0) continue;
            for (int j = 1; j < k; j++) {
                if (map.containsKey(nums[i] + j)) {
                    map.put(nums[i] + j, map.get(nums[i] + j) - 1);
                } else {
                    return false;
                }
            }
            map.put(nums[i], map.get(nums[i]) - 1);
        }
        return true;
    }
}
