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
