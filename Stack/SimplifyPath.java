class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.equals(".") || dir.equals("")) {
                continue;
            }
            if (dir.equals("..")) {
                if (stack.size() > 0) stack.pop();
                continue;
            }
            stack.push(dir);
        }

        for (String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }
        
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
