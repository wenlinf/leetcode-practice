class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
    
            if (set.contains(num)) return true;
            Integer ceiling = set.ceiling(num);
            if (ceiling != null && ceiling <= (long)t + num) return true;
            
            Integer floor = set.floor(num);
            if (floor != null && num <= (long)t + floor) return true;
            
            set.add(num);
            if (set.size() > k) set.remove(nums[i - k]);
        }
        return false;
    }
}
