class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        int index = 0;
        int insertIndex = k - 1;
        int[] result = new int[k];
        for (Map.Entry<Integer,Integer> entry : sortedMap.entrySet()) {
            if (index >= sortedMap.size() - k) {
                result[insertIndex] = entry.getKey();
                insertIndex--;
            } 
            index++;
        }
        return result;
    }
}
