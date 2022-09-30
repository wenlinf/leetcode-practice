/* 
Time complexity: 
adding elements to the heap takes O(NlogN) time in total. 
The rest of the algo takes O(N).
So it's O(NlogN) in total.
Space complexity:
O(n) because of the priority queue
*/
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 && secondList.length == 0) return new int[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
            });
        for (int[] first : firstList) {
            pq.add(first);
        }
        for (int[] second : secondList) {
            pq.add(second);
        }
        List<int[]> list = new ArrayList<>();
        int[] prev = pq.poll();
        while (pq.size() != 0) {
            int[] curr = pq.poll();
            if (curr[0] < prev[1]) {
                if (prev[1] < curr[1]) {
                    list.add(new int[]{curr[0], prev[1]});
                    prev = curr;
                } else {
                    list.add(new int[]{curr[0], curr[1]});
                } 
            } else if (curr[0] == prev[1]) {
                list.add(new int[]{curr[0], curr[0]});
                prev = curr;
            } else {
                prev = curr;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}

// Two pointer, O(n+m) time, O(1) or O(m+n) space?
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 && secondList.length == 0) return new int[0][0];
        int pt1 = 0;
        int pt2 = 0;
        List<int[]> list = new ArrayList<>();
        while (pt1 < firstList.length && pt2 < secondList.length) {
            int[] first = firstList[pt1];
            int[] second = secondList[pt2];
            if (second[0] > first[1]) {
                pt1++;
            } else if (first[0] > second[1]) {
                pt2++;
            } else if (first[0] == second[1]) {
                list.add(new int[]{first[0], first[0]});
                pt2++;
            } else if (first[1] == second[0]) {
                list.add(new int[]{first[1], first[1]});
                pt1++;
            } else if (first[0] < second[1]) {
                if (first[1] <= second[1]) {
                    list.add(new int[]{Math.max(first[0], second[0]), first[1]});
                    pt1++;
                } else {
                    list.add(new int[]{Math.max(first[0], second[0]), second[1]});
                    pt2++;
                }
            } else if (second[0] < first[1]) {
                if (second[1] <= first[1]) {
                    list.add(new int[]{Math.max(first[0], second[0]), second[1]});
                    pt2++;
                } else {
                    list.add(new int[]{Math.max(first[0], second[0]), first[1]});
                    pt1++;
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int pt1 = 0;
        int pt2 = 0;
        List<int[]> result = new ArrayList<>();
        while (pt1 < firstList.length && pt2 < secondList.length) {
            int[] first = firstList[pt1];
            int[] second = secondList[pt2];
            int firstStart = first[0];
            int firstEnd = first[1];
            int secondStart = second[0];
            int secondEnd = second[1];
            if (firstStart <= secondEnd && secondStart <= firstEnd) {
                result.add(new int[]{Math.max(firstStart, secondStart), Math.min(firstEnd, secondEnd)});
            }
            if (firstEnd < secondEnd) {
                pt1++;
            } else {
                pt2++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
