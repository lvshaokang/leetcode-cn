/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev,p = l1,q = l2;

        // 逆序
        // (2 -> 4 -> 3) + (5 -> 6 -> 4)
        // 7 -> 0 -> 8
        // 342 + 465 = 807

        // 进位 *****
        int carry = 0;

        // 即只要一个不为空就可以进行计算，为空的那个赋值为0
        // 末尾补零，不影响计算(因为是逆序的)
        while (p != null || q != null) {
            // 末尾补零，不影响计算(因为是逆序的)
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            // 求和
            int sum = x + y + carry;

            // 进位的项是多少
            carry = sum / 10;

            // 生成新的节点
            head.next = new ListNode(sum % 10);
            // 指针后移
            head = head.next;

            // 指针后移
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        // 考虑第一位溢出的情况
        if (carry > 0) {
            head.next = new ListNode(carry);
        }

        return prev.next;
    }
}
// @lc code=end

