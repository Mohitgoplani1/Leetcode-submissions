class Solution {
    public int[] findOrder(int num, int[][] pre) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<num;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] arr:pre){
            adj.get(arr[1]).add(arr[0]);
        }
        int[] ind=new int[num];
        Arrays.fill(ind,0);
        for(List<Integer> arr:adj){
            for(int i:arr){
                ind[i]+=1;
            }
        }
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<ind.length;i++){
            if(ind[i]==0) q.add(i);
        }
        int count=0,k=0;
        int[] ans=new int[num];
        while(!q.isEmpty()){
            int node=q.poll();
            ans[k++]=node;
            count+=1;
            for(int i:adj.get(node)){
                ind[i]-=1;
                if(ind[i]==0) q.add(i);
            }
        }
        if(count==num) return ans;
        else return new int[0];
    }
}