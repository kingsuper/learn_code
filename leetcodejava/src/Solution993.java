import java.util.HashMap;
import java.util.Map;

class Solution993 {
    Map<Integer, Integer> depth = new HashMap<Integer, Integer>();
    Map<Integer, TreeNode> parentmap = new HashMap<Integer, TreeNode>();

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null);
        return depth.get(x) == depth.get(y) && parentmap.get(x) != parentmap.get(y);
    }

    void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            System.out.println(node.val);
            depth.put(node.val, parent == null ? 0 : depth.get(parent) + 1);
            parentmap.put(node.val, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}