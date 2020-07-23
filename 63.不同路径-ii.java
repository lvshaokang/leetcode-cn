/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        // dp
        // 左上到[rows][cols]的路径数
        int[][] dp = new int[rows][cols];

        // 第1列
        // i < rows && obstacleGrid[i][0] == 0
        for (int i = 0; i < rows && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        // 第1行
        for (int j = 0; j < cols && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 0) {
                    // 状态转移方程
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[rows-1][cols-1];  
    }
}
// @lc code=end

