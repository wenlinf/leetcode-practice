class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        // turn integer k into an array
        // add up the two arrays for the rightmost numbers
        // add the result to list, remember to add the carries as well
        List<Integer> kList = new ArrayList<>();
        while (k > 0) {
            kList.add(0, k % 10);
            k = k / 10;
        }
        int pt1 = num.length - 1;
        int pt2 = kList.size() - 1;
        int digit1 = 0;
        int digit2 = 0;
        int carry = 0;
        List<Integer> result = new ArrayList<>();
        while (pt1 >= 0 || pt2 >= 0) {
            if (pt1 < 0) {
                digit1 = 0;
            } else {
                digit1 = num[pt1];
            }
            if (pt2 < 0) {
                digit2 = 0;
            } else {
                digit2 = kList.get(pt2);
            }
            int sumDigit = (digit1 + digit2 + carry) % 10;
            carry = (digit1 + digit2 + carry) / 10;
            result.add(0, sumDigit);
            pt1--;
            pt2--;
        }
        if (carry == 1) {
            result.add(0, 1);
        }
        return result;
    }
}
