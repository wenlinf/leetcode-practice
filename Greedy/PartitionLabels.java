class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(1);
            return result;
        } 
        int longest = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int lastIndex = s.lastIndexOf(ch);
            longest = Math.max(lastIndex, longest);
            if (i == longest) {
                result.add(longest - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
