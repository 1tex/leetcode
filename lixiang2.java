import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class lixiang2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 给你一棵二叉树的根节点，返回该树的 直径 。二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root。两节点之间路径的 长度 由它们之间边数表示。
     *
     * @param root TreeNode类 一个二叉树的根节点
     * @return int整型
     */
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // write code here
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        diameter = Math.max(diameter, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}