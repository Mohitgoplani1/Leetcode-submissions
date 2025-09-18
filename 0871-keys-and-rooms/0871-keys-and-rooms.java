class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[rooms.size()];
        Arrays.fill(vis,false);
        q.add(0);
        while(!q.isEmpty()){
            int node=q.poll();
            vis[node]=true;
            for(int i:rooms.get(node)){
                if(!vis[i])
                q.add(i);
            }
        }
        for(int i=0;i<rooms.size();i++){
            if(vis[i]==false)
            return false;
        }
        return true;
    }
}