class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        backtrack(1);
        return result;
    }
    
    private List<List<Integer>> result = new ArrayList<>();
    private int k;
    private int n;
    private LinkedList<Integer> path = new LinkedList<>();
    private int sum = 0;
    
    private void backtrack(int start) {
        if (path.size() == k && sum == n) {
            result.add(new LinkedList<>(path));
            return;
        }
        if (path.size() > k || sum > n) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            sum += i;
            path.add(i);
            backtrack(i + 1);
            path.removeLast();
            sum -= i;
        }
    }
}
