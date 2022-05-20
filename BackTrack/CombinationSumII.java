class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.used = new boolean[candidates.length];
        this.candidates = candidates;
        this.target = target;
        backtrack(0);
        return result;
    }
    
    private int[] candidates;
    private boolean[] used;
    private List<List<Integer>> result = new ArrayList<>();
    private int sum = 0;
    private LinkedList<Integer> path = new LinkedList<>();
    private int target;
    
    private void backtrack(int start) {
        if (sum == target) {
            result.add(new LinkedList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(i + 1);
            sum -= candidates[i];
            path.removeLast();
            used[i] = false;
        }
    }
}
