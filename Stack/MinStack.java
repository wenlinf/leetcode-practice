class MinStack {
    private List<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        minStack.add(val);
    }
    
    public void pop() {
        minStack.remove(minStack.size() - 1); 
    }
    
    public int top() {
        if (minStack.size() == 0) return -1;
        return minStack.get(minStack.size() - 1);
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < minStack.size(); i++) {
            if (minStack.get(i) < min) min = minStack.get(i);
        }
        return min;
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
