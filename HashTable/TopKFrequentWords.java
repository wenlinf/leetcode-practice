class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        List<Map.Entry<String,Integer>> sortedList = new ArrayList<>(map.entrySet());
        Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() - o1.getValue() == 0) return o1.getKey().compareToIgnoreCase(o2.getKey());
                return o2.getValue() - o1.getValue();
            }
        });
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(sortedList.get(i).getKey());
        }
        return list;
    }
}
