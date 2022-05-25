// Brute force. Time limit exceeded
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] net = new int[n];
        for (int i = 0; i < n; i++) {
            net[i] = gas[i] - cost[i];
        }
        
        for (int i = 0; i < n; i++) {
            int gasLeft = 0;
            for (int j = i; j < gas.length + i +1; j++) {
                if (j == i + n) {
                    return i;
                }
                if (j > n - 1) {
                    gasLeft += net[j%n];
                } else {
                    gasLeft += net[j];
                }
                if (gasLeft < 0) {
                    break;
                }
            }
        }
        return -1;
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        int sum = 0;
        int minSum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + gas[i] - cost[i];
            if (sum < minSum) {
                minSum = sum;
                start = i + 1;
            }
        }
        if (sum < 0) return -1;
        return start == n ? 0 : start;
    }
}
