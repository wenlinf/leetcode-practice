class MyCircularQueue {
    private int[] myCircularQueue;
    private int rear;
    private int front;
    
    public MyCircularQueue(int k) {
        myCircularQueue = new int[k+1];
        int rear = 0;
        int front = 0;
    }
    
    public boolean enQueue(int value) {
        int QUEUE_LENGTH = myCircularQueue.length;
        if ((rear + 1) % QUEUE_LENGTH == front) return false;
        myCircularQueue[rear] = value;
        rear = (rear + 1) % QUEUE_LENGTH;
        return true;
    }
    
    public boolean deQueue() {
        int QUEUE_LENGTH = myCircularQueue.length;
        if (front == rear) return false;
        myCircularQueue[front] = 0;
        front = (front + 1) % QUEUE_LENGTH;
        return true;
    }
    
    public int Front() {
        if (front == rear) return -1;
        return myCircularQueue[front];
    }
    
    public int Rear() {
        if (front == rear) return -1;
        if (rear == 0) return myCircularQueue[myCircularQueue.length - 1];
        return myCircularQueue[rear - 1];
    }
    
    public boolean isEmpty() {
        if (front == rear) return true;
        return false;
    }
    
    public boolean isFull() {
        int QUEUE_LENGTH = myCircularQueue.length;
        if ((rear + 1) % QUEUE_LENGTH == front) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
