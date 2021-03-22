class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        Map<String, Integer> map2 = new HashMap<>(); 
        for (int i = 0; i < list2.length; i++) {
            if(map1.containsKey(list2[i])) {
                map2.put(list2[i], map1.get(list2[i]) + i);
            }
        }
        int minVal = list1.length + list2.length;

        for (Integer index : map2.values()) {
            if (index <= minVal) {
                minVal = index;
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (entry.getValue() == minVal) {
                list.add(entry.getKey());
            }
        }
        String[] result = new String[list.size()];
        result = list.toArray(result);
        return result;
        
    }
}
