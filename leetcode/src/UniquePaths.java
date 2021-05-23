public class UniquePaths {
    public static int uniquePath(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;       //动态规划初始状态
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i - 1 >= 0 && i - 1 < m) {
                    dp[i][j] += dp[i - 1][j];       //状态转移方程式
                }
                if(j - 1 >= 0 && j - 1 < n) {
                    dp[i][j] += dp[i][j - 1];       //状态转移方程式
                }
            }
        }
        return dp[m - 1][n- 1];                     //终止状态
    }

    public static void main(String[] args) {
        int ret = uniquePath(3, 2);
        System.out.println(ret);
    }
}
