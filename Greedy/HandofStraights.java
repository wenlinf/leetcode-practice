class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(hand[i]);
        }
        while (!pq.isEmpty()) {
            int val = pq.poll();
            for (int i = 1; i < groupSize; i++) {
                if (!pq.remove(val + i)) return false;
            }
        }
        return true;
    }
}
