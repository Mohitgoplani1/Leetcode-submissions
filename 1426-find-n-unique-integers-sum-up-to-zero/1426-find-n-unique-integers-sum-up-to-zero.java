class Solution {
    public int[] sumZero(int n) {
        int start=1,total=0;
        List<Integer> l=new ArrayList<>(n);
        if(n%2!=0){
            l.add(0);
            total+=1;
        }
        while(total<n){
            l.add(start);
            l.add(start*-1);
            total+=1;
            start++;
        }
       int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = l.get(i);
        }
        return ans;
    }
}