class NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n <= 1) return n;
        if (n == 2) return 1;
        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 1;
        for (int i = 3; i < cache.length; i++) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
        }
        return cache[n];
    }
}
