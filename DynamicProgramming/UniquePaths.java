class UniquePaths {
    public int uniquePathsDP(int m, int n) {
        int[][] cache = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    cache[j][i] = 1;
                } else {
                    cache[j][i] = cache[j - 1][i] + cache[j][i - 1];
                }
            }
        }
        return cache[m - 1][n - 1];
    }
    
    public int uniquePathsMath(int m, int n) {
        if (m == 1 || n == 1) return 1;
        m--;
        n--;
        if (m < n) {
            m = m + n;
            n = m - n;
            m = m - n;
        }
        
        long result = 1;
        int j = 1;
        
        for (int i = m + 1; i <= m + n; i++, j++) {
            result *= i;
            result /= j;
        }
        return (int)result;
    }
    
}
