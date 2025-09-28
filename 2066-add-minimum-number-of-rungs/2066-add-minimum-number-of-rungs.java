class Solution {
    public int addRungs(int[] rungs, int dist) {
        int ans=0,index=0,curr=0;
        while(index!=rungs.length){
            if(dist>=(rungs[index]-curr)){
                curr=rungs[index++];
            }
            else{
                if((rungs[index]-curr)%dist==0)
                ans+=((rungs[index]-curr)/dist)-1;
                else ans+=(rungs[index]-curr)/dist;
                curr=rungs[index++];
            }
        }
        return ans;
    }
}