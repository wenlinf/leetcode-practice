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

// DFS solution
class Solution {
    private static int WHITE = 1;
    private static int GRAY = 2;
    private static int BLACK = 3;
    private boolean isPossible = true;
    private Map<Integer, List<Integer>> adjList;
    private Map<Integer, Integer> color;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.adjList = new HashMap<>();
        this.color = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            color.put(i, WHITE);
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            if (!adjList.containsKey(pre)) {
                adjList.put(pre, new ArrayList<>());
            }
            adjList.get(pre).add(course);
        }
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == WHITE) {
                dfs(i, result);
            }
        }
        if (!isPossible) return new int[0];
        int[] res = new int[numCourses];
        int index = 0;
        while (!result.isEmpty()) {
            res[index] = result.pop();
            index++;
        }
        return res;
    }
    
    private void dfs(int start, Stack<Integer> result) {
        if (!isPossible) return;
        this.color.put(start, GRAY);
        if (this.adjList.containsKey(start)) {
            List<Integer> neighbours = this.adjList.get(start);
            for (int neighbour : neighbours) {
                if (color.get(neighbour) == GRAY) {
                    isPossible = false; 
                    break;
                } else if (color.get(neighbour) == WHITE) {
                    dfs(neighbour, result);
                }
            }
        }
        
        this.color.put(start, BLACK);
        result.add(start);
    }
}
