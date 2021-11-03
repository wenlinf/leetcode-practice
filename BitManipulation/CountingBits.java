class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int count;
        int j;
        for (int i = 0; i <= n; i++) {
            count = 0;
            j = i;
            while (j != 0) {
                j = j & (j - 1);
                count++;
            }
            result[i] = count;
        }
        return result;
    }
}
