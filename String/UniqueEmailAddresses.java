class Solution {
    public int numUniqueEmails(String[] emails) {
        int m = emails.length;
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int indexOfAt = email.indexOf("@");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < indexOfAt; i++) {
                if (email.charAt(i) == '+') {
                    break;
                }
                if (email.charAt(i) != '.') {
                    sb.append(email.charAt(i));
                }
            }
            for (int i = indexOfAt; i < email.length(); i++) {
                sb.append(email.charAt(i));
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
