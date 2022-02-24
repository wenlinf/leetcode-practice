class KthLargest {
    // can use a heap. Only save the k largest numbers in the heap. 
    // when adding numbers
      // if there are less elements in the heap than k, add the element, since the description says there is guarateed to be at least k elements in the heap when add is called, we can return the first element in the heap
    // if there are more elements in the heap than k
      // if the new number is greater than the first element in the heap, insert the new number, remove the top element, and return the top element in the heap
      // if the new number is smaller than the first element, return the top element in the heap.
    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        int index = 0;
        while (index < nums.length - k) {
            this.pq.remove();
            index++;
        }
    }

    public int add(int val) {
        if (this.pq.size() < this.k) {
            this.pq.add(val);
            return this.pq.peek();
        }
        if (val >= this.pq.peek()) {
            this.pq.add(val);
            this.pq.remove();
            return this.pq.peek();
        } else {
            return this.pq.peek();
        }
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
