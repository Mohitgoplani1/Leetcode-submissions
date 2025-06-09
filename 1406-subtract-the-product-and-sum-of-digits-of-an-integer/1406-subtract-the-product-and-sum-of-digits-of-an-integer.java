class Solution {
    public int subtractProductAndSum(int n) {
        int prod=1,sum=0;
        while(n!=0){
            int t=n%10;
            n/=10;
            prod*=t;
            sum+=t;
        }
        return prod-sum;
    }
}