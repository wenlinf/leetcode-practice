class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preq = prerequisites[i][1];
            adjList.get(preq).add(course);
            inDegree[course]++;
        }
        int start = -1;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                start = i;
                queue.add(i);
            }
        }
        if (start == -1) return new int[]{};
        
        int index = 0;
        while (!queue.isEmpty()) {
            int el = queue.poll();
            result[index] = el;
            visited.add(el);
            index++;
            List<Integer> children = adjList.get(el);
            for (int child: children) {
                if (visited.contains(child)) return new int[]{};
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    queue.add(child);
                }
            }   
        }
        if (visited.size() != numCourses) return new int[]{};
        return result;
    }
}
