class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) return n;
        int[] temp = new int[n];
        Arrays.fill(temp, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    temp[i] = Math.max(temp[i], 1 + temp[j]);
                }
            }
        }
        int result = 0;
        for (int i = 0 ; i < n; i++) {
            result = Math.max(result, temp[i]);
        }
        return result;
    }
}

// patience sort
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) return n;
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int size = sub.size();
            int lastSub = sub.get(size - 1);
            if (num > lastSub) {
                sub.add(num);
            } else if (num == lastSub) {
                continue;
            } else {
                int j = 0;
                while (num > sub.get(j)) {
                    j++;
                }
                sub.set(j, num);
            }
        }
        return sub.size();
    }
}

// nlogn solution
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        int len = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (len == 0) {
                len++;
                temp.add(num);
            } else {
               if (num > temp.get(len - 1)) {
                   temp.add(num);
                   len++;
               } else if (num <= temp.get(0)) {
                   temp.set(0, num);
               } else {
                   int k = bsearch(temp, num, len - 1);
                   temp.set(k, num);
               }
            } 
        }
        return len;
    }
    
    private int bsearch(List<Integer> temp, int num, int hi) {
        int lo = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if ((num > temp.get(mid)) && (num <= temp.get(mid + 1))) {
                return mid + 1;
            } else if (num > temp.get(mid + 1)) {
                lo = mid + 1;
            } else if (num <= temp.get(mid)) {
                hi = mid;
            }
        }
        return -1;
    }
}
