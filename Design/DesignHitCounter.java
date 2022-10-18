// Leetcode solution using Queue. Time complexity: getHits -> O(n) in the worst case because we might have to remove all the previous elements
// hit -> O(1) because we are only adding a number to the queue
// IMPORTANT: However, we must notice that each timestamp is processed only twice (first while adding the timestamp 
// in the queue in hit method and second while removing the timestamp from the queue in the getHits method). 
// Hence if the total number of timestamps encountered throughout is N, the overall time taken by getHits method is 
// O(N). This results in an amortized time complexity of O(1) for a single call to getHits method.
// Space complexity: O(n) because we create a queue to store all the timestamps
class HitCounter {

    private Queue<Integer> counts;
    private int PREV = 300;
    public HitCounter() {
        this.counts = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        this.counts.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while (this.counts.size() != 0) {
            if (counts.peek() <= timestamp - PREV) {
                counts.poll();
            } else {
                break;
            }
        }
        return counts.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

// another leetcode solution that is more efficient when multiple hits can happen at the same time
// Time complexity: hit -> O(1) because we are at most checking the last element in the list, and add a new element to the list
// getHits -> could be O(n) in the worst case because we might have to remove all the previous elements from the list
// Space complexity: O(n) because we need an additional list to keep track of all the elements
// But if there are multiple repetitions, the space and time complexities are actually better because for an element that appeared m times, when it's 
//removed, it only takes O(1) time rather than O(m) time. For space complexity it's the same
class HitCounter {
    private Deque<int[]> hits; // int[] -> {timestamp, count}
    private int total;
    private int PREV = 300;
    
    public HitCounter() {
        this.hits = new LinkedList<>();
        this.total = 0;
    }
    
    public void hit(int timestamp) {
        if (this.hits.size() != 0) {
            if (this.hits.getLast()[1] == timestamp) {
                int[] last = this.hits.removeLast();
                int freq = last[1];
                this.hits.add(new int[]{timestamp, freq + 1});
            } else {
                this.hits.add(new int[]{timestamp, 1});
            }
        } else {
            this.hits.add(new int[]{timestamp, 1});
        }
        this.total++;
    }
    
    public int getHits(int timestamp) {
        while (this.hits.size() > 0) {
            if (timestamp - this.hits.getFirst()[0] >= PREV) {
                int[] first = this.hits.getFirst();
                this.hits.removeFirst();
                this.total -= first[1];
            } else {
                break;
            }
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

class HitCounter {
    private int RECORD = 300;
    private int counts[];
    private int lastTimestamp;
    private int lastPosition;
    private int sum;
    

    public HitCounter() {
        this.counts = new int[RECORD];
        this.lastTimestamp = 0;
        this.lastPosition = 0;
        this.sum = 0;
    }
    
    public void hit(int timestamp) {
        if (timestamp == this.lastTimestamp) {
            this.counts[lastPosition]++;
        } else {
            int update = Math.min(RECORD, timestamp - lastTimestamp);
            for (int i = 0; i < update; i++) {
                lastPosition = (lastPosition + 1) % RECORD;
                sum -= counts[lastPosition];
                counts[lastPosition] = 0;
            }
            counts[lastPosition] = 1;
        }
        this.lastTimestamp = timestamp;
        this.sum++;
    }
    
    public int getHits(int timestamp) {
        int update = Math.min(this.RECORD, timestamp - lastTimestamp);
        for (int i = 0; i < update; i++) {
            this.lastPosition = (this.lastPosition + 1) % RECORD;
            sum -= counts[lastPosition];
            counts[lastPosition] = 0;
        }
        this.lastTimestamp = timestamp;
        return sum;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
