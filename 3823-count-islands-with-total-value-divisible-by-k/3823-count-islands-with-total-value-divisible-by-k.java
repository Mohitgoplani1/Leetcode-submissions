class Solution {
    public int countIslands(int[][] grid, int k) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!vis[i][j] && grid[i][j] > 0) {
                    int sum = dfs(grid, i, j, vis);
                    if (sum % k == 0) count++;
                }
            }
        }
        return count;
    }

    public int dfs(int[][] grid, int i, int j, boolean[][] vis) {
        vis[i][j] = true;
        int sum = grid[i][j];  // start with current cell
        int[] r = {-1, 0, 1, 0};
        int[] c = {0, -1, 0, 1};
        for (int d = 0; d < 4; d++) {
            int nr = r[d] + i;
            int nc = c[d] + j;
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length &&
                grid[nr][nc] > 0 && !vis[nr][nc]) {
                sum += dfs(grid, nr, nc, vis);  // accumulate
            }
        }
        return sum;
    }
}
