class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int readPointer = 0;
        int writePointer = 0;
        int temp;
        while (readPointer < A.length) {
            if (A[readPointer] % 2 == 0) {
                temp = A[writePointer];
                A[writePointer++] = A[readPointer];
                A[readPointer] = temp;
            }
            readPointer++;
        }
        return A;
    }
}
