class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        char[] arr = new char[s.length()];
        int index = arr.length - 1;
        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()){
            if (entry.getValue() != 1) {
                for (int i = entry.getValue(); i >= 1; i--) {
                    arr[index] = entry.getKey();
                    index--;
                }
            } else {
               arr[index] = entry.getKey();
                index--; 
            }   
        }
        return String.valueOf(arr);
    }
}
