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
