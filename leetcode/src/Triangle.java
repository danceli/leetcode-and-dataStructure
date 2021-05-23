import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static int minimumTotal(int[][] triangle) {
        int n = triangle.length;
        //dp[i][j]表示从点(i, j)到底边的最短路径
        int[][] dp = new int[n + 1][n + 1];
//        从三角形的最后一条边开始递推
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                //状态转移方程式
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
      int[][] arr = {{2},{3,4},{6,5,7},{4,1,8,3}};
      int ret = minimumTotal(arr);
        System.out.println(ret);
    }
}
