class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>((a, b) -> a - b);
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
    }
    
    public void addNum(int num) {
        if(minHeap.size() == 0) {
            if (maxHeap.size() == 0) {
                minHeap.add(num);
                return;
            }
            if (num >= maxHeap.peek()) {
                minHeap.add(num);
            } else {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
            return;
        }
        int topOfMin = minHeap.peek();
        if (num >= topOfMin) {
            minHeap.add(num);
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            } 
        } else {
            maxHeap.add(num);
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
        }
        
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double)(minHeap.peek() + maxHeap.peek()) / 2;
        } 
        return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
