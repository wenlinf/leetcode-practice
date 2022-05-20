class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        backtrack(0);
        return result;
    }
    
    private int[] candidates;
    private int target;
    private int sum;
    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    
    private void backtrack(int start) {
        if (sum == target) {
            result.add(new LinkedList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtrack(i);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
