class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> outDegree = new HashMap<>();
        Set<String> recipesSet = new HashSet<>();
        Set<String> suppliesSet = new HashSet<>();
        int n = recipes.length;
        int m = supplies.length;
        for (int i = 0; i < m; i++) {
            suppliesSet.add(supplies[i]);
        }
        for (int i = 0; i < n; i++) {
            String recipe = recipes[i];
            recipesSet.add(recipe);
            adjList.put(recipe, new ArrayList<>());

            for (int j = 0; j < ingredients.get(i).size(); j++) {
                outDegree.put(recipe, outDegree.getOrDefault(recipe, 0) + 1);
                String ingredient = ingredients.get(i).get(j);
                adjList.get(recipe).add(ingredient);
                outDegree.put(ingredient, outDegree.getOrDefault(ingredient, 0));
            }
        }
        LinkedList<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : outDegree.entrySet()) {
            if (entry.getValue() == 0) {
                if (recipesSet.contains(entry.getKey()) && suppliesSet.contains(entry.getKey())) result.add(entry.getKey());
                queue.add(entry.getKey());
            }
        }
        while (!queue.isEmpty()) {
            String first = queue.poll();
            if (!suppliesSet.contains(first) && !recipesSet.contains(first)) continue;
            for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
                List<String> neighbors = entry.getValue();
                if (neighbors.contains(first)) {
                    neighbors.remove(first);
                    outDegree.put(entry.getKey(), outDegree.get(entry.getKey()) - 1);
                    if (outDegree.get(entry.getKey()) == 0) {
                        if (recipesSet.contains(entry.getKey())) {
                            result.add(entry.getKey());
                        }
                        queue.add(entry.getKey());
                    }
                }
            }
        }
        return result;
    }
}
