class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char first = stack.pop();
                if (!isPair(first, ch)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isPair(char x, char y) {
        if (x == '(') {
            return y == ')';
        } else if (x == '[') {
            return y == ']';
        } else if (x == '{') {
            return y == '}';
        } else {
            return false;
        }
    }
}
