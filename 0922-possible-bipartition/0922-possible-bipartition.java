class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill graph from dislikes (undirected edges)
        for(int[] d : dislikes) {
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }

        // -1: uncolored, 0 and 1 are the two colors
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        // BFS for each disconnected component
        for(int i = 1; i <= n; i++) {
            if(color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0;

                while(!q.isEmpty()) {
                    int u = q.poll();
                    for(int v : adj.get(u)) {
                        if(color[v] == -1) {
                            color[v] = color[u] ^ 1;
                            q.add(v);
                        } else if(color[v] == color[u]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
