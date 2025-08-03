class Solution {
    public int numEnclaves(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        int rows = mat.length;
        int cols = mat[0].length;

        // Add border 'O's to queue
        for (int i = 0; i < rows; i++) {
            if (mat[i][0] == 1) {
                q.add(new int[]{i, 0});
                mat[i][0] = 5; // mark visited
            }
            if (mat[i][cols - 1] == 1) {
                q.add(new int[]{i, cols - 1});
                mat[i][cols - 1] = 5;
            }
        }
        for (int j = 0; j < cols; j++) {
            if (mat[0][j] == 1) {
                q.add(new int[]{0, j});
                mat[0][j] = 5;
            }
            if (mat[rows - 1][j] == 1) {
                q.add(new int[]{rows - 1, j});
                mat[rows - 1][j] = 5;
            }
        }

        // BFS to mark connected 'O's from borders
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int r = arr[0], c = arr[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && mat[nr][nc] == 1) {
                    mat[nr][nc] = 5;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        // Final update: flip remaining 'O' to 'X', and 'M' back to 'O'
        int count=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) count+=1;
            }
        }

        return count;
    }
}