class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.maxSize = nums.length;
        this.used = new boolean[nums.length];
        backtrack(0);
        return result;
    }
    
    private int maxSize;
    private int[] nums;
    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean[] used;
    
    private void backtrack(int start) {
        if (path.size() == maxSize) {
            result.add(new LinkedList<>(path));
            return;
        }
        
        for (int i = 0; i < maxSize; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(start + 1);
            path.removeLast();
            used[i] = false;
        }
    }
}
