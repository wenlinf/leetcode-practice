class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!frequency.containsKey(nums1[i])) {
                frequency.put(nums1[i], 1);
            } else {
                frequency.put(nums1[i], frequency.get(nums1[i]) + 1);
            }
        }
        Map<Integer, Integer> frequency2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!frequency2.containsKey(nums2[i])) {
                frequency2.put(nums2[i], 1);
            } else {
                frequency2.put(nums2[i], frequency2.get(nums2[i]) + 1);
            }
        }
        Map<Integer, Integer> resultMap = new HashMap<>();
        int charCount = 0;
        for (Map.Entry<Integer, Integer> entry: frequency.entrySet()) {
            if (frequency2.containsKey(entry.getKey())) {
                resultMap.put(entry.getKey(), Math.min(entry.getValue(), frequency2.get(entry.getKey())));
                charCount += Math.min(entry.getValue(), frequency2.get(entry.getKey()));
            }
        }
        int[] result = new int[charCount];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry: resultMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result[index++] = entry.getKey();
            }
        }
        return result;
    }
}
