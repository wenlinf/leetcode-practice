class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < s.length() && !isAlphanumeric(s.charAt(start))) start++;
            while (end > 0 && !isAlphanumeric(s.charAt(end))) end--;
            if (start >= s.length() || end < 0) break;
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
            start++;
            end--;
        }
        return true;
    }
    private static boolean isAlphanumeric(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) return true;
        return false;
    }
}
