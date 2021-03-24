class GroupAnagrams {
     public List<List<String>> groupAnagrams(String[] strs) {
        String tempStr;
        char[] tempArr;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            tempArr = strs[i].toCharArray();
            Arrays.sort(tempArr);
            tempStr = String.valueOf(tempArr);
            if (!map.containsKey(tempStr)) map.put(tempStr, new ArrayList<>());
            map.get(tempStr).add(strs[i]);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            List<String> group = new ArrayList<>();
            for (String str : entry.getValue()) {
                group.add(str);
            }
            result.add(group);
        }
        return result;
    }
}
