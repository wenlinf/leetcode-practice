class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int a = 0;
        int b = 0;
        Set<Integer> result = new HashSet<Integer>();
        while (a < nums1.length && b < nums2.length) {
            if (nums1[a] == nums2[b]) {
                result.add(nums1[a]);
                a++;
                b++;
            } else if (nums1[a] > nums2[b]) {
                b++;
            } else {
                a++;
            }
        }
        int[] intersections = new int[result.size()];
        int index = 0;
        for (int i : result) {
            intersections[index++] = i;
        }
        return intersections;
    }
}
