// time complexity: O(n) space complexity: O(n)
// only need one loop to update left and right.
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!count.containsKey(nums[i])) {
                left.put(nums[i], i);
            }
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int maxCount = 0;

        for (int i = nums.length - 1;i >= 0; i--) {
            if (!right.containsKey(nums[i])) {
                right.put(nums[i], i);
            }
            if (count.get(nums[i]) > maxCount) {
                maxCount = count.get(nums[i]);
            }
        }
        int result = nums.length;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int freq = entry.getValue();
            int key = entry.getKey();
            if (freq == maxCount) {
                result = Math.min(result, right.get(key) - left.get(key) + 1);
            }
        }
        return result;
    }
}
