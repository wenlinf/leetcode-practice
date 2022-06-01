class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int[] count = new int[26];
        int max = 0;
        int n = s.length();
        int curr = 0;
        int maxFreq = 0;
        while (r < n) {
            int index = s.charAt(r) - 'A';
            count[index]++;
            maxFreq = Math.max(maxFreq, count[index]);
            curr++;
            if (curr - maxFreq <= k) {
                max = Math.max(max, curr);
            } else if (curr - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                l++;
                curr--;
            }
            r++;
        }
        return max;
    }
}
