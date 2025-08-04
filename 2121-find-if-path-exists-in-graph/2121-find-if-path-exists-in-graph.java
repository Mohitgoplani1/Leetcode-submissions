class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis=new boolean[n];
        return dfs(adj,source,destination,vis);
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int src, int dest,boolean[] vis){
        vis[src]=true;
        if(src==dest) return true;
        boolean res=false;
        for(int i:adj.get(src)){
            if(!vis[i])
            res|=dfs(adj,i,dest,vis);
        }
        return res;
    }
}