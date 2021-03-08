class ToLowerCase {
    public String toLowerCase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.charAt(i) >='A' && str.charAt(i) <='Z') {
                int n = c + 32;
                c = (char)n;
            }
            result+=c;
        }
        return result;
    }
}
