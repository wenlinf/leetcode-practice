class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int push = pushed[i];
            if (pushed[i] == popped[index]) {
                index++;
                while (stack.size() > 0 && popped[index] == stack.peek()) {
                    stack.pop();
                    index++;
                }
            } else {
                stack.push(pushed[i]);
            }
        }
        if (stack.size() > 0 || index < n) return false;
        return true;
    }
}
