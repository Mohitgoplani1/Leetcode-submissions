class Solution {
    public int maxSum(int[] nums) {
        if(nums.length==1)
            return nums[0];
        HashSet<Integer> h=new HashSet<>();
        for(int a: nums){
            if(h.contains(a) || a<0)
                continue;
            else
                h.add(a);
        }
        int sum=0;
        for(int a:h){
            sum+=a;
        }
        if(sum!=0)
        return sum;
        else{
            sum=nums[0];
            for(int i=1;i<nums.length;i++){
                if(sum<nums[i])
                    sum=nums[i];
            }
        }
        return sum;
    }
}