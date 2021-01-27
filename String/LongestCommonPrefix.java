class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() == 0) return "";
        }
        String prefix = strs[0].substring(0,1);
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].substring(0,1).equals(prefix)) res = prefix;
            else return "";
            if(strs[i].length() == 1) strs[i] = "";
            else strs[i] = strs[i].substring(1);
        }
        return res + longestCommonPrefix(strs); 
    }
}
