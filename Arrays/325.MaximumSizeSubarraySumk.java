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
