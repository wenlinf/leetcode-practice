/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/


class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        List<Node> visited = new ArrayList<>();
        List<Node> queue = new ArrayList<>();
        
        queue.add(node);
        Map<Integer, Node> clonedNodes = new HashMap<>();
        clonedNodes.put(node.val, new Node(node.val));
        while(queue.size() != 0) {
            Node curr = queue.remove(0);
            visited.add(curr);
            if (!clonedNodes.containsKey(curr.val)) {
                clonedNodes.put(curr.val, new Node(curr.val));
            } 
            
            for (int i = 0; i < curr.neighbors.size(); i++) {
                int currNeighborVal = curr.neighbors.get(i).val;

                if (!clonedNodes.containsKey(currNeighborVal)) {
                    clonedNodes.put(currNeighborVal, new Node(currNeighborVal));
                } 
                clonedNodes.get(curr.val).neighbors.add(clonedNodes.get(currNeighborVal));
                if (!visited.contains(curr.neighbors.get(i)) && !queue.contains(curr.neighbors.get(i))) {
                    queue.add(curr.neighbors.get(i));
                }
            }
        }
        return clonedNodes.get(node.val);
    }
}
