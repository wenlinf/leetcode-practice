class Solution {
    public String addBinary(String a, String b) {
        /*
        can't do this because there will be overflow
        int binaryA = Integer.parseInt(a, 2);
        int binaryB = Integer.parseInt(b, 2);
        return Integer.toBinaryString(binaryA + binaryB);
        */
        int lenA = a.length();
        int lenB = b.length();
        int carry = 0;
        String res = "";
        
        int maxLen = Math.max(lenA, lenB);
        for (int i = 0; i < maxLen; i++) {
            int bitA = i < lenA ? a.charAt(lenA - i - 1) - '0' : 0;
            int bitB = i < lenB ? b.charAt(lenB - i - 1) - '0' : 0;
            
            int temp = bitA + bitB + carry;
            carry = temp / 2;
            res = temp % 2 + res;
        }
        
        return carry == 1 ? 1 + res : res;
     }
}
