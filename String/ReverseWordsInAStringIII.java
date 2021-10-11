class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[] strArr = s.split("\\s+");
        String result = "";
        for (int i = 0; i < strArr.length; i++) {
            for (int j = strArr[i].length() - 1; j >= 0; j--) {
                result += strArr[i].charAt(j);
            }
            if (i != strArr.length - 1) result += " ";
        }
        return result;
    }
}
