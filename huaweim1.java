class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class huaweim1 {
    int max_val;

    public int getMax_val(TreeNode root) {
        max_val = Integer.MIN_VALUE;
        get_path_val(root);
        return max_val;
    }

    private int get_path_val(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, get_path_val(node.left));
        int right = Math.max(0, get_path_val(node.right));
        max_val = Math.max(max_val, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
