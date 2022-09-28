// Time complexity O(n)
// Space complexity: Should the space complexity be O(1) or O(n)? n is the length of the input string
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

// better solution. ONly check the first half of the array. 
// Time complexity O(n) because we are checking half of the string.
// Space complexity O(n) because we are creating an addional array 
class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return "";
        
        char[] arr = palindrome.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char ch = arr[i];
            if (ch != 'a') {
                arr[i] = 'a';
                return String.valueOf(arr);
            }
        }
        arr[n - 1] = 'b';
        return String.valueOf(arr);
    }
}
