import java.util.List;

public class Triangle120 { 
    //动态规划
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        //dp[i][j]表示从(i, j)到底边的最小路径和
        int[][] dp = new int[n + 1][n + 1];
        //从三角形的最底边开始递推
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];

    }

    public static void main(String[] args) {


    }
}
