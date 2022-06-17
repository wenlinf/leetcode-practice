class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            if (lower == upper) {
                result.add(upper + "");
                return result;
            } else {
                result.add(lower + "->" + upper);
                return result;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (nums[0] != lower) {
            if (nums[0] == lower + 1) {
                result.add(lower + "");
            } else {
                result.add(lower + "->" + (nums[0] - 1));
            }
        }
        for (int i = 0; i < n - 1; i++) { 
            int num = nums[i];
            int next = nums[i + 1];
            if (next != num + 1) {
                if (next - num == 2) {
                    result.add((num + 1) + "");
                } else {
                    result.add((num + 1) + "->" + (next - 1));
                }
            }
        }
        if (nums[n - 1] != upper) {
            if (nums[n - 1] == upper - 1) {
                result.add(upper + "");
            } else {
                result.add((nums[n - 1] + 1) + "->" + upper);
            }
        }
        return result;
    }
}
