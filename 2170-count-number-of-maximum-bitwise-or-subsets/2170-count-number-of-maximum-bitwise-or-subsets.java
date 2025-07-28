class Solution {
    int count=0;
    public int countMaxOrSubsets(int[] nums) {
        int max=0;
        for(int num:nums){
            max|=num;
        }
        helper(nums,0,0,max);
        return count;
    }
    public void helper(int[] nums,int index,int or,int max){
        if (index == nums.length) {
            if (or == max) {
                count++;
            }
            return;
        }
        helper(nums,index+1,or|nums[index],max);
        helper(nums,index+1,or,max);
    }
}