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

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(count, 0);
            for (int j = 0; j < strs[i].length(); j++) {
                char ch = strs[i].charAt(j);
                count[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < 26; k++) {
                sb.append(count[k]);
                sb.append("#");
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            
            map.get(key).add(strs[i]);
        }

        return new ArrayList(map.values());
    }
}
