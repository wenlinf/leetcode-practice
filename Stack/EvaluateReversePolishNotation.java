class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int op1 = stack.pop();
                int op2 = stack.pop();
                if (token.equals("+")) {
                    stack.push(op1 + op2);
                } else if (token.equals("-")) {
                    stack.push(op2 - op1);
                } else if (token.equals("*")) {
                    stack.push(op1 * op2);
                } else {
                    stack.push(op2 / op1);
                }
            }     
        }
        return stack.pop();
    }
    
    
    public boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
