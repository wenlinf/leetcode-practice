class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < wordsA.length; i++) {
            map.put(wordsA[i], map.getOrDefault(wordsA[i], 0) + 1);
        }
        int count = 0;
        for (int i = 0; i <wordsB.length; i++) {
            if (map.containsKey(wordsB[i]) && map.get(wordsB[i]) % 2 != 0) {
                map.put(wordsB[i], map.get(wordsB[i]) + 1);
            }
            if (!map.containsKey(wordsB[i])) {
                map.put(wordsB[i], 1);
            }
        }
        
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if (entry.getValue()  == 1) {
                count++;
            }
        }
        String[] result = new String[count];
        int index = 0;
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if (entry.getValue()  == 1) {
                result[index] = entry.getKey();
                index++;
            }
        }
        return result;
    }
}
