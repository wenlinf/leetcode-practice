/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> list;
    private int count;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new ArrayList<>();
        this.count = 0;
        int size = nestedList.size();
        for (int i = 0; i < size; i++) {
            NestedInteger node = nestedList.get(i);
            traverse(node);
        }
    }
    
    private void traverse(NestedInteger node) {
        if (node == null) return;
        if (node.isInteger()) {
            this.list.add(node.getInteger());
            return;
        }
        List<NestedInteger> children = node.getList();
        for (int i = 0; i < children.size(); i++) {
            traverse(children.get(i));
        }
    }

    @Override
    public Integer next() {
        Integer res = list.get(count);
        count++;
        return res;
    }

    @Override
    public boolean hasNext() {
        return count < list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
