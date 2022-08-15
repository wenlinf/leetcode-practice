class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> two = new ArrayList<>();
        two.add(2);
        List<Integer> three = new ArrayList<>();
        three.add(3);
        List<Integer> five = new ArrayList<>();
        five.add(5);
        List<Integer> result = new ArrayList<>();
        int pt1 = 0; 
        int pt2 = 0;
        int pt3 = 0;
        int index = 1;
        result.add(1);
        while (index < n) {
            int next = Math.min(two.get(pt1), Math.min(three.get(pt2), five.get(pt3)));
            result.add(next);
            index++;
            if (next == two.get(pt1)) {
                pt1++;
                two.add(result.get(pt1) * 2);
            }
            if (next == three.get(pt2)) {
                pt2++;
                three.add(result.get(pt2) * 3);
            }
            if (next == five.get(pt3)) {
                pt3++;
                five.add(result.get(pt3) * 5);
            }
            
        }
        return result.get(n - 1);
    }
}
