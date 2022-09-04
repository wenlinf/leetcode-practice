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

//checked hints, slower than hashmap solution
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (prefix[j + 1] - prefix[i] == k) result++;
            }
        }
        return result;
    }
}
