class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int count = 0;
        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                int j = i; 
                while (j * i < n) {
                    primes[j * i] = false;
                    j++;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }
}
