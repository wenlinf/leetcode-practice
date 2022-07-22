class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        Stack<Character> stack = new Stack();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                stack.add(ch);
            } 
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                sb.append(stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
