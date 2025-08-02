class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();

        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[] {i,j});
                }
                if(grid[i][j]==1) fresh++;
            }
        }
        if(fresh==0) return 0;
        int minutes=0;
        int[][] directions={{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()){
            int s=q.size();
            boolean rotted=false;
            for(int i=0;i<s;i++){
                int[] arr=q.poll();
                int r=arr[0],c=arr[1];
                for(int[] dir:directions){
                    int nr=r+dir[0],nc=c+dir[1];
                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.add(new int[] {nr,nc});
                        rotted=true;
                        fresh--;
                    }
                }
            }
            if(rotted) minutes++;
        }
        if(fresh==0) return minutes ;
        else return -1;
    }
}