class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        /*
        1. Use a string of digits
        2. get the length of the low and high (by converting them to string)
        3. start traversing the digits and check the substrings with the length of the low number
        4. if the substring is within range, add it to result
        5. when reaching the end, increase the length and check again
        6. return the final result
        */
        String digits = "123456789";
        List<Integer> result = new ArrayList<>();
        String lo = String.valueOf(low);
        String hi = String.valueOf(high);
        int len1 = lo.length();
        int len2 = hi.length();
        int currLen = len1;
        while (currLen <= len2) {
            int index = 0;
            while (index + currLen <= digits.length()) {
                String sub = digits.substring(index, index + currLen);
                if (Integer.valueOf(sub) >= low && Integer.valueOf(sub) <= high) {
                    result.add(Integer.valueOf(sub));
                }
                index++;
            }
            currLen++;
        }
        return result;
    }
}
