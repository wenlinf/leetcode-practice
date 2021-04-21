class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        int result = 0;
        int biggestOddNum = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                result+=entry.getValue();
            } else {
                if (entry.getValue() > 2) {
                    result+=entry.getValue() - 1;
                }
                biggestOddNum = Math.max(biggestOddNum, entry.getValue());
            }
        }
        if (biggestOddNum!=0) result++;
        return result;
    }
}
