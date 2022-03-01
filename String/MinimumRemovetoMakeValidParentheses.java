class Solution {
    public String minRemoveToMakeValid(String s) {
        // iterate through the string s
        // create a stringbuilder to build the result
        // if the char is a letter, append it to sb
        // create a int count to keep track of the number of (
        // if the char is a (, increase the count, and append the char
        // if the char is a ), decrease the count, if the count gets below zero, do not append the char
        // if the count is 0, return the result
        // if the count > 0, go back and remove count number of open parens
        StringBuilder sb = new StringBuilder();
        int openCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == '(') {
                if (openCount < 0) openCount = 0;
                openCount++;
                sb.append(s.charAt(i));
            } else {
                openCount--;
                if (openCount >= 0) {
                    sb.append(s.charAt(i));
                }
            }
        }
        if (openCount <= 0) return sb.toString();
        if (openCount > 0) {
            s = sb.toString();
            sb.setLength(0);
            int countClose = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    if (countClose > 0) {
                        sb.append(s.charAt(i));
                        countClose--;
                    }
                } else if (s.charAt(i) == ')') {
                    countClose++;
                    sb.append(s.charAt(i));
                } else {
                    sb.append(s.charAt(i));
                }
            }
        } 
        return sb.reverse().toString();
    }
}
