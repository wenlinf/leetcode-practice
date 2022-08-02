class ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        int[] inDegree = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < relations.length; i++) {
            int[] relation = relations[i];
            int prevCourse = relation[0];
            int nextCourse = relation[1];
            inDegree[nextCourse - 1]++;
            adjList.get(prevCourse - 1).add(nextCourse);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i + 1);
            }
        }
        if (queue.isEmpty()) return -1;
        int result = 0;
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            while (queueSize > 0) {
                int el = queue.poll();
                queueSize--;
                visited.add(el);
                List<Integer> children = adjList.get(el - 1);
                for (int child: children) {
                    if (visited.contains(child)) return -1;
                    inDegree[child - 1]--;
                    if (inDegree[child - 1] == 0) queue.add(child);
                } 
            }
            result++;
            
        }
        if (visited.size() != n) return -1;
        return result;
    }
}


class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[n + 1];
        inDegree[0] = -1;
        for (int[] relation : relations) {
            int from = relation[0];
            int to = relation[1];
            if (!adjList.containsKey(from)) {
                adjList.put(from, new ArrayList<>());
            }
            adjList.get(from).add(to);
            inDegree[to]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        int semesters = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            semesters++;
            while (levelSize > 0) {
                int start = queue.poll();
                levelSize--;
                if (adjList.containsKey(start)) {
                    List<Integer> neighbours = adjList.get(start);
                    for (int neighbour : neighbours) {
                        inDegree[neighbour]--;
                        if (inDegree[neighbour] == 0) queue.add(neighbour);
                    }
                }
                
            }
        }
        for (int i = 0; i <= n; i++) {
            if (inDegree[i] > 0) return -1;
        }
        return semesters;
    }
}
