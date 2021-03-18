class HappyNumber {
    private Set<Integer> seen = new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1) return true;
        int sum = 0;
        int digit = 0;
        while (n > 0) {
            digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        if (seen.contains(sum)) return false;
        seen.add(sum);
        return isHappy(sum);
    }
}
