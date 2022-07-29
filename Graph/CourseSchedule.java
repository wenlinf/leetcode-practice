class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            if (!adjList.containsKey(pre)) {
                adjList.put(pre, new ArrayList<>());
            }
            adjList.get(pre).add(course);
            inDegree[course]++;
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (adjList.containsKey(start)) {
                List<Integer> nextCourses = adjList.get(start);
                for (int course: nextCourses) {
                    inDegree[course]--;
                    if (inDegree[course] == 0) queue.add(course);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) return false;
        }
        return true;
    }
}
