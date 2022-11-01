// Time complexity: O(nlogn) because we are using a heap and extracting max each time
// Space complexity: O(n) because we need a heap to store all the elements and at most there will be n elements in the heap
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int heavy1 = pq.poll();
            int heavy2 = pq.poll();
            if (heavy1 != heavy2) pq.add(Math.abs(heavy1 - heavy2)); // only add when they're not equal, otherwise we are adding a lot of 0s and it slows down the program
        }
        return pq.size() == 0 ? 0: pq.poll();        
    }
}
