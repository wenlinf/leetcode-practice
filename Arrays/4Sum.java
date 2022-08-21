class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, target, 4);
    }
    
    private List<List<Integer>> kSum(int[] nums, int start, long target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (start > n - 1) return result;
        long avg = target / k;
        if (avg < nums[start] || nums[n - 1] < avg) return result;
        if (k == 2) {
            int lo = start;
            int hi = nums.length - 1;
            while (lo < hi) {
                int left = nums[lo];
                int right = nums[hi];
                int sum = left + right;
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) lo++;
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) hi--;
                } else {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(left);
                    sub.add(right);
                    result.add(sub);
                    while (lo < hi && nums[lo] == left) lo++;                
                    while (lo < hi && nums[hi] == right) hi--;

                }
            }
        } else {
            for (int i = start; i < n; i++) {
                int curr = nums[i];
                List<List<Integer>> subsums = kSum(nums, i + 1, target - curr, k - 1);

                if (subsums.size() != 0) {
                    for (List<Integer> subsum : subsums) {
                        List<Integer> sub = new ArrayList<>();
                        sub.add(curr);
                        sub.addAll(subsum);
                        result.add(sub);
                    }

                }
                while (i < n - 1 && nums[i] == nums[i+1]) i++;

            }
        }
        return result;
    }
    
}
