class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        boolean[] vis = new boolean[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            if (!vis[i]) {
                ans++;
                dfs(isConnected, i, vis);
            }
        }
        return ans;
    }

    private void dfs(int[][] connected, int node, boolean[] vis) {
        vis[node] = true;

        for (int i = 0; i < connected.length; i++) {
            if (connected[node][i] == 1 && !vis[i]) {
                dfs(connected, i, vis);
            }
        }
    }
}
