class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Correct char comparison and visited check
                if (!vis[i][j] && grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j, vis);
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] vis) {
        // Boundary + water + already visited check
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
            || grid[i][j] == '0' || vis[i][j]) {
            return;
        }

        vis[i][j] = true;

        // Explore all 4 directions (up, down, left, right)
        dfs(grid, i + 1, j, vis);
        dfs(grid, i - 1, j, vis);
        dfs(grid, i, j + 1, vis);
        dfs(grid, i, j - 1, vis);
    }
}
