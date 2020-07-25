/*
 * @lc app=leetcode.cn id=1025 lang=java
 *
 * [1025] 除数博弈
 */

// @lc code=start
class Solution {
    public boolean divisorGame(int N) {
        // bound N < 2 (N == 1)
        if (N == 1) {
            return false;
        }

        // dp N >= 2
        // 操作数为i时，先手玩家的获胜情况
        // 0 1 2 ... N
        boolean[] dp = new boolean[N+1];
        dp[1] = false;
        dp[2] = true;

        for (int i = 3; i < N + 1; i++) {
            // 初始化为false
            dp[i] = false;

            // 最佳状态参与：都想对手输 dp[i-1] = false
            // x (0,N) -> [1,N)
            for (int x = 1; x < i; x++) {
                // 随机选择一个x，只要dp[i-x]中任意一个为false，那么dp[N]=true
                if (i % x == 0 && !dp[i-x]) {
                    dp[i] = true;
                    break;
                }
            }
        }
       
       
        return dp[N];
    }
}
// @lc code=end

