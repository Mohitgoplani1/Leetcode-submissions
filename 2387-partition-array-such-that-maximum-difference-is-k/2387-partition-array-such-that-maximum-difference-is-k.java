class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count=0,start=0,end=0;
        int max=0,min=0;
        while(end<nums.length){
            if(start==end){
                max=nums[start];
                min=nums[start];
                end++;
            }
            else{
                max=Math.max(max,nums[end]);
                min=Math.min(min,nums[end]);
                if(max-min<=k)
                end++;
                else{
                    count+=1;
                    start=end;
                }
            }
        }
        return count+1;
    }
}