class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        Set<String> allStrs = new HashSet<>();
        
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            allStrs.add(dividend);
            allStrs.add(divisor);
            if (!map.containsKey(dividend)) {
                map.put(dividend, new HashMap<String, Double>());
            }
            map.get(dividend).put(divisor, values[i]);
            if (!map.containsKey(divisor)) {
                map.put(divisor, new HashMap<String, Double>());
            }
            map.get(divisor).put(dividend, 1 / values[i]);
        }
        
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            if (!allStrs.contains(queries.get(i).get(0)) || !allStrs.contains(queries.get(i).get(1))) {
                result[i] = -1;
            } else if (queries.get(i).get(0) == queries.get(i).get(1)) {
                result[i] = 1;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, map, visited); 
            }
        }
        return result;
    }
    
    public double dfs(String from, String to, double accProduct, Map<String, Map<String, Double>> map, Set<String> visited) {
        visited.add(from);
        double result = -1;
        
        Map<String, Double> adjMap = map.get(from);
        if (adjMap.containsKey(to)) {
            result = accProduct * adjMap.get(to);
        } else {
            for (Map.Entry<String,Double> entry : adjMap.entrySet()) {
                if (visited.contains(entry.getKey())) {
                    continue;
                } 
                result = dfs(entry.getKey(), to, accProduct * entry.getValue(), map, visited);
                if (result != -1.0) break;
            }
        }
        
        visited.remove(from);
        return result;
    }
}


class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind unionFind = new UnionFind();
    // traverse the equations list, union the elements
    for (int i = 0; i < equations.size(); i++) {
      String first = equations.get(i).get(0);
      String second = equations.get(i).get(1);
      unionFind.union(first, second, values[i]);
    }

    double[] result = new double[queries.size()];
    // traverse the queries and evaluate the equations
    for (int i = 0; i < queries.size(); i++) {
      String first = queries.get(i).get(0);
      String second = queries.get(i).get(1);
      if (!unionFind.root.containsKey(first) || !unionFind.root.containsKey(second)) {
        result[i] = -1;
      } else if (!unionFind.find(first).getKey().equals(unionFind.find(second).getKey())) {
        result[i] = -1;
      } else {
        Pair<String, Double> root = unionFind.find(first);
        result[i] = unionFind.root.get(first).getValue() / unionFind.root.get(second).getValue();
      }
    }
    return result;
    }
    
    public class UnionFind {
        private Map<String, Pair<String, Double>> root;
        private Map<String, Integer> rank;
        public Map<String, Map<String, Double>> values;
        
        
        public UnionFind() {
            this.root = new HashMap<>();
            this.rank = new HashMap<>();
            this.values = new HashMap<>();
        }
        
        public Pair<String, Double> find(String x) {
            if (root.get(x) == null) {
                root.put(x, new Pair<String, Double>(x, 1.0));
            }
            if (root.get(x).getKey().equals(x)) return root.get(x);
            Pair<String, Double> oldRoot = root.get(x);
            Pair<String, Double> newEntry = find(root.get(x).getKey());
            root.put(x, new Pair<String, Double>(newEntry.getKey(), newEntry.getValue() * oldRoot.getValue()));
            return root.get(x);
        }
        
         public void union(String x, String y, double weight) {
      Pair<String, Double> rootXPair = find(x);
      Pair<String, Double> rootYPair = find(y);
      String rootX = rootXPair.getKey();
      String rootY = rootYPair.getKey();
      if (!rootX.equals(rootY)) {
        if (rank.get(rootX) == null) {
          rank.put(rootX, 1);
        }
        if (rank.get(rootY) == null) {
          rank.put(rootY, 1);
        }
        if (rank.get(rootX) > rank.get(rootY)) {
          root.put(rootY, new Pair<>(rootX, rootXPair.getValue() /(weight * rootYPair.getValue())));
        } else if (rank.get(rootX) < rank.get(rootY)) {
          root.put(rootX, new Pair<>(rootY, (weight * rootYPair.getValue()) / rootXPair.getValue()));
        } else {
          root.put(rootX, new Pair<>(rootY, (weight * rootYPair.getValue()) / rootXPair.getValue()));
          rank.put(rootY, rank.get(rootY) + 1);
        }
      }
    }    
  }
}
