class ValidParenthesis {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) return false;
                char poppedChar = stack.pop();
                if (!isPair(poppedChar, s.charAt(i))) return false;
            }
        }
        if (!stack.empty()) return false;
        return true;
    }
    private boolean isPair(char ch1, char ch2) {
        if (ch1 == '(' && ch2 == ')') return true;
        if (ch1 == '{' && ch2 == '}') return true;
        if (ch1 == '[' && ch2 == ']') return true;
        return false;
    }
}
