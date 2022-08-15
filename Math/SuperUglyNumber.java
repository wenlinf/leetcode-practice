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


class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < primes.length; i++) {
            pq.add(new int[]{1, primes[i], 1});
        }
        int[] ugly = new int[n + 1];
        int pt = 1;
        while (pt <= n) {
            int[] top = pq.poll();
            int num = top[0];
            int prime = top[1];
            int index = top[2];
            if (num != ugly[pt - 1]) {
                ugly[pt] = num;
                pt++;
            }

            pq.offer(new int[]{prime * ugly[index], prime, index + 1});
        }
        return ugly[n];
    }
}
