class Solution {
    public String decodeString(String s) {
        // if string length is 1 don't do anything
        int n = s.length();
        if (n == 1) return s;
        
        // create a StringBuilder to store the numbers
        StringBuilder number = new StringBuilder();
        // create a StringBuilder to store intermediate results
        StringBuilder sb = new StringBuilder();
        
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // if current character is digit we append it to the 
                // number StringBuilder
                number.append(ch);
            } else if (ch == '[') {
                // if current char is an open bracket we push the 
                // number in the StringBuilder into the stack and 
                // clear the StringBuilder to store the next number
                stack.push(number.toString());
                number.setLength(0);
                stack.push(String.valueOf(ch));
            } else if (ch == ']') {
                // if current char is close bracket we pop out all 
                // the elements inside the brackets and repeat them
                // based on the number stored before "["
                while (!stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }
                stack.pop(); // pop the open bracket
                int freq = Integer.valueOf(stack.pop()); // pop the number
                int curr = sb.length();
                for (int j = 0; j < freq - 1; j++) {
                    sb.append(sb.substring(0, curr));
                }
                stack.push(sb.toString());
                sb.setLength(0);
            } else {
                stack.push(String.valueOf(ch));
            }
        }
        // build the result and return
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
