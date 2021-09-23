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
        public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        } else {
            int pt1 = m-1;
            int pt2 = n-1;
            int insertIndex = m+n-1;
            while (pt2 >= 0) {
                if (pt1 < 0) {
                    for (int i = 0; i <= pt2; i++) {
                        nums1[i] = nums2[i];
                    }
                    break;
                } else if (nums1[pt1] < nums2[pt2]) {
                    nums1[insertIndex] = nums2[pt2];
                    pt2--;
                } else {
                    nums1[insertIndex] = nums1[pt1];
                    pt1--;
                }
                insertIndex--;
            }
        }
    }
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        //two pointers use m, n and another pointer for nums1
        n--;
        m--;
        int pointer = nums1.length - 1; // https://leetcode.com/problems/merge-sorted-array/discuss/29704/My-clean-java-solution in this solution he used m + n - 1
        //start looping through the two arrays from the end
        //first check the el at pointer m and pointer n, put the bigger one at the end of nums1
        //then decrease the pointer of the array that has the biggest value and compare the next two elements and repeat the steps above
        //until one of the pointers reaches the start of the array, end the loop
        while (m >= 0 && n >= 0) {
            if (nums2[n] >= nums1[m]) {
                nums1[pointer] = nums2[n];
                n--;
                pointer--;
            } else {
                nums1[pointer] = nums1[m];
                m--;
                pointer--;
            }
        }
        //if there are elements left in nums2, add them all to nums1
        if (n >= 0) {
            while (n >= 0) {
                nums1[pointer] = nums2[n];
                n--;
                pointer--;
            }
        }
        /* 
        in the other solution, the author was using
        while (m >= 0 && n >= 0) {
        nums1[pointer--] = (nums1[m] > nums2[n]) ? 
                             nums1[m--] : nums2[n--];
    }
        while (n >= 0) {
            nums1[pointer--] = nums2[n--];
        }
        neater than my code lol
        also my naming of these variables are horrible, need to improve
        */
    }
}

//one solution using two pointers: https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/discuss/989064/Two-pointer-solution-wvideo-whiteboard-explanation
