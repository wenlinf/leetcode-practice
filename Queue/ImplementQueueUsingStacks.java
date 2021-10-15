class MyQueue {
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();
    boolean reverse = false;
    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        while (stack1.size() != 1) {
            stack2.push(stack1.pop());
        }
        int result = (int)stack1.pop();
        while (!stack2.empty()) {
            stack1.push((int)stack2.pop());
        }
        return result;
    }
    
    public int peek() {
        while (stack1.size() != 1) {
            stack2.push(stack1.pop());
        }
        int result = (int)stack1.peek();
        while (!stack2.empty()) {
            stack1.push((int)stack2.pop());
        }
        return result;
    }
    
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
