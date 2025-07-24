import java.util.Arrays;

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return find(dp, n);
    }

    public int find(int[] dp, int n) {
        if (n == 0 || n == 1) return 1;
        if (dp[n] != -1) return dp[n];
        return dp[n] = find(dp, n - 1) + find(dp, n - 2);
    }
}
