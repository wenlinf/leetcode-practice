class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int key = sum - k;
            if (prefix.containsKey(key)) result += prefix.get(key);
            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
