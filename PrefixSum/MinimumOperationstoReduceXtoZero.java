class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum == x) return nums.length;

        int target = sum - x;
        int[] prefix = new int[nums.length + 1];
        int maxLen = -1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
            if (map.containsKey(prefix[i] - target)) {
                maxLen = Math.max(maxLen, i - map.get(prefix[i] - target));
            }
            if (map.containsKey(prefix[i])) continue;
            map.put(prefix[i], i);
        }
        
        // for (int i = 0; i < prefix.length; i++) {
        //     for (int j = i + 1; j < prefix.length; j++) {
        //         if (prefix[j] - prefix[i] == target) {
        //             maxLen = Math.max(maxLen, j - i);
        //         }
        //     }
        // }
        return maxLen == -1 ? -1 : nums.length - maxLen;
        
    }
}
