class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1 || k == 1) return 0;
        if (k == 2) return 1;
    
        int len = (int)Math.pow(2, n - 1);
        if (k <= len / 2) {
            return kthGrammar(n - 1, k);
        }
        return 1 - kthGrammar(n - 1, k - len / 2);
    }
}
