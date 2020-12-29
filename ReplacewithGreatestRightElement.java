class ReplacewithGreatestRightElement {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length-1];
        int temp;
        arr[arr.length-1] = -1;
        for (int i = arr.length-2; i >= 0; i--) {
            temp = arr[i];
            arr[i] = max;
            if (temp > max) {
                max = temp;
            } 
        }
        return arr;
    }
}
