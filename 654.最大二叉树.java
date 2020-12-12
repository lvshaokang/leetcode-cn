
/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
     * 需要找最大节点,以及遍历左右数组,递归
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        return support(nums, 0, nums.length);
    }

    // 构造辅助函数
    public TreeNode support(int[] nums, int l, int r) {
        // 递归结束条件
        if (l == r) {
            return null;
        }
        // 遍历数组,找最大值的索引
        int index = max(nums, l, r);
        TreeNode node = new TreeNode(nums[index]);
        node.left = support(nums, l, index);
        node.right = support(nums, index + 1, r);
        return node;
    }

    // 找某个区间的最大值的索引 l,r
    private int max(int[] nums, int l, int r) {
        int tmp = l;
        for (int i = l; i < r; i++) {
            int cur = nums[i];
            if (cur > nums[tmp]) {
                tmp = i; 
            }
        }
        return tmp;
    } 
}
// @lc code=end

