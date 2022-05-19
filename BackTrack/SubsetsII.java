class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        backtrack(0, new LinkedList<>());
        return result;
    }
    
    private List<List<Integer>> result = new ArrayList<>();
    private int[] nums;
    
    private void backtrack(int index, LinkedList<Integer> path) {
        result.add(new LinkedList<>(path));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(i + 1, path);
            path.removeLast();
        }

    }
}
