class Solution {
    public int islandPerimeter(int[][] grid) {
        int[] delrow={0,-1,0,1};
        int[] delcol={-1,0,1,0};
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int sur=0;
                    for(int k=0;k<4;k++){
                        int nr=i+delrow[k],nc=j+delcol[k];
                        if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                            sur+=1;
                        }
                    }
                    ans+=(4-sur);
                }
            }
        }
        return ans;
    }
}