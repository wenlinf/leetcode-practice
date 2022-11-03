class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.result = new ArrayList<>();
        this.set = new HashSet<>(wordDict);
        backtrack(s, 0, new StringBuilder());
        return result;
    }
    
    private List<String> result;
    private Set<String> set;
    private void backtrack(String s, int start, StringBuilder sb) {
        if (start == s.length()) {
            result.add(sb.substring(0, sb.length() - 1).toString());
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (set.contains(s.substring(start, i))) {
                sb.append(s.substring(start, i));
                sb.append(" ");
                backtrack(s, i, sb);
                sb.setLength(sb.length() - 1 - (i - start));
            }
        }
    }
}
