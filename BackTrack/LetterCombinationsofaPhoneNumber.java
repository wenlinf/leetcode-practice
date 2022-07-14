class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(digits, 0, map, new StringBuilder());
        return result;
    }
    
    List<String> result = new ArrayList<>();
    
    private void helper(String digits, int index, Map<Character, String> map, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            this.result.add(sb.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = map.get(digit);
        int n = letters.length();
        for (int i = 0; i < n; i++) {
            sb.append(letters.charAt(i));
            helper(digits, index + 1, map, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
