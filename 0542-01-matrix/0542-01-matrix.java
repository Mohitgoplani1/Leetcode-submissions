class Solution {
    public int[][] updateMatrix(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        int[][] ans=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j,0});
                    vis[i][j]=true;
                }
                else {
                    vis[i][j]=false;
                }
            }
        }
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r=arr[0],c=arr[1];
            ans[r][c]=arr[2];
            
            for(int i=0;i<4;i++){
                int nr=direction[i][0]+r;
                int nc=direction[i][1]+c;
                if(nr>=0 && nr<grid.length && nc<grid[0].length && nc>=0 && vis[nr][nc]==false){
                    q.add(new int[]{nr,nc,arr[2]+1});
                    vis[nr][nc]=true;
                }
            }
        }
        return ans;
    }
}