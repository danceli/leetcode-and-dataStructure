public class Fibonacci {
    public static int fibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;          //动态规划初始状态
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];            //状态转移方程式
        }
        return dp[n];       //动态规划终止状态
    }

    public static void main(String[] args) {
        int ret = fibonacci(5);
        System.out.println(ret);
    }
}
