class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int c;
        while (b != 0) {
            c = a ^ b;
            b = a & b;
            a = c ^ (b << 1);
            b = c & (b << 1);
            a = a ^ b;
        }
        return a;
    }
}
