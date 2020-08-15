/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 一棵高度平衡二叉树定义为
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1
     */
    public boolean isBalanced(TreeNode root) {

        // solution01(root);
        return solution02(root);
    }

    /**
     * 解法一
     * 自顶向下
     * <p>
     * 思路是构造一个获取当前节点最大深度的方法 depth(root)，通过比较此子树的左右子树的最大高度差
     * abs(depth(root.left) - depth(root.right))，来判断此子树是否是二叉平衡树
     * 若树的所有子树都平衡时，此树才平衡
     * 
     */
    public static boolean solution01(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean flag = Math.abs(depth(root.left) - depth(root.right)) <= 1 && solution01(root.left) && solution01(root.right);
        return flag;
    }

    /**
     * 获取当前节点的最大深度
     */
    private static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    /**
     * 解法二
     * 自底向上<最优解法>
     * <p>
     * 思路是对二叉树做先序遍历，从底至顶返回子树最大高度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回
     * 1. 当节点root左/右子树的高度差<2；则返回以节点root为根节点的子树的最大高度
     * 2. 当节点root左/右子树的高度差>=2；则返回-1，代表此子树不是平衡树
     */
    public static boolean solution02(TreeNode root) {
        return recursive(root) != -1;
    }

    private static int recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = recursive(root.left);
        if (left == -1) {
            return -1;
        }

        int right = recursive(root.right);
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1; 
    }
}
// @lc code=end

