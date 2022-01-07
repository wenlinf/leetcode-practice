class FibonacciNumber {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] cache = new int[n + 1];
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        
        return cache[n];
    }
  
    public int fib_recursive(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}
