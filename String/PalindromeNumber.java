class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int res = 0;
        int temp = x;
        while (x != 0) {
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && x > 7)) return false;
            res = res * 10 + x % 10;
            x = x / 10;
        }
       return temp == res;          
    }
}
