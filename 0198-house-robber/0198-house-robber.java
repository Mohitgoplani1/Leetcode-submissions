class Solution {
    public int rob(int[] nums) {
        int[] arr=new int[nums.length];
        Arrays.fill(arr,-1);
        return find(nums,arr,0);
    }
    public int find(int[] nums,int[] arr,int index){
        if(index>=nums.length) return 0;
        if(arr[index]!=-1) return arr[index];
        int take=nums[index]+find(nums,arr,index+2);
        int skip=find(nums,arr,index+1);
        return arr[index]=Math.max(take,skip);
    }
}