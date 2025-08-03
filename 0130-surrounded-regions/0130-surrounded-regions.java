class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    List<int[]> region = new ArrayList<>();
                    boolean isEnclosed = dfs(board, i, j, vis, dir, region);

                    if (isEnclosed) {
                        for (int[] pos : region) {
                            board[pos[0]][pos[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] vis, int[][] dir, List<int[]> region) {
        int m = board.length;
        int n = board[0].length;
        vis[i][j] = true;
        region.add(new int[]{i, j});

        boolean enclosed = true;
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
            enclosed = false;
        }

        for (int[] d : dir) {
            int ni = i + d[0], nj = j + d[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && board[ni][nj] == 'O' && !vis[ni][nj]) {
                if (!dfs(board, ni, nj, vis, dir, region)) {
                    enclosed = false;
                }
            }
        }

        return enclosed;
    }
}
