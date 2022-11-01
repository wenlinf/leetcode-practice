class Solution {
    public int compress(char[] chars) {
        // need two pointers
        // a left and a right pointer
        // right pointer traverse the array
        // if right char is same as prev, increase curr gropu len
        // if right char is diff than prev
            // if curr group len is greater than 1, 
                // update chars[left] to right char
                // increase left
                // update chars[left] to curr group len,
                // increase left
            // if curr group len equals 1
                // update chars[left] to right char
                // increase left
            // reset curr group len to 1
            // update prev = curr char
        // stop until right pointer reaches the end of array
        int n = chars.length;
        char prev = chars[0];
        int left = 0;
        int right = 1;
        int currGroup = 1;
        while (right < n) {
            char rightChar = chars[right];
            if (rightChar == prev) {
                currGroup++;
            } else if (rightChar != prev) {
                if (currGroup > 1) {
                    chars[left++] = prev;
                    String len = String.valueOf(currGroup);
                    for (int j = 0; j < len.length(); j++) {
                        chars[left++] = len.charAt(j);
                    }    
                    
                } else if (currGroup == 1) {
                    chars[left++] = prev;
                }
                currGroup = 1;
                prev = rightChar;
            }
            right++;
        }
        if (currGroup == 1) {
            chars[left++] = prev; 
        } else if (currGroup > 1) {
            chars[left++] = prev;
            String len = String.valueOf(currGroup);
            for (int j = 0; j < len.length(); j++) {
                chars[left++] = len.charAt(j);
            }    
        }
        return left;     

    }
}
