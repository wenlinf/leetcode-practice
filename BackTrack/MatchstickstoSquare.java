class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        if (n < 4) return false;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) return false;
        int[] sides = new int[4];
        return dfs(0, sides, sum / 4, matchsticks);
    }
    
    private boolean dfs(int index, int[] sides, int target, int[] matchsticks) {
        if (index > matchsticks.length - 1) return true;
        for (int i = 0; i < 4; i++) {
            if (matchsticks[index] + sides[i] > target || (i > 0 && sides[i] == sides[i - 1])) {
                continue;
            }
            sides[i] += matchsticks[index];
            if (dfs(index + 1, sides, target, matchsticks)) return true;
            sides[i] -= matchsticks[index];
        }
        return false;
    }
    
}
