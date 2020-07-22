/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // bound
        if (m == 0 || n == 0) {
            return 0;
        }

        // dp
        // 左上角到[m][n]的路径数
        int[][] dp = new int[m][n];

        // initial
        // 第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // 第一行
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 状态转移方程
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
// @lc code=end

