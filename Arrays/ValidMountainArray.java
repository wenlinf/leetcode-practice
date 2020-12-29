class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        int pivot = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                pivot = i;
            } else if (arr[i] == arr[i-1]) {
                return false;
            } else {
                break;
            }
        }
        if (pivot == arr.length-1 || pivot == 0) return false;
        for (int i = pivot + 1; i < arr.length; i++) {
            if (arr[i] >= arr[i-1]) return false;
        }
        return true;
    }
}
