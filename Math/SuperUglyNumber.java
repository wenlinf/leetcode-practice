//TLE
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        Set<Long> seen = new HashSet<>();
        seen.add(1L);
        for (int i = 0; i < n - 1; i++) {
            long top = pq.poll();
            for (int prime : primes) {
                if (!seen.contains(top * prime)) {
                    seen.add(top * prime);
                    pq.offer(top * prime);
                }
            }
        }
        long res = pq.poll();
        return (int) res;
    }
}
