class MinStack {
    private Stack<int[]> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if (minStack.isEmpty()) {
            minStack.push(new int[]{val, val});
        } else {
            int minVal = Math.min(val, minStack.get(minStack.size() - 1)[1]);
            minStack.push(new int[]{val, minVal});
        }
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.get(minStack.size() - 1)[0];
    }
    
    public int getMin() {
        return minStack.get(minStack.size() - 1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
