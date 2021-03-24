class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        String tempStr;
        char[] tempArr;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            tempArr = strs[i].toCharArray();
            Arrays.sort(tempArr);
            tempStr = String.valueOf(tempArr);
            if (!map.containsKey(tempStr)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(tempStr, list);
            }
            else {
                List<String> currList = map.get(tempStr);
                currList.add(strs[i]);
                map.put(tempStr, currList);
            }
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
