class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            pq.add(stones[i]);
        }
        while (pq.size() > 1) {
            int heavy1 = pq.poll();
            int heavy2 = pq.poll();
            pq.add(Math.abs(heavy1 - heavy2));
        }
        return pq.size() == 0 ? 0: pq.poll();        
    }
}
