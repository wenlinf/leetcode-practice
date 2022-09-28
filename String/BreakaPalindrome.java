class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return "";
        String result = "";
        for (int i = 0; i < n; i++) {
            char ch = palindrome.charAt(i);
            if (ch != 'a') {
                if (n % 2 == 1 && i == n / 2) continue;
                result = palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1, n);
                return result;
            }
        }
        return palindrome.substring(0, n - 1) + 'b';
    }
}
