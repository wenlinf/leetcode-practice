class Solution {
    public List<String> generateParenthesis(int n) {
        this.result = new ArrayList<>();
        this.left = n;
        this.right = n;
        backtrack(new StringBuilder());
        return result;
    }
    
    private List<String> result;
    private int left;
    private int right;
    
    private void backtrack(StringBuilder track) {
        if (left < 0 || right < 0) return;
        if (right < left) return;
        if (left == 0 && right == 0) {
            result.add(track.toString());
            return;
        }
        track.append("(");
        left--;
        backtrack(track);
        left++;
        track.deleteCharAt(track.length() - 1);
        
        track.append(")");
        right--;
        backtrack(track);
        right++;
        track.deleteCharAt(track.length() - 1);
    }
}
