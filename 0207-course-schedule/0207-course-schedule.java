class Solution {
    public boolean canFinish(int num, int[][] pre) {
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
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count+=1;
            for(int i:adj.get(node)){
                ind[i]-=1;
                if(ind[i]==0) q.add(i);
            }
        }
        return count==num;
    }
}