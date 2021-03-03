class SubtractProductAndSum {
    public int subtractProductAndSum(int n) {
        int digit = n % 10;
        int sum = digit;
        int product = digit;
        n = n / 10;
        while (n != 0) {
            sum += n % 10;
            product *= n % 10;
            n = n/10;
        }
        return product - sum;
    }
}
