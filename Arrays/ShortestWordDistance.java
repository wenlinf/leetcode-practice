class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int word1Index = -1;
        int word2Index = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String word = wordsDict[i];
            if (word.equals(word1)) {
                if (word2Index != -1) {
                    res = Math.min(res, i - word2Index);
                    word1Index = i;
                } else {
                    word1Index = i;
                }
            }
            if (word.equals(word2)) {
                if (word1Index != -1) {
                    res = Math.min(res, i - word1Index);
                    word2Index = i; 
                } else {
                    word2Index = i;
                }
            }
        }
        return res;
    }
}
