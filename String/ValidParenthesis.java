class ValidParenthesis {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else {
                if (stack.empty()) return false;
                char poppedChar = stack.pop();
                if (poppedChar != s.charAt(i)) return false;
            }
        }
        if (!stack.empty()) return false;
        return true;
    }  
}
