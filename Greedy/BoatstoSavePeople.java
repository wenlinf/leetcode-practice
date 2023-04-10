class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int lo = 0; 
        int hi = n - 1;
        int res = 0;
        while (lo <= hi) {
            if (lo == hi) {
                if (people[lo] <= limit) {
                    res++;
                    break;
                }
            }
            int heavy = people[hi];
            int light = people[lo];
            if (heavy + light <= limit) {
                hi--;
                lo++;
            } else {
                hi--;
            }
            res++;
        }
        return res;
    }
}
