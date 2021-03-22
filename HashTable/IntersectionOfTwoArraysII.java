class IntersectionOfTwoArraysII {
     public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int currentCount = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i],1);
            } else {
                currentCount = map.get(nums1[i]);
                map.put(nums1[i], ++currentCount);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i])!=0) {
                list.add(nums2[i]);
                currentCount = map.get(nums2[i]);
                map.put(nums2[i], --currentCount);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
