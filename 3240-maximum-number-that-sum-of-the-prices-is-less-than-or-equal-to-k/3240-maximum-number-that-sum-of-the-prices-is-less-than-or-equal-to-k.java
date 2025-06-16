class Solution {
    public long findMaximumNumber(long k, int x) {
        long low=1l,high=(long)1e15,ans=0l;
        while(low<=high){
            long mid = low+(high-low)/2;
            if(possible(mid,x,k)){
                ans=Math.max(ans,mid);
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
    
    boolean possible(long num,int x,long k){
        long total=0;
        for(int i=1;i<=62;i++){
            if(i%x!=0) continue;
            long pow=(long)Math.pow(2,i);
            long set = num/pow;
            long rem = num%pow;
            long pow_2 = pow/2;
            total += set*pow_2;
            if(rem>=pow_2) total += rem+1-pow_2;
            if(total>k) return false;
        }
        return true;
    }
}