class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int slow = s.length() - 1;
        int fast = s.length() - 1;
        String result = "";
        while (fast >= 0) {
            if (s.charAt(fast) == ' ') {
                while (s.charAt(fast) == ' ') {
                    fast--;
                }
                result += s.substring(fast + 1, slow + 1).trim();
                result += ' ';
                slow = fast;
            }
            if (fast == 0) {
                result += s.substring(fast, slow + 1).trim();
            }
            fast--;
        }
        return result.trim();
    }
    
    /*
    public String reverseWords(String s) {
        String[] splitted = s.trim().split("\\s+");
        String result = "";
        for (int i = splitted.length - 1; i >= 0; i--) {
            result += splitted[i];
            if (i != 0) {
                result += " ";
            }
        }
        return result;
    }
    */
}
