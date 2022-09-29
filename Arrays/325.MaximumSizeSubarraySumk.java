// Brute force TLE
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) result = Math.max(result, j - i + 1);
            }
        }
        return result;
    }
}

class Solution {
    /*
    prefix sum: 
    arr = 1, 2, 3, 4, 5
    prefix = 0, 1, 3, 6, 10, 15
    
    to get sum from i to j: 
      sum[i-j] = prefix[j + 1] - prefix[i]
    */
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (prefix[j] - prefix[i] == k) {
                    result = Math.max(result, j - i);
                }
            }
        }
        return result;
    }
}

class Solution {
    /*
    prefix sum: 
    arr = 1, 2, 3, 4, 5
    prefix = 1, 3, 6, 10, 15
    
    if k = 5?
    to get sum from i to j: 
      sum[i-j] = prefix[j + 1] - prefix[i]
      1. create a HashMap to store the prefix sums (key is index, value is the prefix sum at that index)
      2. traverse the array, store the prefix sum in the hashmap on the way
      3. while traversing, if current prefix - k exist in hashmap, we can update the result
    */
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix += nums[i];
            if (map.containsKey(prefix - k)) {
                result = Math.max(result, i - map.get(prefix - k) + 1);
            }
            if (!map.containsKey(prefix)) map.put(prefix, i + 1);
        }
        return result;
    }
}
