class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) result.add(nums2[i]);
        }
        int[] arr = new int[result.size()];
        int j = 0;
        for (int i : result) {
            arr[j++] = i;
        }
        return arr;
    }
}
