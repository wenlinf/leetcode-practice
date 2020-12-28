class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        } else {
            int index = m-1;
            int temp = nums1[index];
            for (int i = 0; i < nums2.length; i++) {
                if (nums2[i] < nums1[index]){
                    while (index>=0 && nums2[i] < nums1[index]) {
                        temp = nums1[index];
                        nums1[index] = nums2[i];
                        nums1[index+1] = temp;
                        index--;
                    }
                } else {
                    nums1[index+1] = nums2[i];
                }
                index = m + i;
            }
        }
    }
}

//one solution using two pointers: https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/discuss/989064/Two-pointer-solution-wvideo-whiteboard-explanation
