class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int open = 0;
        int close = 0;
        for (char ch : s.toCharArray()) {
            stack.push(ch);
            if (ch == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                stack.pop();
                StringBuilder sub = new StringBuilder();
                while (stack.size() > 1) {
                    sub.append(stack.pop());
                }
                stack.pop();
                sb.append(sub.reverse().toString());
            }
        }
        return sb.toString();
    }
}
