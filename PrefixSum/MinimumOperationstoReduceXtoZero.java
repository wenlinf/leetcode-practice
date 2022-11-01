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


class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum == x) return nums.length;
        int left = 0;
        int curr = 0;
        int target = sum - x;
        int max = -1; 
        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr > target && left < nums.length) {
                curr -= nums[left];
                left++;
            }
            if (curr == target) {
                max = Math.max(max, right - left + 1);
            }
        }
        return max == -1 ? -1 : nums.length - max;
        
    }
}


class Solution {
    public int minOperations(int[] nums, int x) {
        int curr = 0;
        for (int num : nums) {
            curr += num;
        }
        if (curr == x) return nums.length;
        
        int left = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            curr -= nums[right];
            while (curr < x && left <= right) {
                curr += nums[left];
                left++;
            }
            if (curr == x) {
                min = Math.min(min, (nums.length - 1 - right) + left);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
