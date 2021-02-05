class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    list.add(i);
                    continue;
                }
                list.add(i);
                list.add(num / i);
            }
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum - num == num;
    }
}
