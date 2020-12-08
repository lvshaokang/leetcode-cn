/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checker(root.left, root.right);
    }

    /**
     * 递归
     * 
     * 二叉树对称 等价于 左子树的左和右子树的右镜像对称,左子树的右和右子树的左镜像对称
     * 
     * 注: 不要被递归套进去,去想它的每一步执行结果,而是想这个函数/节点,这一步做了什么,它的终止条件是什么
     * 即,不要去想细节
     */
    public boolean checker(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return checker(left.left, right.right) && checker(left.right, right.left);
    }
}
// @lc code=end

